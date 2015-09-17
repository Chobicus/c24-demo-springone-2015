package biz.c24.io.demo;

import biz.c24.io.api.C24;
import biz.c24.io.api.data.Element;
import biz.c24.io.spring.batch.reader.C24ItemReader;
import biz.c24.io.spring.batch.reader.source.ZipFileSource;
import biz.c24.io.spring.core.C24Model;
import biz.c24.trades.Trade;
import biz.c24.trades.TradesElement;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.integration.launch.JobLaunchRequest;
import org.springframework.batch.integration.launch.JobLaunchingGateway;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.JobExecutionEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.SplitterEndpointSpec;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.AcceptOnceFileListFilter;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.RegexPatternFileListFilter;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.integration.splitter.ExpressionEvaluatingSplitter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Iain Porter
 * @author John Davies
 * @author Josh Long
 */
@SpringBootApplication
public class DemoApplication {

    public static final String TRADE_ITEM_WRITER_CHANNEL = "trade-item-writer-channel";
    public static final String HAZELCAST_ALL_OTHERS_CHANNEL = "hazelcast-all-others-channel";
    public static final String HAZELCAST_USD_CHANNEL = "hazelcast-usd-channel";

    private Log log = LogFactory.getLog(getClass());

    public static void main(String[] args) {
       SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner clr(HazelcastInstance hazelcastInstance) {
        return args -> {
            IMap<Integer, Object> other = hazelcastInstance.getMap("other");
            IMap<Integer, Object> usd = hazelcastInstance.getMap("usd");
            other.addIndex("BuySell", false);
            usd.addIndex("BuySell", false);
        };
    }

    @Bean
    HazelcastInstance server() {
        log.info(String.format("Running with max memory %s MB", Runtime.getRuntime().maxMemory() / (1024 * 1024)));
        log.info("starting Hazelcast instance..");

        Config config = new Config();
        return Hazelcast.newHazelcastInstance(config);
    }
}


@Configuration
class IntegrationConfiguration {


    private File inboundReadDirectory, inboundProcessedDirectory, inboundFailedDirectory;

    @Autowired
    public void configureFiles(@Value("${inbound.read.path}") File inboundReadDirectory,
                               @Value("${inbound.processed.path}") File inboundProcessedDirectory,
                               @Value("${inbound.failed.path}") File inboundFailedDirectory) {
        this.inboundFailedDirectory = inboundFailedDirectory;
        this.inboundProcessedDirectory = inboundProcessedDirectory;
        this.inboundReadDirectory = inboundReadDirectory;
    }


    // GLOBALS
    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedDelay(1000).get();
    }

    // GLOBAL CHANNELS

    @Bean
    public MessageChannel inboundFilePollingChannel() {
        return MessageChannels.queue().get();
    }

    @Bean
    public MessageChannel logger() {
        return MessageChannels.queue().get();
    }

    @Bean(name = DemoApplication.TRADE_ITEM_WRITER_CHANNEL)
    public MessageChannel tradeItemWriterChannel() {
        return MessageChannels.queue().get();
    }

    @Bean
    public MessageChannel tradeContentRouterChannel() {
        return MessageChannels.queue().get();
    }

    @Bean(name = DemoApplication.HAZELCAST_ALL_OTHERS_CHANNEL)
    public MessageChannel hazelcastAllOthersChannel() {
        return MessageChannels.queue().get();
    }


    @Bean(name = DemoApplication.HAZELCAST_USD_CHANNEL)
    public MessageChannel hazelcastUsdChannel() {
        return MessageChannels.queue().get();
    }

    /// read files into batch job
    @Bean
    public IntegrationFlow readFilesToBatchJobIntegration(
            @Value("${inbound.file.poller.fixed.delay}") long period,
            @Value("${inbound.file.poller.max.messages.per.poll}") int maxMsgsPerPoll,
            TaskExecutor taskExecutor,
            Job fileLoader,
            JobLaunchingGateway gateway,
            MessageSource<File> fileMessageSource) {

        return IntegrationFlows.from(
                fileMessageSource,
                c -> c.poller(Pollers.fixedDelay(period)
                        .taskExecutor(taskExecutor)
                        .maxMessagesPerPoll(maxMsgsPerPoll)))
                .transform((File file) -> {
                    String fileName = file.getAbsolutePath();
                    if (!fileName.startsWith("/")) {
                        fileName = "/" + fileName;
                    }
                    fileName = "file://" + fileName;

                    JobParameters jobParameters = new JobParametersBuilder()
                            .addString("input.file", fileName)
                            .toJobParameters();

                    if (fileLoader.getJobParametersIncrementer() != null) {
                        jobParameters = fileLoader.getJobParametersIncrementer().getNext(jobParameters);
                    }
                    return new JobLaunchRequest(fileLoader, jobParameters);
                })
                .handle(gateway)
                .channel(this.logger())
                .get();
    }

    @Bean
    public FileReadingMessageSource fileMessageSource(@Value("${inbound.filename.regex}") String regex) {
        FileReadingMessageSource file = new FileReadingMessageSource();
        file.setDirectory(this.inboundReadDirectory);
        file.setAutoCreateDirectory(true);

        CompositeFileListFilter<File> filter = new CompositeFileListFilter<>(
                Arrays.asList(new AcceptOnceFileListFilter<>(),
                        new RegexPatternFileListFilter(regex)));
        file.setFilter(filter);
        return file;
    }

    @Bean
    public JobLaunchingGateway batchJobLaunchingGateway(JobLauncher jobLauncher) {
        return new JobLaunchingGateway(jobLauncher);
    }

    @Bean
    public IntegrationFlow loggingFlow() {
        return IntegrationFlows.from(this.logger())
                .handle(this.loggingHandler())
                .get();
    }

    @Bean
    public MessageHandler loggingHandler() {
        LoggingHandler warn = new LoggingHandler("WARN");
        warn.setShouldLogFullMessage(true);
        return warn;
    }

}


@Configuration
@EnableBatchProcessing
class TradeParserBatchJobConfiguration {


    @Bean
    public Job fileLoaderJob(JobBuilderFactory jobs, Step s1) {
        return jobs.get("fileLoaderJob")
                .incrementer(new RunIdIncrementer())
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory,
                     C24ItemReader reader,
                     TradeItemWriter writer) {
        return stepBuilderFactory.get("parseFile")
                .chunk(1000)
                .reader(reader)
                .writer(writer)
                .throttleLimit(8)
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new ResourcelessTransactionManager();
    }

    @Bean
    @StepScope
    public ZipFileSource zipFileSource() {
        return new ZipFileSource();
    }

    @Bean
    public TaskExecutor taskExecutor(@Value("${thread-pool.size}") int corePoolSize) {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        return threadPoolTaskExecutor;
    }

    @Bean
    public C24Model tradeModel() {
        Element tradesElement = TradesElement.getInstance();
        return new C24Model(tradesElement);
    }

    @Bean
    @StepScope
    public C24ItemReader ioItemReader(ZipFileSource zipFileSource, C24Model tradeModel) {
        C24ItemReader c24ItemReader = new C24ItemReader();
        c24ItemReader.setSource(zipFileSource);
        c24ItemReader.setElementStartPattern(".*");
        c24ItemReader.setModel(tradeModel);
        c24ItemReader.setValidate(true);
        return c24ItemReader;
    }


    @Component
    public static class TradeItemWriter
            implements ItemWriter<Object> {

        @Autowired
        @Qualifier(DemoApplication.TRADE_ITEM_WRITER_CHANNEL)
        private MessageChannel messageChannel;

        @Override
        public void write(List<?> list) throws Exception {
            list.forEach(x -> this.messageChannel.send(MessageBuilder.withPayload(x).build()));
        }
    }

    @Component
    public static class BatchJobFinishedListener
            implements ApplicationListener<JobExecutionEvent> {

        @Override
        public void onApplicationEvent(JobExecutionEvent jobExecutionEvent) {
            LogFactory.getLog(getClass()).info(".. finished " + jobExecutionEvent.getJobExecution().toString());
        }
    }
}


@Configuration
class HazelcastIntegration {

    @Bean
    public IntegrationFlow tradeWrites(
            @Qualifier(DemoApplication.TRADE_ITEM_WRITER_CHANNEL) MessageChannel channel,
            @Qualifier(DemoApplication.HAZELCAST_USD_CHANNEL) MessageChannel usd,
            @Qualifier(DemoApplication.HAZELCAST_ALL_OTHERS_CHANNEL) MessageChannel others) {
        return IntegrationFlows.from(channel)
                .split()
                .split("payload.trade", (org.springframework.integration.dsl.support.Consumer<SplitterEndpointSpec<ExpressionEvaluatingSplitter>>) null)
                .transform((Trade trade) -> { // regular trade to SDO trade
                    try {
                        biz.c24.trades.sdo.Trade sdoTrade = C24.toSdo(trade);
                        return sdoTrade;
                    } catch (IOException e) {
                        throw new RuntimeException("Trade could not be transformed to SDO", e);
                    }
                })
                .route(new AbstractMessageRouter() {
                    @Override
                    protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
                        biz.c24.trades.sdo.Trade cast = biz.c24.trades.sdo.Trade.class.cast(message.getPayload());
                        return Collections.singletonList(cast.getCurrency1().equalsIgnoreCase("USD") ? usd : others);
                    }
                })
                .get();
    }


    @Bean
    public IntegrationFlow usd(
            @Qualifier(DemoApplication.HAZELCAST_USD_CHANNEL) MessageChannel usd,
            HazelcastInstance instance) {
        return IntegrationFlows.from(usd)
                .handle(new TradeWritingMessageHandler(instance.getMap("usd")))
                .get();
    }

    @Bean
    public IntegrationFlow others(
            @Qualifier(DemoApplication.HAZELCAST_ALL_OTHERS_CHANNEL) MessageChannel others,
            HazelcastInstance instance) {
        return IntegrationFlows.from(others)
                .handle(new TradeWritingMessageHandler(instance.getMap("other")))
                .get();
    }
}

class TradeWritingMessageHandler implements MessageHandler {

    private AtomicInteger counter = new AtomicInteger();
    private Log log = LogFactory.getLog(getClass());
    private IMap<Long, biz.c24.trades.sdo.Trade> tradesIMap;

    public TradeWritingMessageHandler(IMap<Long, biz.c24.trades.sdo.Trade> tradesIMap) {
        this.tradesIMap = tradesIMap;
    }

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        Object payload = message.getPayload();
        biz.c24.trades.sdo.Trade t = biz.c24.trades.sdo.Trade.class.cast(payload);
        this.tradesIMap.put(t.getID(), t);
        int currentCount = counter.incrementAndGet();
        if (currentCount % 1000 == 0) {
            log.info(String.format("Processed %,d messages", currentCount));
        }
    }
}
