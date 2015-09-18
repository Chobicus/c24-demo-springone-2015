package biz.c24.io.demo.integration;

import biz.c24.trades.sdo.Trade;
import com.hazelcast.core.IMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Spring Integration component responsible for writing entries to a cache
 *
 * @author Iain Porter
 * @author John Davies
 * @author Josh Long
 */
public class TradeWritingMessageHandler implements MessageHandler {

    private AtomicInteger counter = new AtomicInteger();
    private Log log = LogFactory.getLog(getClass());
    private IMap<Long, Trade> cache;
    private final String cacheName;

    public TradeWritingMessageHandler(IMap<Long, biz.c24.trades.sdo.Trade> tradesIMap, String name) {
        this.cache = tradesIMap;
        this.cacheName = name;
    }

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        Object payload = message.getPayload();
        biz.c24.trades.sdo.Trade t = biz.c24.trades.sdo.Trade.class.cast(payload);
        this.cache.put(t.getID(), t);
        int currentCount = counter.incrementAndGet();
        if (currentCount % 10000 == 0) {
            log.info(String.format("%s: Processed %,d messages", cacheName, currentCount));
        }
    }
}
