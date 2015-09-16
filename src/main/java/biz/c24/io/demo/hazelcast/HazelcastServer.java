package biz.c24.io.demo.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class HazelcastServer {

    public HazelcastServer() {
        init();
    }

    public  void init() {

        output("Running with max mem", Runtime.getRuntime().maxMemory() / (1024 * 1024), "MB");

        output("Starting Hazelcast server");


        Config config = new Config();
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        IMap<Integer, Object> all = hazelcastInstance.getMap("all");
        IMap<Integer, Object> usd = hazelcastInstance.getMap("all");
        all.addIndex("BuySell", false);



    }

    private  void output(Object... messages) {
        for(Object message : messages) {
            System.out.print(message instanceof String? message : message.toString());
            System.out.print(' ');
        }
        System.out.println();
    }
}
