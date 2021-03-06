package biz.c24.io.demo.hazelcast;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.stereotype.Component;

/**
 * Hazelcast client with default config
 *
 * @param <T>
 */
public class HazelcastClient<T> {

    private HazelcastInstance client;
    private IMap<Integer, T> usdCurrencyMap;
    private IMap<Integer, T> otherCurrenciesMap;


    public HazelcastClient() {
        initialise();
    }

    private void initialise() {
        ClientConfig clientConfig = new ClientConfig();
        client = com.hazelcast.client.HazelcastClient.newHazelcastClient( clientConfig );
        usdCurrencyMap = client.getMap("usd");
        otherCurrenciesMap = client.getMap("other");
    }

    public IMap<Integer, T> getUsdCurrencyMap() {
        return usdCurrencyMap;
    }

    public IMap<Integer, T> getOtherCurrenciesMap() {
        return otherCurrenciesMap;
    }


}
