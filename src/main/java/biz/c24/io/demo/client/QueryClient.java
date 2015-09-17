package biz.c24.io.demo.client;


import biz.c24.io.api.data.DataType;
import biz.c24.io.api.data.LocalDateDataType;
import biz.c24.io.api.java8.C24;
import biz.c24.io.demo.hazelcast.HazelcastClient;
import biz.c24.trades.sdo.Trade;
import com.hazelcast.core.IMap;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.Predicates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Collection;
import java.util.StringTokenizer;

public class QueryClient {

    private HazelcastClient hazelcastClient;

    private IMap<Long, Trade> currentCache;

    private int limit = 0;

    public static void main(String[] args) throws Exception {
        QueryClient client = new QueryClient();
        client.doConsole();

    }

    public QueryClient() {
        hazelcastClient = new HazelcastClient();
        currentCache = hazelcastClient.getOtherCurrenciesMap(); //default
    }


    private static void printHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------- Query Client Help -------------\n")
                .append("Default cache is \"other\"\n\n")
                .append("1. Change cache\n")
                .append("> usd\n")
                .append("> other\n\n")
                .append("2. Get size of current cache\n")
                .append("> size\n\n")
                .append("3. Execute queries\n")
                .append("<Attribute name> <Operand> <Value>\n\n")
                .append("e.g.\n")
                .append("BuySell = Buy\n\n")
                .append("Can also combine predicates with and|or\n\n")
                .append("e.g.\n")
                .append("BuySell = Buy and Currency1 = GBP and Currency2 = USD\n\n")
                .append("4. Get a single object from the cache by Id\n\n")
                .append("> get <id>\n\n")
                .append("e.g.\n")
                .append("> get 100\n\n")
                .append("5. Return the first n results by setting limit\n\n")
                .append("> limit 10\n\n")
                .append("-------------------------------------\n");

        System.out.print(sb.toString());
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
                if (firstArg.equalsIgnoreCase("q")) {
                    done = true;
                } else if (firstArg.equalsIgnoreCase("h")) {
                    printHelp();
                } else if (firstArg.equals("other")) {
                    currentCache = hazelcastClient.getOtherCurrenciesMap();
                } else if (firstArg.equals("usd")) {
                    currentCache = hazelcastClient.getUsdCurrencyMap();
                } else if (firstArg.equals("size")) {
                    querySize();
                } else if (firstArg.equals("get")) {
                    getItem(peek.nextToken());
                } else if (firstArg.equals("limit")) {
                    limit = Integer.parseInt(peek.nextToken());
                } else {
                    queryCache(tokenizer);
                }
            } catch (Exception e) {
                System.out.print("\n>");
            }
        }
        System.exit(0);
    }

    private void getItem(String id) throws IOException {
        C24.write(C24.toCdo(currentCache.get(Long.parseLong(id))), System.out);
        System.out.print("\n>");
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
            Collection<Trade> result = currentCache.values(predicate);
            System.out.println(String.format("Result Size: %,d", result.size()));
            result.stream().limit(limit).forEach(sdo -> {
                try {
                    C24.write(C24.toCdo(sdo), System.out);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                ;
            });
        }
    }

    private Predicate buildPredicates(StringTokenizer tokenizer) {
        Predicate predicate = null;
        Predicate left = null;
        while(tokenizer.hasMoreTokens()) {
            if(predicate != null) {
                left = predicate;
            } else {
                left = getPredicate(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
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
        }
        return predicate;

    }

    private Predicate getPredicate(String property, String operator, String value) {
        Comparable queryValue = convertValue(property, value);
        if (operator.equals("=")) {
            return Predicates.equal(property, queryValue);
        } else if(operator.equals(">")) {
            return Predicates.greaterThan(property, queryValue);
        } else if(operator.equals("<")) {
            return Predicates.lessThan(property, queryValue);
        } else if(operator.equals(">=")) {
            return Predicates.greaterEqual(property, queryValue);
        } else if(operator.equals("<=")) {
            return Predicates.lessEqual(property, queryValue);
        }
        return null;
    }

    private Comparable convertValue(String property, String value) {

        biz.c24.trades.Trade trade = new biz.c24.trades.Trade();
        DataType dataType = trade.getElementDecl(property).getType();
        if(dataType instanceof LocalDateDataType) {
            return LocalDate.parse(value);
        }
        return value;
    }

}
