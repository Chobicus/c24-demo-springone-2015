package biz.c24.io.demo;

import biz.c24.io.api.data.Element;
import biz.c24.io.demo.configuration.ApplicationConfiguration;
import biz.c24.io.spring.batch.reader.C24ItemReader;
import biz.c24.io.spring.batch.reader.source.ZipFileSource;
import biz.c24.io.spring.core.C24Model;
import biz.c24.trades.TradesElement;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.batch.JobExecutionEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

/**
 * Spring Batch Job to take trades from incoming zip files and parse them before sending
 * them on to a Spring Integration flow in batches for further processing
 *
 * @author Iain Porter
 * @author John Davies
 * @author Josh Long
 */
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
                .taskExecutor(taskExecutor(8))
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
        @Qualifier(ApplicationConfiguration.TRADE_ITEM_WRITER_CHANNEL)
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