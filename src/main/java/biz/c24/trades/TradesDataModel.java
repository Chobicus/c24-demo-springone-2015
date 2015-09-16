/*
 * $Id$
 */

package biz.c24.trades;

/**
 * Class TradesDataModel.The trades data model.
 * 
 * 
 * 
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 */
public class TradesDataModel extends biz.c24.io.api.data.DataModel {

    /**
     * Field instance.
     */
    private static volatile TradesDataModel instance;

    /**
     * Field initialized.
     */
    private static volatile boolean initialized;

    protected TradesDataModel(boolean init) {
        if (init)
            init();
    }

    /**
     * Gets the singleton instance.
     * 
     * @return The instance.
     */
    public static biz.c24.trades.TradesDataModel getInstance() {
        if (!initialized)
        {
            synchronized (biz.c24.io.api.data.ComplexDataType.class)
            {
                if (instance == null)
                {
                    instance = new biz.c24.trades.TradesDataModel(false);
                    instance.init();
                    initialized = true;
                }
            }
        }
        return instance;
    }

    /**
     */
    private void init() {
        setName("trades");
        setTargetNamespace("http://www.c24.biz/trades");
        setElementFormDefault(biz.c24.io.api.data.FormEnum.QUALIFIED);
        setAttributeFormDefault(biz.c24.io.api.data.FormEnum.UNQUALIFIED);
        setIdGeneratorMethodDefault(biz.c24.io.api.data.IDGeneratorMethodEnum.NATIVE);
    }

}
