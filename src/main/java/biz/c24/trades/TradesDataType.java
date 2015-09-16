/*
 * $Id$
 */

package biz.c24.trades;

/**
 * Class TradesDataType.The trades complex data type.
 * 
 * 
 * 
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 * @see biz.c24.trades.Trades
 */
public class TradesDataType extends biz.c24.io.api.data.ComplexDataType {

    /**
     * Field instance.
     */
    protected static volatile TradesDataType instance;

    /**
     * Field initialized.
     */
    private static volatile boolean initialized;

    protected TradesDataType() {
    }

    /**
     * Gets the singleton instance of this type.
     * 
     * @return The type, or its supertype if present.
     */
    public static biz.c24.io.api.data.DataType getInstance() {
        if (!initialized)
        {
            synchronized (biz.c24.io.api.data.ComplexDataType.class)
            {
                if (instance == null)
                {
                    instance = new biz.c24.trades.TradesDataType();
                    instance.init();
                    initialized = true;
                }
            }
        }
        return instance;
    }

    /**
     * Called internally to initialize this type.
     */
    protected void init() {
        setName("trades");
        setModel(biz.c24.trades.TradesDataModel.getInstance());
        setValidObjectClass(biz.c24.trades.Trades.class);
        setContentModel(biz.c24.io.api.data.ContentModelEnum.SEQUENCE);
        biz.c24.io.api.data.Element element = null;
        addElementDecl(element = new biz.c24.io.api.data.Element("Trade", 1, biz.c24.io.api.data.DataComponent.CARDINALITY_UNBOUNDED, biz.c24.trades.TradeDataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
    }

    /**
     */
    private java.lang.Object readResolve() {
        return getInstance();
    }

}
