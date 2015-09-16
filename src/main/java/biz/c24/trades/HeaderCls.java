/*
 * $Id$
 */

package biz.c24.trades;

/**
 * Class HeaderCls.The Header complex data type.
 * 
 * 
 * 
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 * @see biz.c24.trades.Header
 */
public class HeaderCls extends biz.c24.io.api.data.ComplexDataType {

    /**
     * Field instance.
     */
    protected static volatile HeaderCls instance;

    /**
     * Field initialized.
     */
    private static volatile boolean initialized;

    protected HeaderCls() {
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
                    instance = new biz.c24.trades.HeaderCls();
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
        setName("Header");
        setModel(biz.c24.trades.TradesDataModel.getInstance());
        setValidObjectClass(biz.c24.trades.Header.class);
        setContentModel(biz.c24.io.api.data.ContentModelEnum.SEQUENCE);
        biz.c24.io.api.data.Element element = null;
        setTerminator(new String[] {new String(new char[] {0xd, 0xa}), new String(new char[] {0xa}), new String(new char[] {0xd}), new String(new char[] {0x0})});
        setFormatType(biz.c24.io.api.data.FormatTypeEnum.DELIMITED);
        setDelimiter(new String[] {new String(new char[] {0x2c})});
        setDelimiterLocation(biz.c24.io.api.data.DelimiterLocationEnum.INFIX);
        setDelimiterPlaceholder(true);
        setDelimiterFieldWrapper(new String[] {new String(new char[] {0x22})});
        addElementDecl(element = new biz.c24.io.api.data.Element("ID", 1, 1, biz.c24.trades.HeaderCls.IDCls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("TradeDate", 1, 1, biz.c24.trades.HeaderCls.TradeDateCls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("BuySell", 1, 1, biz.c24.trades.HeaderCls.BuySellCls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Currency1", 1, 1, biz.c24.trades.HeaderCls.Currency1Cls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Amount1", 1, 1, biz.c24.trades.HeaderCls.Amount1Cls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("ExchangeRate", 1, 1, biz.c24.trades.HeaderCls.ExchangeRateCls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setDatabaseColumnName("Exchange Rate");
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Currency2", 1, 1, biz.c24.trades.HeaderCls.Currency2Cls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Amount2", 1, 1, biz.c24.trades.HeaderCls.Amount2Cls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("SettlmentDate", 1, 1, biz.c24.trades.HeaderCls.SettlmentDateCls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setDatabaseColumnName("Settlment Date");
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("anyType", 0, 1, biz.c24.trades.HeaderCls.AnyTypeCls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
    }

    /**
     */
    private java.lang.Object readResolve() {
        return getInstance();
    }

    /**
     * Class Amount1Cls.The Amount1 atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class Amount1Cls extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderCls.Amount1Cls instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected Amount1Cls() {
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
                        instance = new biz.c24.trades.HeaderCls.Amount1Cls();
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
            setName("Amount1");
            setModel(biz.c24.trades.TradesDataModel.getInstance());
            setLocal(true);
            setMinLength(0);
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

    /**
     * Class Amount2Cls.The Amount2 atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class Amount2Cls extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderCls.Amount2Cls instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected Amount2Cls() {
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
                        instance = new biz.c24.trades.HeaderCls.Amount2Cls();
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
            setName("Amount2");
            setModel(biz.c24.trades.TradesDataModel.getInstance());
            setLocal(true);
            setMinLength(0);
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

    /**
     * Class AnyTypeCls.The anyType atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class AnyTypeCls extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderCls.AnyTypeCls instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected AnyTypeCls() {
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
                        instance = new biz.c24.trades.HeaderCls.AnyTypeCls();
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
            setName("anyType");
            setModel(biz.c24.trades.TradesDataModel.getInstance());
            setLocal(true);
            setMinLength(0);
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

    /**
     * Class BuySellCls.The BuySell atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class BuySellCls extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderCls.BuySellCls instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected BuySellCls() {
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
                        instance = new biz.c24.trades.HeaderCls.BuySellCls();
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
            setName("BuySell");
            setModel(biz.c24.trades.TradesDataModel.getInstance());
            setLocal(true);
            setMinLength(0);
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

    /**
     * Class Currency1Cls.The Currency1 atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class Currency1Cls extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderCls.Currency1Cls instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected Currency1Cls() {
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
                        instance = new biz.c24.trades.HeaderCls.Currency1Cls();
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
            setName("Currency1");
            setModel(biz.c24.trades.TradesDataModel.getInstance());
            setLocal(true);
            setMinLength(0);
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

    /**
     * Class Currency2Cls.The Currency2 atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class Currency2Cls extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderCls.Currency2Cls instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected Currency2Cls() {
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
                        instance = new biz.c24.trades.HeaderCls.Currency2Cls();
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
            setName("Currency2");
            setModel(biz.c24.trades.TradesDataModel.getInstance());
            setLocal(true);
            setMinLength(0);
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

    /**
     * Class ExchangeRateCls.The Exchange Rate atomic simple data
     * type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class ExchangeRateCls extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderCls.ExchangeRateCls instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected ExchangeRateCls() {
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
                        instance = new biz.c24.trades.HeaderCls.ExchangeRateCls();
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
            setName("ExchangeRate");
            setModel(biz.c24.trades.TradesDataModel.getInstance());
            setDatabaseColumnName("Exchange Rate");
            setLocal(true);
            setMinLength(0);
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

    /**
     * Class IDCls.The ID atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class IDCls extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderCls.IDCls instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected IDCls() {
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
                        instance = new biz.c24.trades.HeaderCls.IDCls();
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
            setName("ID");
            setModel(biz.c24.trades.TradesDataModel.getInstance());
            setLocal(true);
            setMinLength(0);
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

    /**
     * Class SettlmentDateCls.The Settlment Date atomic simple data
     * type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class SettlmentDateCls extends biz.c24.io.api.data.LocalDateDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderCls.SettlmentDateCls instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected SettlmentDateCls() {
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
                        instance = new biz.c24.trades.HeaderCls.SettlmentDateCls();
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
            setName("SettlmentDate");
            setModel(biz.c24.trades.TradesDataModel.getInstance());
            setDatabaseColumnName("Settlment Date");
            setLocal(true);
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

    /**
     * Class TradeDateCls.The TradeDate atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class TradeDateCls extends biz.c24.io.api.data.LocalDateDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderCls.TradeDateCls instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected TradeDateCls() {
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
                        instance = new biz.c24.trades.HeaderCls.TradeDateCls();
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
            setName("TradeDate");
            setModel(biz.c24.trades.TradesDataModel.getInstance());
            setLocal(true);
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

}
