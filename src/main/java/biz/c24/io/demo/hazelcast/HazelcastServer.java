package biz.c24.io.demo.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelcastServer {

    public HazelcastServer() {
        init();
    }

    public  void init() {

        output("Running with max mem", Runtime.getRuntime().maxMemory() / (1024 * 1024), "MB");

        output("Starting Hazelcast server");


        Config config = new Config();
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);

    }

    private  void output(Object... messages) {
        for(Object message : messages) {
            System.out.print(message instanceof String? message : message.toString());
            System.out.print(' ');
        }
        System.out.println();
    }
}
