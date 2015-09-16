/*
 * $Id$
 */

package biz.c24.trades.sdo;

/**
 * Class Trades.
 * 
 * @author C24 Integration Objects;
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 */
public class Trades extends biz.c24.io.api.data.IoSimpleDataObject {

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
    private static ThreadLocal<Trades> shell = new ThreadLocal<Trades>() {
		protected Trades initialValue() {
			return new Trades();
		}
	};

    public Trades() {
    }

    public Trades(byte[] data, int offset) {
        setSdoData(data, offset);
    }

    /**
     * 
     * 
     * @param buffer
     * @param offset
     */
    public static Trades allocate(byte[] buffer,int offset) {
        Trades object = shell.get();
        object.setSdoData(buffer, offset);
        return object;
    }

    /**
     * Returns the fully qualified class name of this class's
     * corresponding CDO
     */
    public String getComplexDataObjectName() {
        return "biz.c24.trades.Trades";
    }

    /**
     * Gets the value of Trade (1..*).
     * 
     * @return The list of values, elements of which will be
     * instances of {@link java.util.List}.
     */
    public java.util.List<biz.c24.trades.sdo.Trade> getTrade() {
        int index = getBufferOffset();
        int cardinalityOfTrade = sdoTypeHandler.readInt(data, index);
        index += sdoTypeHandler.sizeOf(cardinalityOfTrade);
        java.util.List<biz.c24.trades.sdo.Trade>  list = new java.util.ArrayList<biz.c24.trades.sdo.Trade>(cardinalityOfTrade);
        for(int i=0; i<cardinalityOfTrade; i++) {
            int size = sdoTypeHandler.readInt(data, index);
            index += sdoTypeHandler.sizeOf(size);
            list.add(new biz.c24.trades.sdo.Trade(data, index));
            index += size;
        }
        return list;
    }

    /**
     * Gets the value of Trade (1..*).
     * 
     * @param ordinal
     * @return The list of values, elements of which will be
     * instances of {@link java.util.List}.
     */
    public biz.c24.trades.sdo.Trade getTrade(int ordinal) {
        int index = getBufferOffset();
        int cardinalityOfTrade = sdoTypeHandler.readInt(data, index);
        index += sdoTypeHandler.sizeOf(cardinalityOfTrade);
        for(int i=0; i<ordinal; i++) {
            index += sdoTypeHandler.skipBytes(data, index);
        }
        // Skip over its persisted length
        index += sdoTypeHandler.skipInt(data, index);
        return biz.c24.trades.sdo.Trade.allocate(data, index);
    }

}