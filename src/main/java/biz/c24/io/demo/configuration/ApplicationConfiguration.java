package biz.c24.io.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.MessageChannel;

/**
 * Global Bean Configurations
 *
 */
@Configuration
public class ApplicationConfiguration {

    public static final String TRADE_ITEM_WRITER_CHANNEL = "trade-item-writer-channel";
    public static final String HAZELCAST_ALL_OTHERS_CHANNEL = "hazelcast-all-others-channel";
    public static final String HAZELCAST_USD_CHANNEL = "hazelcast-usd-channel";

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

    @Bean(name = TRADE_ITEM_WRITER_CHANNEL)
    public MessageChannel tradeItemWriterChannel() {
        return MessageChannels.direct().get();
    }

    @Bean
    public MessageChannel tradeContentRouterChannel() {
        return MessageChannels.direct().get();
    }

    @Bean(name = HAZELCAST_ALL_OTHERS_CHANNEL)
    public MessageChannel hazelcastAllOthersChannel() {
        return MessageChannels.direct().get();
    }


    @Bean(name = HAZELCAST_USD_CHANNEL)
    public MessageChannel hazelcastUsdChannel() {
        return MessageChannels.direct().get();
    }
}
