package biz.c24.io.demo.client;


import biz.c24.io.demo.hazelcast.HazelcastClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QueryClient {

    HazelcastClient hazelcastClient;

    public static void main(String[] args) throws Exception {
        QueryClient client = new QueryClient();
        client.doConsole();

    }

    public QueryClient() {
        hazelcastClient = new HazelcastClient();
    }



    private static void printHelp() {

    }

    private void doConsole() throws Exception {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        boolean done = false;
        while(!done) {
            System.out.print("> ");
            String line = in.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line);
            String firstArg = tokenizer.nextToken();
            if(firstArg.equals("q")) {
                done = true;
            } else if (firstArg.equals("all")) {
                queryAllCache(tokenizer);
            } else if (firstArg.equals("usd")) {
                queryUsdCache(tokenizer);
            }
        }
        System.exit(0);
    }

    private void queryUsdCache(StringTokenizer tokenizer) {
        String command = tokenizer.nextToken();
        if(command.equals("size")) {
            System.out.print(String.format("Cache Size %,d", hazelcastClient.getUsdCurrencyMap().size()));
            System.out.println();
        }
    }

    private void queryAllCache(StringTokenizer tokenizer) {
        String command = tokenizer.nextToken();
        if(command.equals("size")) {
            System.out.print(String.format("Cache Size %,d", hazelcastClient.getOtherCurrenciesMap().size()));
            System.out.println();
        }
    }
}
