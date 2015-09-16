package biz.c24.io.demo;

import biz.c24.io.api.C24;
import biz.c24.trades.sdo.Trade;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SdoTransformer {

    public Trade transform(biz.c24.trades.Trade trade) {
        try {
            return C24.toSdo(trade);
        } catch (IOException e) {
            throw new RuntimeException("Trade could not be transformed to SDO", e);
        }
    }
}
