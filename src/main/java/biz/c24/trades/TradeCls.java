/*
 * $Id$
 */

package biz.c24.trades;

/**
 * Class TradeCls.The Trade complex data type.
 * 
 * 
 * 
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 * @see biz.c24.trades.Trade
 */
public class TradeCls extends biz.c24.io.api.data.ComplexDataType {

    /**
     * Field instance.
     */
    protected static volatile TradeCls instance;

    /**
     * Field initialized.
     */
    private static volatile boolean initialized;

    protected TradeCls() {
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
                    instance = new biz.c24.trades.TradeCls();
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
        setName("Trade");
        setModel(biz.c24.trades.TradesDataModel.getInstance());
        setValidObjectClass(biz.c24.trades.Trade.class);
        setContentModel(biz.c24.io.api.data.ContentModelEnum.SEQUENCE);
        biz.c24.io.api.data.Element element = null;
        setTerminator(new String[] {new String(new char[] {0xd, 0xa}), new String(new char[] {0xa}), new String(new char[] {0xd}), new String(new char[] {0x0})});
        setFormatType(biz.c24.io.api.data.FormatTypeEnum.DELIMITED);
        setDelimiter(new String[] {new String(new char[] {0x2c})});
        setDelimiterLocation(biz.c24.io.api.data.DelimiterLocationEnum.INFIX);
        setDelimiterPlaceholder(true);
        setDelimiterFieldWrapper(new String[] {new String(new char[] {0x22})});
        addElementDecl(element = new biz.c24.io.api.data.Element("ID", 1, 1, biz.c24.trades.TradeCls.IDCls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("TradeDate", 1, 1, biz.c24.trades.TradeCls.TradeDateCls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("BuySell", 1, 1, biz.c24.trades.TradeCls.BuySellCls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setCommonValues(new String[]{"Buy", "Sell"});
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Currency1", 1, 1, biz.c24.trades.TradeCls.Currency1Cls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setCommonValues(new String[]{"EUR", "USD", "GBP", "AUD", "CHF", "JPY"});
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Amount1", 1, 1, biz.c24.trades.TradeCls.Amount1Cls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("ExchangeRate", 1, 1, biz.c24.trades.TradeCls.ExchangeRateCls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setDatabaseColumnName("Exchange Rate");
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Currency2", 1, 1, biz.c24.trades.TradeCls.Currency2Cls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setCommonValues(new String[]{"EUR", "USD", "GBP", "AUD", "CHF", "JPY"});
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Amount2", 1, 1, biz.c24.trades.TradeCls.Amount2Cls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("SettlementDate", 1, 1, biz.c24.trades.TradeCls.SettlementDateCls.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setDatabaseColumnName("Settlement Date");
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
    public static class Amount1Cls extends biz.c24.io.api.data.DecimalDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeCls.Amount1Cls instance;

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
                        instance = new biz.c24.trades.TradeCls.Amount1Cls();
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
            setAllFormatPatterns(new String[] {new String(new char[] {0x23, 0x30, 0x2e, 0x30, 0x30, 0x3b, 0x27, 0x2d, 0x27, 0x23, 0x30, 0x2e, 0x30, 0x30})});
            setDecimalSeparator('.');
            setThousandSeparator(',');
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
    public static class Amount2Cls extends biz.c24.io.api.data.DecimalDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeCls.Amount2Cls instance;

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
                        instance = new biz.c24.trades.TradeCls.Amount2Cls();
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
            setAllFormatPatterns(new String[] {new String(new char[] {0x23, 0x30, 0x2e, 0x30, 0x30, 0x3b, 0x27, 0x2d, 0x27, 0x23, 0x30, 0x2e, 0x30, 0x30})});
            setDecimalSeparator('.');
            setThousandSeparator(',');
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
        protected static volatile biz.c24.trades.TradeCls.BuySellCls instance;

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
                        instance = new biz.c24.trades.TradeCls.BuySellCls();
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
        protected static volatile biz.c24.trades.TradeCls.Currency1Cls instance;

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
                        instance = new biz.c24.trades.TradeCls.Currency1Cls();
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
        protected static volatile biz.c24.trades.TradeCls.Currency2Cls instance;

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
                        instance = new biz.c24.trades.TradeCls.Currency2Cls();
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
    public static class ExchangeRateCls extends biz.c24.io.api.data.DoubleDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeCls.ExchangeRateCls instance;

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
                        instance = new biz.c24.trades.TradeCls.ExchangeRateCls();
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
            setAllFormatPatterns(new String[] {new String(new char[] {0x23, 0x30, 0x2e, 0x23, 0x23, 0x23, 0x3b, 0x27, 0x2d, 0x27, 0x23, 0x30, 0x2e, 0x23, 0x23, 0x23})});
            setDecimalSeparator('.');
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
    public static class IDCls extends biz.c24.io.api.data.IntDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeCls.IDCls instance;

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
                        instance = new biz.c24.trades.TradeCls.IDCls();
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
            setAllFormatPatterns(new String[] {new String(new char[] {0x23, 0x3b, 0x27, 0x2d, 0x27, 0x23})});
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

    /**
     * Class SettlementDateCls.The Settlement Date atomic simple
     * data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class SettlementDateCls extends biz.c24.io.api.data.LocalDateTimeDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeCls.SettlementDateCls instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected SettlementDateCls() {
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
                        instance = new biz.c24.trades.TradeCls.SettlementDateCls();
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
            setName("SettlementDate");
            setModel(biz.c24.trades.TradesDataModel.getInstance());
            setDatabaseColumnName("Settlement Date");
            setLocal(true);
            setAllFormatPatterns(new String[] {new String(new char[] {0x64, 0x64, 0x2f, 0x4d, 0x4d, 0x2f, 0x79, 0x79, 0x79, 0x79})});
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
    public static class TradeDateCls extends biz.c24.io.api.data.LocalDateTimeDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeCls.TradeDateCls instance;

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
                        instance = new biz.c24.trades.TradeCls.TradeDateCls();
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
            setAllFormatPatterns(new String[] {new String(new char[] {0x64, 0x64, 0x2f, 0x4d, 0x4d, 0x2f, 0x79, 0x79, 0x79, 0x79})});
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

}
