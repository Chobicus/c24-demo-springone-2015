/*
 * $Id$
 */

package biz.c24.trades.sdo;

/**
 * Class TradesDocumentRoot.
 * 
 * @author C24 Integration Objects;
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 */
public class TradesDocumentRoot extends biz.c24.io.api.data.IoSimpleDataObject {

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
    private static ThreadLocal<TradesDocumentRoot> shell = new ThreadLocal<TradesDocumentRoot>() {
		protected TradesDocumentRoot initialValue() {
			return new TradesDocumentRoot();
		}
	};

    public TradesDocumentRoot() {
    }

    public TradesDocumentRoot(byte[] data, int offset) {
        setSdoData(data, offset);
    }

    /**
     * 
     * 
     * @param buffer
     * @param offset
     */
    public static TradesDocumentRoot allocate(byte[] buffer,int offset) {
        TradesDocumentRoot object = shell.get();
        object.setSdoData(buffer, offset);
        return object;
    }

    /**
     * Returns the fully qualified class name of this class's
     * corresponding CDO
     */
    public String getComplexDataObjectName() {
        return "biz.c24.trades.TradesDocumentRoot";
    }

    /**
     * Gets the value of trades (1).
     * 
     * @return The value.
     */
    public biz.c24.trades.sdo.Trades getTrades() {
        int index = getBufferOffset();
        int choiceOfDocumentRoot = sdoTypeHandler.readInt(data, index);
        index +=  sdoTypeHandler.sizeOf(choiceOfDocumentRoot);
        if(choiceOfDocumentRoot == 0) {
            // Skip over its persisted length
            index += sdoTypeHandler.skipInt(data, index);
            return biz.c24.trades.sdo.Trades.allocate(data, index);
        } else {
            return null;
        }
    }

}
