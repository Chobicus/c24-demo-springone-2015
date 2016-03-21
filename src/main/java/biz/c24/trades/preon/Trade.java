/*
 * $Id$
 */

package biz.c24.trades.preon;

/**
 * Class Trade.
 * 
 * @version $Revision$ $Date$
 */
public class Trade extends biz.c24.io.api.data.preon.IoPreonDataObject 
implements Cloneable
{

    /**
     * Our PreonTypeHandler
     */
    private static final biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = (biz.c24.io.api.preon.typeHandler.PreonTypeHandler2) biz.c24.io.api.data.preon.format.PreonSpecRegistryV2.getTypeHandler(2);

    /**
     * Field BuySellCommonValues.
     */
    public static final String[] BuySellCommonValues = new String[]{"Buy", "Sell"};

    /**
     * Field Currency1CommonValues.
     */
    public static final String[] Currency1CommonValues = new String[]{"AUD", "CHF", "EUR", "GBP", "JPY", "USD"};

    /**
     * Field Currency2CommonValues.
     */
    public static final String[] Currency2CommonValues = new String[]{"AUD", "CHF", "EUR", "GBP", "JPY", "USD"};

    public Trade() {
    }

    public Trade(byte[] data, int offset) {
        setPreonData(data, offset);
    }

    /**
     * 
     * 
     * @param buffer
     * @param offset
     */
    public static Trade allocate(byte[] buffer,int offset) {
        Trade object = new Trade();
        object.setPreonData(buffer, offset);
        return object;
    }

    /**
     * 
     * 
     * @param data
     * @param preonOffset
     * @param dataOffset
     */
    public static Trade allocate(byte[] data,int dataOffset,int preonOffset) {
        Trade object = new Trade();
        object.setPreonData(data, dataOffset, preonOffset);
        return object;
    }

    /**
     */
    public java.lang.Object clone() {
        return super.clone();
    }

    /**
     * Gets the value of amount1 (1).
     */
    public java.math.BigDecimal getAmount1() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipLong(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Skip BuySell
        {
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.BuySellCommonValues);
        }

        // Skip Currency1
        {
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.Currency1CommonValues);
        }

        // Read Amount1
        {
            return preonTypeHandler.readBigDecimal(data, index);
        }
    }

    /**
     * Gets the value of amount2 (1).
     */
    public java.math.BigDecimal getAmount2() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipLong(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Skip BuySell
        {
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.BuySellCommonValues);
        }

        // Skip Currency1
        {
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.Currency1CommonValues);
        }

        // Skip Amount1
        {
            index += preonTypeHandler.skipBigDecimal(data, index);
        }

        // Skip Exchange Rate
        {
            index += preonTypeHandler.skipDouble(data, index);
        }

        // Skip Currency2
        {
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.Currency2CommonValues);
        }

        // Read Amount2
        {
            return preonTypeHandler.readBigDecimal(data, index);
        }
    }

    /**
     * Gets the value of buySell (1).
     */
    public String getBuySell() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipLong(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Read BuySell
        {
            return preonTypeHandler.readString(data, index, biz.c24.trades.preon.Trade.BuySellCommonValues);
        }
    }

    /**
     * Returns the fully qualified class name of this class's
     * corresponding CDO
     */
    public String getComplexDataObjectName() {
        return "biz.c24.trades.Trade";
    }

    /**
     * Gets the value of currency1 (1).
     */
    public String getCurrency1() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipLong(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Skip BuySell
        {
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.BuySellCommonValues);
        }

        // Read Currency1
        {
            return preonTypeHandler.readString(data, index, biz.c24.trades.preon.Trade.Currency1CommonValues);
        }
    }

    /**
     * Gets the value of currency2 (1).
     */
    public String getCurrency2() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipLong(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Skip BuySell
        {
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.BuySellCommonValues);
        }

        // Skip Currency1
        {
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.Currency1CommonValues);
        }

        // Skip Amount1
        {
            index += preonTypeHandler.skipBigDecimal(data, index);
        }

        // Skip Exchange Rate
        {
            index += preonTypeHandler.skipDouble(data, index);
        }

        // Read Currency2
        {
            return preonTypeHandler.readString(data, index, biz.c24.trades.preon.Trade.Currency2CommonValues);
        }
    }

    /**
     * Gets the value of exchangeRate (1).
     */
    public double getExchangeRate() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipLong(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Skip BuySell
        {
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.BuySellCommonValues);
        }

        // Skip Currency1
        {
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.Currency1CommonValues);
        }

        // Skip Amount1
        {
            index += preonTypeHandler.skipBigDecimal(data, index);
        }

        // Read Exchange Rate
        {
            return preonTypeHandler.readDouble(data, index);
        }
    }

    /**
     * Gets the value of iD (1).
     */
    public long getID() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        final int startOfBookmarkTable = index;

        // Read ID
        {
            return preonTypeHandler.readLong(data, index);
        }
    }

    /**
     */
    public static biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 getPreonTypeHandler() {
        return preonTypeHandler;
    }

    /**
     * Gets the value of settlementDate (1).
     */
    public java.time.LocalDate getSettlementDate() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipLong(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Skip BuySell
        {
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.BuySellCommonValues);
        }

        // Skip Currency1
        {
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.Currency1CommonValues);
        }

        // Skip Amount1
        {
            index += preonTypeHandler.skipBigDecimal(data, index);
        }

        // Skip Exchange Rate
        {
            index += preonTypeHandler.skipDouble(data, index);
        }

        // Skip Currency2
        {
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.Currency2CommonValues);
        }

        // Skip Amount2
        {
            index += preonTypeHandler.skipBigDecimal(data, index);
        }

        // Read Settlement Date
        {
            return biz.c24.io.api.data.Java8Utils.fromIOType(preonTypeHandler.readISO8601Date(data, index));
        }
    }

    /**
     * Gets the value of tradeDate (1).
     */
    public java.time.LocalDate getTradeDate() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipLong(data, index);
        }

        // Read TradeDate
        {
            return biz.c24.io.api.data.Java8Utils.fromIOType(preonTypeHandler.readISO8601Date(data, index));
        }
    }

}
