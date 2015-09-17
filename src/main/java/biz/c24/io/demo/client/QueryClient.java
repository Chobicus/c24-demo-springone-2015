package biz.c24.io.demo.client;


import biz.c24.io.demo.hazelcast.HazelcastClient;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.Predicates;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class QueryClient {

    private HazelcastClient hazelcastClient;

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
        while (!done) {
            System.out.print("> ");
            String line = in.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line);
            String firstArg = tokenizer.nextToken();
            if (firstArg.equals("q")) {
                done = true;
            } else if (firstArg.equals("other")) {
                queryAllCache(tokenizer);
            } else if (firstArg.equals("usd")) {
                queryUsdCache(tokenizer);
            }
        }
        System.exit(0);
    }

    private void queryUsdCache(StringTokenizer tokenizer) {
        String command = tokenizer.nextToken();
        if (command.equals("size")) {
            System.out.print(String.format("Cache Size %,d", hazelcastClient.getUsdCurrencyMap().size()));
            System.out.println();
        }
    }

    private void queryAllCache(StringTokenizer tokenizer) {
        if(tokenizer.countTokens() == 1) {
            String command = tokenizer.nextToken();
            if (command.equals("size")) {
                System.out.print(String.format("Cache Size %,d", hazelcastClient.getOtherCurrenciesMap().size()));
                System.out.println();
            } else {
                printHelp();
            }
        } else {
            buildAndExecutePredicates(tokenizer);
        }
    }

    private void buildAndExecutePredicates(StringTokenizer tokenizer) {
        Predicate left = null;
        Predicate predicate = null;
        if (tokenizer.countTokens() > 1) {
            left = getPredicate(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
        } else {
            printHelp();
        }
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
        System.out.print(String.format("Result Size: %,d", hazelcastClient.getOtherCurrenciesMap().values(predicate).size()));
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
