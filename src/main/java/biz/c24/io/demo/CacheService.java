package biz.c24.io.demo;

import biz.c24.io.demo.hazelcast.HazelcastClient;
import biz.c24.io.demo.monitor.ConcurrentCounterService;
import biz.c24.trades.sdo.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class CacheService {

    private HazelcastClient hazelcastClient;
    private ConcurrentCounterService counter;

    @Autowired
    public CacheService(final HazelcastClient hazelcastClient) {
        this.hazelcastClient = hazelcastClient;
        counter = new ConcurrentCounterService();
    }

    public Message<?> writeToUsdCache(Message<?> message) {
        hazelcastClient.getUsdCurrencyMap().put(((Trade)message.getPayload()).getID(), message.getPayload());
        counter.count();
        return message;
    }

    public Message<?> writeToOtherCurrenciesCache(Message<?> message) {
        hazelcastClient.getOtherCurrenciesMap().put(((Trade)message.getPayload()).getID(), message.getPayload());
        counter.count();
        return message;
    }


}
