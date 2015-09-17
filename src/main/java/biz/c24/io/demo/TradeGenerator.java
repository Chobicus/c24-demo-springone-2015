package biz.c24.io.demo;


import biz.c24.io.api.C24;
import biz.c24.trades.Trade;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TradeGenerator {

    private static Map<String, Double> currencyRates = null;

    static {
        currencyRates = new HashMap<>(7);

        currencyRates.put("GBP", 1.0);
        currencyRates.put("EUR", 1.2521);
        currencyRates.put("USD", 1.6818);
        currencyRates.put("AUD", 1.8061);
        currencyRates.put("CHF", 1.5240);
        currencyRates.put("JPY", 172.54);
        currencyRates.put("CAD", 1.8362);
    }

    private static LongAdder adder = new LongAdder();


    public static void main(String[] args) {
        List<Trade> trades = createTrades(100);
        writeToFile(trades);
    }

    private static void writeToFile(List<Trade> trades) {
        System.out.println("Writing to disk\n");

        ZipOutputStream zos = null;
        try {
            File file = new File("trades_" + trades.size() + "_messages.zip");
            zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            ZipEntry ze = new ZipEntry("trades_" + trades.size() + "_messages.csv");
            zos.putNextEntry(ze);
            for (Trade trade : trades) {
                zos.write(C24.write(trade).toStr().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(zos != null) {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Done\n");


    }

    private static List<Trade> createTrades(int numTrades) {
        final Stream<Trade> tradeStream = Stream.generate(() -> {
            return createRandomTrade();
        });

        System.out.print(String.format("Creating %,d trades...", numTrades));

        List<Trade> trades = tradeStream
                .limit(numTrades)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Done\n");

        return trades;
    }


    public static Trade createRandomTrade() {
        Trade trade = new biz.c24.trades.Trade();
        Random randomGen = new Random();

        // Try out the new Java 8 Longadder
        adder.add(1);
        trade.setID(adder.longValue());

        // Now we want a random weekday in August
        LocalDate startingDate = LocalDate.of(2014, Month.AUGUST, 1);
        LocalDate tradeDate;
        do {
            tradeDate = startingDate.plusDays(randomGen.nextInt(startingDate.lengthOfMonth()-1));    // Add a random number of days
        } while ( tradeDate.getDayOfWeek() == DayOfWeek.SUNDAY || tradeDate.getDayOfWeek() == DayOfWeek.SATURDAY ); // Do it again if it's a weekend
        trade.setTradeDate(tradeDate);

        // Random Buy/Sell
        String temp = "BuySell";
        trade.setBuySell(randomGen.nextBoolean() ? temp.substring(0,3) : temp.substring(3,7));

        // Get an array of currencyRates from the Map
        String[] currencyArray = currencyRates.keySet().toArray(new String[0]);

        // Pick one of the currencyRates by random
        trade.setCurrency1(currencyArray[randomGen.nextInt(currencyArray.length)].substring(0,3));

        // Now set the second currency but loop until it's different from the first
        do {
            trade.setCurrency2(currencyArray[randomGen.nextInt(currencyArray.length)].substring(0,3));
        } while( trade.getCurrency2().equals( trade.getCurrency1() ));

        // A random amount from 1 to 50 million in whole millions
        trade.setAmount1(BigDecimal.valueOf((randomGen.nextInt(50) + 1) * 1_000_000));

        // Calculate the exchange rate from the Map
        double rate = currencyRates.get(trade.getCurrency2()) / currencyRates.get(trade.getCurrency1());

        // Now vary the exchange rate by a random amount, Gaussian distribution with a SD of 0.5%
        rate *= (1.0 + randomGen.nextGaussian()/200.0);
        rate = BigDecimal.valueOf(rate).setScale(5, BigDecimal.ROUND_UP).doubleValue();
        trade.setExchangeRate(rate);
        trade.setAmount2(trade.getAmount1().multiply(BigDecimal.valueOf(trade.getExchangeRate())));

        // Set the settlement date randomly from 7 to 4 weeks from the trade date
        LocalDate settmentDate = tradeDate.plusDays(7 * (randomGen.nextInt(3) + 1));
        trade.setSettlementDate(settmentDate);

        return trade;
    }
}
