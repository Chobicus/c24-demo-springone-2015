/*
 * $Id$
 */

package biz.c24.trades;

/**
 * Class TradesDocumentRootElement.The Document Root element.
 * 
 * 
 * 
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 */
public class TradesDocumentRootElement extends biz.c24.io.api.data.Element {

    /**
     * Field instance.
     */
    private static volatile TradesDocumentRootElement instance;

    /**
     * Field initialized.
     */
    private static volatile boolean initialized;

    public TradesDocumentRootElement() {
        this(true);
    }

    private TradesDocumentRootElement(boolean init) {
        super("DocumentRoot", 1, 1, biz.c24.trades.TradesDocumentRootElement.TradesDocumentRootCls.class, biz.c24.trades.TradesDataModel.getInstance());

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
                    instance = new biz.c24.trades.TradesDocumentRootElement(false);
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
        setDatabaseColumnName("Document Root");
        setIgnoredElement(false);
    }

    /**
     * Class TradesDocumentRootCls.The Document Root complex data
     * type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     * @see biz.c24.trades.TradesDocumentRoot
     */
    public static class TradesDocumentRootCls extends biz.c24.io.api.data.ComplexDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradesDocumentRootElement.TradesDocumentRootCls instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected TradesDocumentRootCls() {
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
                        instance = new biz.c24.trades.TradesDocumentRootElement.TradesDocumentRootCls();
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
            setName("DocumentRoot");
            setModel(biz.c24.trades.TradesDataModel.getInstance());
            setDatabaseColumnName("Document Root");
            setLocal(true);
            setValidObjectClass(biz.c24.trades.TradesDocumentRoot.class);
            setContentModel(biz.c24.io.api.data.ContentModelEnum.CHOICE);
            biz.c24.io.api.data.Element element = null;
            addElementDecl(element = new biz.c24.io.api.data.Element("trades", 1, 1, biz.c24.trades.TradesCls.class, biz.c24.trades.TradesDataModel.getInstance()));
            element.setIgnoredElement(false);
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

}
