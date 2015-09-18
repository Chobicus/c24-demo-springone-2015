package biz.c24.io.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.integration.launch.JobLaunchRequest;
import org.springframework.batch.integration.launch.JobLaunchingGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.AcceptOnceFileListFilter;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.RegexPatternFileListFilter;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.io.File;
import java.util.Arrays;

/**
 * @author Iain Porter
 * @author John Davies
 * @author Josh Long
 */
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


    @Bean
    public MessageChannel logger() {
        return MessageChannels.direct().get();
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
