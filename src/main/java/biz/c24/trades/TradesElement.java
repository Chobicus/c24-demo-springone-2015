/*
 * $Id$
 */

package biz.c24.trades;

/**
 * Class TradesElement.The trades element.
 * 
 * 
 * 
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 */
public class TradesElement extends biz.c24.io.api.data.Element {

    /**
     * Field instance.
     */
    private static volatile TradesElement instance;

    /**
     * Field initialized.
     */
    private static volatile boolean initialized;

    public TradesElement() {
        this(true);
    }

    private TradesElement(boolean init) {
        super("trades", 1, 1, biz.c24.trades.TradesCls.class, biz.c24.trades.TradesDataModel.getInstance());

        if (init)
            init();
    }

    /**
     */
    public static biz.c24.io.api.data.Element getInstance() {
        if (!initialized)
        {
            synchronized (biz.c24.io.api.data.ComplexDataType.class)
            {
                if (instance == null)
                {
                    instance = new biz.c24.trades.TradesElement(false);
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
        setIgnoredElement(false);
    }

}
