package biz.c24.io.demo;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Iain Porter
 * @author John Davies
 * @author Josh Long
 */
@SpringBootApplication
public class DemoApplication {

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
        log.info("starting Hazelcast instance..");
        Config config = new Config();
        return Hazelcast.newHazelcastInstance(config);
    }
}






