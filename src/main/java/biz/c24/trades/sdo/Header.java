/*
 * $Id$
 */

package biz.c24.trades.sdo;

/**
 * Class Header.
 * 
 * @author C24 Integration Objects;
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 */
public class Header extends biz.c24.io.api.data.IoSimpleDataObject {

    /**
     * Field serialVersionUID.
     */
    private static final long serialVersionUID = 14L;

    /**
     * Field sdoTypeHandler.
     */
    private static final biz.c24.io.api.data.SdoTypeHandler sdoTypeHandler = biz.c24.io.api.presentation.SdoSpecRegistry.getTypeHandler(1);

    /**
     * Field shell.
     */
    private static ThreadLocal<Header> shell = new ThreadLocal<Header>() {
		protected Header initialValue() {
			return new Header();
		}
	};

    public Header() {
    }

    public Header(byte[] data, int offset) {
        setSdoData(data, offset);
    }

    /**
     * 
     * 
     * @param buffer
     * @param offset
     */
    public static Header allocate(byte[] buffer,int offset) {
        Header object = shell.get();
        object.setSdoData(buffer, offset);
        return object;
    }

    /**
     * Gets the value of Amount1 (1).
     * 
     * @return The value.
     */
    public java.lang.String getAmount1() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipISO8601Date(data, index);

        // Skipping component 'BuySell'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Currency1'
        index += sdoTypeHandler.skipString(data, index);

        return sdoTypeHandler.readString(data ,index);
    }

    /**
     * Gets the value of Amount2 (1).
     * 
     * @return The value.
     */
    public java.lang.String getAmount2() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipISO8601Date(data, index);

        // Skipping component 'BuySell'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Currency1'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Amount1'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Exchange Rate'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Currency2'
        index += sdoTypeHandler.skipString(data, index);

        return sdoTypeHandler.readString(data ,index);
    }

    /**
     * Gets the value of anyType (0..1).
     * 
     * @return The value.
     */
    public java.lang.String getAnyType() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipISO8601Date(data, index);

        // Skipping component 'BuySell'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Currency1'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Amount1'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Exchange Rate'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Currency2'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Amount2'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Settlment Date'
        index += sdoTypeHandler.skipISO8601Date(data, index);

        int bitmask0 = index;
        index += sdoTypeHandler.skipBitmask(data, index, getBitmaskLength(), getBitmaskLength());
        if (!sdoTypeHandler.isBitSet(data, bitmask0, 0, getBitmaskLength(), getBitmaskLength())) {
            return null;
        }

        return sdoTypeHandler.readString(data ,index);
    }

    /**
     * Returns the number of bits in the bitmask that this type
     * uses to indicate the presence of optional attributes and
     * elements.
     */
    public int getBitmaskLength() {
        return 1;
    }

    /**
     * Gets the value of BuySell (1).
     * 
     * @return The value.
     */
    public java.lang.String getBuySell() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipISO8601Date(data, index);

        return sdoTypeHandler.readString(data ,index);
    }

    /**
     * Returns the fully qualified class name of this class's
     * corresponding CDO
     */
    public String getComplexDataObjectName() {
        return "biz.c24.trades.Header";
    }

    /**
     * Gets the value of Currency1 (1).
     * 
     * @return The value.
     */
    public java.lang.String getCurrency1() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipISO8601Date(data, index);

        // Skipping component 'BuySell'
        index += sdoTypeHandler.skipString(data, index);

        return sdoTypeHandler.readString(data ,index);
    }

    /**
     * Gets the value of Currency2 (1).
     * 
     * @return The value.
     */
    public java.lang.String getCurrency2() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipISO8601Date(data, index);

        // Skipping component 'BuySell'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Currency1'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Amount1'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Exchange Rate'
        index += sdoTypeHandler.skipString(data, index);

        return sdoTypeHandler.readString(data ,index);
    }

    /**
     * Gets the value of ExchangeRate (1).
     * 
     * @return The value.
     */
    public java.lang.String getExchangeRate() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipISO8601Date(data, index);

        // Skipping component 'BuySell'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Currency1'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Amount1'
        index += sdoTypeHandler.skipString(data, index);

        return sdoTypeHandler.readString(data ,index);
    }

    /**
     * Gets the value of ID (1).
     * 
     * @return The value.
     */
    public java.lang.String getID() {
        int index = getBufferOffset();
        return sdoTypeHandler.readString(data ,index);
    }

    /**
     * Gets the value of SettlmentDate (1).
     * 
     * @return The value.
     */
    public java.time.LocalDate getSettlmentDate() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'TradeDate'
        index += sdoTypeHandler.skipISO8601Date(data, index);

        // Skipping component 'BuySell'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Currency1'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Amount1'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Exchange Rate'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Currency2'
        index += sdoTypeHandler.skipString(data, index);

        // Skipping component 'Amount2'
        index += sdoTypeHandler.skipString(data, index);

        return biz.c24.io.api.data.Java8Utils.fromIOType(sdoTypeHandler.readISO8601Date(data, index));
    }

    /**
     * Gets the value of TradeDate (1).
     * 
     * @return The value.
     */
    public java.time.LocalDate getTradeDate() {
        int index = getBufferOffset();
        // Skipping component 'ID'
        index += sdoTypeHandler.skipString(data, index);

        return biz.c24.io.api.data.Java8Utils.fromIOType(sdoTypeHandler.readISO8601Date(data, index));
    }

}
