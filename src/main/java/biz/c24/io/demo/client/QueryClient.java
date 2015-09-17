package biz.c24.io.demo.client;


import biz.c24.io.demo.hazelcast.HazelcastClient;
import biz.c24.trades.sdo.Trade;
import com.hazelcast.core.IMap;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.Predicates;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QueryClient {

    private HazelcastClient hazelcastClient;

    private IMap<Long, Trade> currentCache;

    public static void main(String[] args) throws Exception {
        QueryClient client = new QueryClient();
        client.doConsole();

    }

    public QueryClient() {
        hazelcastClient = new HazelcastClient();
        currentCache = hazelcastClient.getOtherCurrenciesMap(); //default
    }


    private static void printHelp() {

    }

    private void doConsole() throws Exception {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        boolean done = false;
        while (!done) {
            try {
                System.out.print("> ");
                String line = in.readLine();
                StringTokenizer peek = new StringTokenizer(line);
                StringTokenizer tokenizer = new StringTokenizer(line);
                String firstArg = peek.nextToken();
                if (firstArg.equals("q")) {
                    done = true;
                } else if (firstArg.equals("other")) {
                    currentCache = hazelcastClient.getOtherCurrenciesMap();
                } else if (firstArg.equals("usd")) {
                    currentCache = hazelcastClient.getUsdCurrencyMap();
                } else if (firstArg.equals("size")) {
                    querySize();
                } else {
                    queryCache(tokenizer);
                }
            } catch (Exception e) {
                printHelp();
            }
        }
        System.exit(0);
    }

    private void querySize() {
        System.out.print(String.format("Cache Size %,d", currentCache.size()));
        System.out.println();
    }

    private void queryCache(StringTokenizer tokenizer) {
        if(tokenizer.countTokens() < 2) {
                printHelp();
        } else {
            Predicate predicate = buildPredicates(tokenizer);
            System.out.print(String.format("Result Size: %,d", currentCache.values(predicate).size()));
        }
    }

    private Predicate buildPredicates(StringTokenizer tokenizer) {
        Predicate predicate = null;
        Predicate left = null;
        while(tokenizer.hasMoreTokens()) {
            left = getPredicate(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
            if(tokenizer.hasMoreTokens()) {
                String operand = tokenizer.nextToken();
                if(operand.equalsIgnoreCase("and")) {
                    Predicate right = getPredicate(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
                    predicate = Predicates.and(left, right);
                } else if (operand.equalsIgnoreCase("or")) {
                    Predicate right = getPredicate(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
                    predicate = Predicates.or(left, right);
                }
            } else {
                predicate = left;
            }
        }
        return predicate;

    }

    private Predicate getPredicate(String property, String operator, String value) {

        if (operator.equals("=")) {
            return Predicates.equal(property, value);
        } else if(operator.equals(">")) {
            return Predicates.greaterThan(property, value);
        } else if(operator.equals("<")) {
            return Predicates.lessThan(property, value);
        } else if(operator.equals(">=")) {
            return Predicates.greaterEqual(property, value);
        } else if(operator.equals("<=")) {
            return Predicates.lessEqual(property, value);
        }
        return null;
    }
}
