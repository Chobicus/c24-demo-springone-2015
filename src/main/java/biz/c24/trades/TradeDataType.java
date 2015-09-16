/*
 * $Id$
 */

package biz.c24.trades;

/**
 * Class TradeDataType.The Trade complex data type.
 * 
 * 
 * 
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 * @see biz.c24.trades.Trade
 */
public class TradeDataType extends biz.c24.io.api.data.ComplexDataType {

    /**
     * Field instance.
     */
    protected static volatile TradeDataType instance;

    /**
     * Field initialized.
     */
    private static volatile boolean initialized;

    protected TradeDataType() {
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
                    instance = new biz.c24.trades.TradeDataType();
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
        addElementDecl(element = new biz.c24.io.api.data.Element("ID", 1, 1, biz.c24.trades.TradeDataType.IDDataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("TradeDate", 1, 1, biz.c24.trades.TradeDataType.TradeDateDataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("BuySell", 1, 1, biz.c24.trades.TradeDataType.BuySellDataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setCommonValues(new String[]{"Buy", "Sell"});
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Currency1", 1, 1, biz.c24.trades.TradeDataType.Currency1DataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setCommonValues(new String[]{"EUR", "USD", "GBP", "AUD", "CHF", "JPY"});
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Amount1", 1, 1, biz.c24.trades.TradeDataType.Amount1DataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("ExchangeRate", 1, 1, biz.c24.trades.TradeDataType.ExchangeRateDataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setDatabaseColumnName("Exchange Rate");
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Currency2", 1, 1, biz.c24.trades.TradeDataType.Currency2DataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setCommonValues(new String[]{"EUR", "USD", "GBP", "AUD", "CHF", "JPY"});
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Amount2", 1, 1, biz.c24.trades.TradeDataType.Amount2DataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("SettlementDate", 1, 1, biz.c24.trades.TradeDataType.SettlementDateDataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setDatabaseColumnName("Settlement Date");
        element.setIgnoredElement(false);
    }

    /**
     */
    private java.lang.Object readResolve() {
        return getInstance();
    }

    /**
     * Class Amount1DataType.The Amount1 atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class Amount1DataType extends biz.c24.io.api.data.DecimalDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeDataType.Amount1DataType instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected Amount1DataType() {
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
                        instance = new biz.c24.trades.TradeDataType.Amount1DataType();
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
     * Class Amount2DataType.The Amount2 atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class Amount2DataType extends biz.c24.io.api.data.DecimalDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeDataType.Amount2DataType instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected Amount2DataType() {
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
                        instance = new biz.c24.trades.TradeDataType.Amount2DataType();
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
     * Class BuySellDataType.The BuySell atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class BuySellDataType extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeDataType.BuySellDataType instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected BuySellDataType() {
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
                        instance = new biz.c24.trades.TradeDataType.BuySellDataType();
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
     * Class Currency1DataType.The Currency1 atomic simple data
     * type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class Currency1DataType extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeDataType.Currency1DataType instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected Currency1DataType() {
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
                        instance = new biz.c24.trades.TradeDataType.Currency1DataType();
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
     * Class Currency2DataType.The Currency2 atomic simple data
     * type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class Currency2DataType extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeDataType.Currency2DataType instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected Currency2DataType() {
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
                        instance = new biz.c24.trades.TradeDataType.Currency2DataType();
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
     * Class ExchangeRateDataType.The Exchange Rate atomic simple
     * data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class ExchangeRateDataType extends biz.c24.io.api.data.DoubleDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeDataType.ExchangeRateDataType instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected ExchangeRateDataType() {
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
                        instance = new biz.c24.trades.TradeDataType.ExchangeRateDataType();
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
     * Class IDDataType.The ID atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class IDDataType extends biz.c24.io.api.data.LongDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeDataType.IDDataType instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected IDDataType() {
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
                        instance = new biz.c24.trades.TradeDataType.IDDataType();
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
     * Class SettlementDateDataType.The Settlement Date atomic
     * simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class SettlementDateDataType extends biz.c24.io.api.data.LocalDateDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeDataType.SettlementDateDataType instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected SettlementDateDataType() {
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
                        instance = new biz.c24.trades.TradeDataType.SettlementDateDataType();
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
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

    /**
     * Class TradeDateDataType.The TradeDate atomic simple data
     * type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class TradeDateDataType extends biz.c24.io.api.data.LocalDateDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradeDataType.TradeDateDataType instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected TradeDateDataType() {
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
                        instance = new biz.c24.trades.TradeDataType.TradeDateDataType();
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
