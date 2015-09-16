package biz.c24.io.demo.monitor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentCounterService {

    private final static Logger LOG = LoggerFactory.getLogger(ConcurrentCounterService.class);

    AtomicInteger counter = new AtomicInteger();

    public void count() {
        int currentCount = counter.incrementAndGet();
        if(currentCount % 1000 ==0 ) {
            LOG.info("Processed {} messages", currentCount);
        }
    }
}
