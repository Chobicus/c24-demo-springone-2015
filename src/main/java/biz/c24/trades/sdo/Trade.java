/*
 * $Id$
 */

package biz.c24.trades.sdo;

/**
 * Class Trade.
 * 
 * @author C24 Integration Objects;
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 */
public class Trade extends biz.c24.io.api.data.IoSimpleDataObject {

    /**
     * Field serialVersionUID.
     */
    private static final long serialVersionUID = 12L;

    /**
     * Field sdoTypeHandler.
     */
    private static final biz.c24.io.api.data.SdoTypeHandler sdoTypeHandler = biz.c24.io.api.presentation.SdoSpecRegistry.getTypeHandler(1);

    /**
     * Field BuySellCommonValues.
     */
    protected static final String[] BuySellCommonValues = new String[]{"Buy", "Sell"};

    /**
     * Field Currency1CommonValues.
     */
    protected static final String[] Currency1CommonValues = new String[]{"EUR", "USD", "GBP", "AUD", "CHF", "JPY"};

    /**
     * Field Currency2CommonValues.
     */
    protected static final String[] Currency2CommonValues = new String[]{"EUR", "USD", "GBP", "AUD", "CHF", "JPY"};

    /**
     * Field shell.
     */
    private static ThreadLocal<Trade> shell = new ThreadLocal<Trade>() {
		protected Trade initialValue() {
			return new Trade();
		}
	};

    public Trade() {
    }

    public Trade(byte[] data, int offset) {
        setSdoData(data, offset);
    }

    /**
     * 
     * 
     * @param buffer
     * @param offset
     */
    public static Trade allocate(byte[] buffer,int offset) {
        Trade object = shell.get();
        object.setSdoData(buffer, offset);
        return object;
    }

    /**
     * Gets the value of Amount1 (1).
     * 
     * @return The value.
     */
    public java.math.BigDecimal getAmount1() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipInt(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipDateTime(data, index, true, true);

        // Skipping component 'BuySell'
        index += sdoTypeHandler.skipString(data, index, BuySellCommonValues);

        // Skipping component 'Currency1'
        index += sdoTypeHandler.skipString(data, index, Currency1CommonValues);

        return sdoTypeHandler.readBigDecimal(data, index);
    }

    /**
     * Gets the value of Amount2 (1).
     * 
     * @return The value.
     */
    public java.math.BigDecimal getAmount2() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipInt(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipDateTime(data, index, true, true);

        // Skipping component 'BuySell'
        index += sdoTypeHandler.skipString(data, index, BuySellCommonValues);

        // Skipping component 'Currency1'
        index += sdoTypeHandler.skipString(data, index, Currency1CommonValues);

        // Skipping component 'Amount1'
        index += sdoTypeHandler.skipBigDecimal(data, index);

        // Skipping component 'Exchange Rate'
        index += sdoTypeHandler.skipDouble(data, index);

        // Skipping component 'Currency2'
        index += sdoTypeHandler.skipString(data, index, Currency2CommonValues);

        return sdoTypeHandler.readBigDecimal(data, index);
    }

    /**
     * Gets the value of BuySell (1).
     * 
     * @return The value.
     */
    public java.lang.String getBuySell() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipInt(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipDateTime(data, index, true, true);

        return sdoTypeHandler.readString(data ,index, BuySellCommonValues);
    }

    /**
     * Returns the fully qualified class name of this class's
     * corresponding CDO
     */
    public String getComplexDataObjectName() {
        return "biz.c24.trades.Trade";
    }

    /**
     * Gets the value of Currency1 (1).
     * 
     * @return The value.
     */
    public java.lang.String getCurrency1() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipInt(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipDateTime(data, index, true, true);

        // Skipping component 'BuySell'
        index += sdoTypeHandler.skipString(data, index, BuySellCommonValues);

        return sdoTypeHandler.readString(data ,index, Currency1CommonValues);
    }

    /**
     * Gets the value of Currency2 (1).
     * 
     * @return The value.
     */
    public java.lang.String getCurrency2() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipInt(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipDateTime(data, index, true, true);

        // Skipping component 'BuySell'
        index += sdoTypeHandler.skipString(data, index, BuySellCommonValues);

        // Skipping component 'Currency1'
        index += sdoTypeHandler.skipString(data, index, Currency1CommonValues);

        // Skipping component 'Amount1'
        index += sdoTypeHandler.skipBigDecimal(data, index);

        // Skipping component 'Exchange Rate'
        index += sdoTypeHandler.skipDouble(data, index);

        return sdoTypeHandler.readString(data ,index, Currency2CommonValues);
    }

    /**
     * Gets the value of ExchangeRate (1).
     * 
     * @return The value.
     */
    public double getExchangeRate() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipInt(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipDateTime(data, index, true, true);

        // Skipping component 'BuySell'
        index += sdoTypeHandler.skipString(data, index, BuySellCommonValues);

        // Skipping component 'Currency1'
        index += sdoTypeHandler.skipString(data, index, Currency1CommonValues);

        // Skipping component 'Amount1'
        index += sdoTypeHandler.skipBigDecimal(data, index);

        return sdoTypeHandler.readDouble(data, index);
    }

    /**
     * Gets the value of ID (1).
     * 
     * @return The value.
     */
    public int getID() {
        int index = getBufferOffset();
        return sdoTypeHandler.readInt(data ,index);
    }

    /**
     * Gets the value of SettlementDate (1).
     * 
     * @return The value.
     */
    public synchronized java.time.LocalDateTime getSettlementDate() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipInt(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipDateTime(data, index, true, true);

        // Skipping component 'BuySell'
        index += sdoTypeHandler.skipString(data, index, BuySellCommonValues);

        // Skipping component 'Currency1'
        index += sdoTypeHandler.skipString(data, index, Currency1CommonValues);

        // Skipping component 'Amount1'
        index += sdoTypeHandler.skipBigDecimal(data, index);

        // Skipping component 'Exchange Rate'
        index += sdoTypeHandler.skipDouble(data, index);

        // Skipping component 'Currency2'
        index += sdoTypeHandler.skipString(data, index, Currency2CommonValues);

        // Skipping component 'Amount2'
        index += sdoTypeHandler.skipBigDecimal(data, index);

        return java.time.LocalDateTime.ofInstant(sdoTypeHandler.readDateTime(data, index, true, true).getTime().toInstant(), java.time.ZoneId.systemDefault());
    }

    /**
     * Gets the value of TradeDate (1).
     * 
     * @return The value.
     */
    public synchronized java.time.LocalDateTime getTradeDate() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipInt(data, index);

        return java.time.LocalDateTime.ofInstant(sdoTypeHandler.readDateTime(data, index, true, true).getTime().toInstant(), java.time.ZoneId.systemDefault());
    }

}
