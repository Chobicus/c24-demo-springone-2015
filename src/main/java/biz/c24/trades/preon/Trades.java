/*
 * $Id$
 */

package biz.c24.trades.preon;

/**
 * Class Trades.
 * 
 * @version $Revision$ $Date$
 */
public class Trades extends biz.c24.io.api.data.preon.IoPreonDataObject 
implements Cloneable
{

    /**
     * Our PreonTypeHandler
     */
    private static final biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = (biz.c24.io.api.preon.typeHandler.PreonTypeHandler2) biz.c24.io.api.data.preon.format.PreonSpecRegistryV2.getTypeHandler(2);

    public Trades() {
    }

    public Trades(byte[] data, int offset) {
        setPreonData(data, offset);
    }

    /**
     * 
     * 
     * @param buffer
     * @param offset
     */
    public static Trades allocate(byte[] buffer,int offset) {
        Trades object = new Trades();
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
    public static Trades allocate(byte[] data,int dataOffset,int preonOffset) {
        Trades object = new Trades();
        object.setPreonData(data, dataOffset, preonOffset);
        return object;
    }

    /**
     */
    public java.lang.Object clone() {
        return super.clone();
    }

    /**
     * Returns the fully qualified class name of this class's
     * corresponding CDO
     */
    public String getComplexDataObjectName() {
        return "biz.c24.trades.Trades";
    }

    /**
     */
    public static biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 getPreonTypeHandler() {
        return preonTypeHandler;
    }

    /**
     * Gets the value of trade (1..*).
     */
    public java.util.List<biz.c24.trades.preon.Trade> getTrade() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        final int startOfBookmarkTable = index;

        // Read Trade
        {
            int cardinality = preonTypeHandler.readInt(data, index);
            index += preonTypeHandler.skipInt(data, index);
            java.util.List<biz.c24.trades.preon.Trade> list = new java.util.LinkedList<biz.c24.trades.preon.Trade>();
            for(int i=0; i < cardinality; i++) {
                int length = preonTypeHandler.readInt(data, index);
                index += preonTypeHandler.skipInt(data, index);
                index += length;
                list.add((biz.c24.trades.preon.Trade) biz.c24.trades.preon.Trade.allocate(data, dataOffset, index - length).clone());
            }
            return list;
        }
    }

    /**
     * Gets the value of trade (1..*).
     * 
     * @param ordinal
     */
    public biz.c24.trades.preon.Trade getTrade(int ordinal) {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        final int startOfBookmarkTable = index;

        // Read Trade
        {
            int cardinality = preonTypeHandler.readInt(data, index);
            index += preonTypeHandler.skipInt(data, index);
            for(int i=0; i < cardinality; i++) {
                int length = preonTypeHandler.readInt(data, index);
                index += preonTypeHandler.skipInt(data, index);
                index += length;
                if (i == ordinal) {
                    return biz.c24.trades.preon.Trade.allocate(data, dataOffset, index - length);
                }
            }
            throw new ArrayIndexOutOfBoundsException("Ordinal " + ordinal + " exceeds components cardinality (" +cardinality + ")");
        }
    }

}
