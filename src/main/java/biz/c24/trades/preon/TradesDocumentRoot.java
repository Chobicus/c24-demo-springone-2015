/*
 * $Id$
 */

package biz.c24.trades.preon;

/**
 * Class TradesDocumentRoot.
 * 
 * @version $Revision$ $Date$
 */
public class TradesDocumentRoot extends biz.c24.io.api.data.preon.IoPreonDataObject 
implements Cloneable
{

    /**
     * Our PreonTypeHandler
     */
    private static final biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = (biz.c24.io.api.preon.typeHandler.PreonTypeHandler2) biz.c24.io.api.data.preon.format.PreonSpecRegistryV2.getTypeHandler(2);

    public TradesDocumentRoot() {
    }

    public TradesDocumentRoot(byte[] data, int offset) {
        setPreonData(data, offset);
    }

    /**
     * 
     * 
     * @param buffer
     * @param offset
     */
    public static TradesDocumentRoot allocate(byte[] buffer,int offset) {
        TradesDocumentRoot object = new TradesDocumentRoot();
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
    public static TradesDocumentRoot allocate(byte[] data,int dataOffset,int preonOffset) {
        TradesDocumentRoot object = new TradesDocumentRoot();
        object.setPreonData(data, dataOffset, preonOffset);
        return object;
    }

    /**
     */
    public java.lang.Object clone() {
        return super.clone();
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
     * Returns the fully qualified class name of this class's
     * corresponding CDO
     */
    public String getComplexDataObjectName() {
        return "biz.c24.trades.TradesDocumentRoot";
    }

    /**
     */
    public static biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 getPreonTypeHandler() {
        return preonTypeHandler;
    }

    /**
     * Gets the value of trades (1).
     */
    public biz.c24.trades.preon.Trades getTrades() {
        int index = getBufferOffset();
        byte[] data = getPreonData();
        int dataOffset = getPreonDataOffset();
        final int startOfBookmarkTable = index;

        int choice = preonTypeHandler.readInt(data, index);
        index += preonTypeHandler.sizeOf(choice);
        if(choice == 0) {
            // Read trades
            {
                // Skip over its persisted length and allocate
                return biz.c24.trades.preon.Trades.allocate(data, dataOffset, index + preonTypeHandler.skipInt(data, index));
            }
        } else {
        return null;
        }
    }

}
