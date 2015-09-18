package biz.c24.io.demo.integration;

import biz.c24.io.api.C24;
import biz.c24.io.demo.configuration.ApplicationConfiguration;
import biz.c24.trades.Trade;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.SplitterEndpointSpec;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.integration.splitter.ExpressionEvaluatingSplitter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

/**
 * Spring Integration flow takes a list of biz.c24.trades.Trades splits them into single biz.c24.trades.Trade
 * Objects and routes them to different caches based on Currency values
 *
 * @author Iain Porter
 * @author John Davies
 * @author Josh Long
 */
@Configuration
public class TradeMessageRoutingIntegration {

    @Bean
    public IntegrationFlow tradeWrites(
            @Qualifier(ApplicationConfiguration.TRADE_ITEM_WRITER_CHANNEL) MessageChannel channel,
            @Qualifier(ApplicationConfiguration.HAZELCAST_USD_CHANNEL) MessageChannel usd,
            @Qualifier(ApplicationConfiguration.HAZELCAST_ALL_OTHERS_CHANNEL) MessageChannel others) {
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
            @Qualifier(ApplicationConfiguration.HAZELCAST_USD_CHANNEL) MessageChannel usd,
            HazelcastInstance instance) {
        return IntegrationFlows.from(usd)
                .handle(new TradeWritingMessageHandler(instance.getMap("usd"), "USD"))
                .get();
    }

    @Bean
    public IntegrationFlow others(
            @Qualifier(ApplicationConfiguration.HAZELCAST_ALL_OTHERS_CHANNEL) MessageChannel others,
            HazelcastInstance instance) {
        return IntegrationFlows.from(others)
                .handle(new TradeWritingMessageHandler(instance.getMap("other"), "Others"))
                .get();
    }
}
