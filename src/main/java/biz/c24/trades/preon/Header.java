/*
 * $Id$
 */

package biz.c24.trades.preon;

/**
 * Class Header.
 * 
 * @version $Revision$ $Date$
 */
public class Header extends biz.c24.io.api.data.preon.IoPreonDataObject 
implements Cloneable
{

    /**
     * Our PreonTypeHandler
     */
    private static final biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = (biz.c24.io.api.preon.typeHandler.PreonTypeHandler2) biz.c24.io.api.data.preon.format.PreonSpecRegistryV2.getTypeHandler(2);

    public Header() {
    }

    public Header(byte[] data, int offset) {
        setPreonData(data, offset);
    }

    /**
     * 
     * 
     * @param buffer
     * @param offset
     */
    public static Header allocate(byte[] buffer,int offset) {
        Header object = new Header();
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
    public static Header allocate(byte[] data,int dataOffset,int preonOffset) {
        Header object = new Header();
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
    public String getAmount1() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        // Store the details of our presence bitmap
        final byte bitmask0 = preonTypeHandler.readByte(data, index + 0);
        index += preonTypeHandler.skipBitmask(data, index, getBitmaskLength(), getBitmaskLength());

        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Skip BuySell
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Currency1
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Read Amount1
        {
            return preonTypeHandler.readString(data, index);
        }
    }

    /**
     * Gets the value of amount2 (1).
     */
    public String getAmount2() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        // Store the details of our presence bitmap
        final byte bitmask0 = preonTypeHandler.readByte(data, index + 0);
        index += preonTypeHandler.skipBitmask(data, index, getBitmaskLength(), getBitmaskLength());

        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Skip BuySell
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Currency1
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Amount1
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Exchange Rate
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Currency2
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Read Amount2
        {
            return preonTypeHandler.readString(data, index);
        }
    }

    /**
     * Gets the value of anyType (0..1).
     */
    public String getAnyType() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        // Store the details of our presence bitmap
        final byte bitmask0 = preonTypeHandler.readByte(data, index + 0);
        index += preonTypeHandler.skipBitmask(data, index, getBitmaskLength(), getBitmaskLength());

        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Skip BuySell
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Currency1
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Amount1
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Exchange Rate
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Currency2
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Amount2
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Settlment Date
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Read anyType
        {
            if ((bitmask0 & 1) != 0) {
                return preonTypeHandler.readString(data, index);
            } else {
                return null;
            }
        }
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
     * Gets the value of buySell (1).
     */
    public String getBuySell() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        // Store the details of our presence bitmap
        final byte bitmask0 = preonTypeHandler.readByte(data, index + 0);
        index += preonTypeHandler.skipBitmask(data, index, getBitmaskLength(), getBitmaskLength());

        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Read BuySell
        {
            return preonTypeHandler.readString(data, index);
        }
    }

    /**
     * Returns the fully qualified class name of this class's
     * corresponding CDO
     */
    public String getComplexDataObjectName() {
        return "biz.c24.trades.Header";
    }

    /**
     * Gets the value of currency1 (1).
     */
    public String getCurrency1() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        // Store the details of our presence bitmap
        final byte bitmask0 = preonTypeHandler.readByte(data, index + 0);
        index += preonTypeHandler.skipBitmask(data, index, getBitmaskLength(), getBitmaskLength());

        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Skip BuySell
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Read Currency1
        {
            return preonTypeHandler.readString(data, index);
        }
    }

    /**
     * Gets the value of currency2 (1).
     */
    public String getCurrency2() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        // Store the details of our presence bitmap
        final byte bitmask0 = preonTypeHandler.readByte(data, index + 0);
        index += preonTypeHandler.skipBitmask(data, index, getBitmaskLength(), getBitmaskLength());

        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Skip BuySell
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Currency1
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Amount1
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Exchange Rate
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Read Currency2
        {
            return preonTypeHandler.readString(data, index);
        }
    }

    /**
     * Gets the value of exchangeRate (1).
     */
    public String getExchangeRate() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        // Store the details of our presence bitmap
        final byte bitmask0 = preonTypeHandler.readByte(data, index + 0);
        index += preonTypeHandler.skipBitmask(data, index, getBitmaskLength(), getBitmaskLength());

        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Skip BuySell
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Currency1
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Amount1
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Read Exchange Rate
        {
            return preonTypeHandler.readString(data, index);
        }
    }

    /**
     * Gets the value of iD (1).
     */
    public String getID() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        // Store the details of our presence bitmap
        final byte bitmask0 = preonTypeHandler.readByte(data, index + 0);
        index += preonTypeHandler.skipBitmask(data, index, getBitmaskLength(), getBitmaskLength());

        final int startOfBookmarkTable = index;

        // Read ID
        {
            return preonTypeHandler.readString(data, index);
        }
    }

    /**
     */
    public static biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 getPreonTypeHandler() {
        return preonTypeHandler;
    }

    /**
     * Gets the value of settlmentDate (1).
     */
    public java.time.LocalDate getSettlmentDate() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        // Store the details of our presence bitmap
        final byte bitmask0 = preonTypeHandler.readByte(data, index + 0);
        index += preonTypeHandler.skipBitmask(data, index, getBitmaskLength(), getBitmaskLength());

        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip TradeDate
        {
            index += preonTypeHandler.skipISO8601Date(data, index);
        }

        // Skip BuySell
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Currency1
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Amount1
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Exchange Rate
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Currency2
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Skip Amount2
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Read Settlment Date
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
        // Store the details of our presence bitmap
        final byte bitmask0 = preonTypeHandler.readByte(data, index + 0);
        index += preonTypeHandler.skipBitmask(data, index, getBitmaskLength(), getBitmaskLength());

        final int startOfBookmarkTable = index;

        // Skip ID
        {
            index += preonTypeHandler.skipString(data, index);
        }

        // Read TradeDate
        {
            return biz.c24.io.api.data.Java8Utils.fromIOType(preonTypeHandler.readISO8601Date(data, index));
        }
    }

}
