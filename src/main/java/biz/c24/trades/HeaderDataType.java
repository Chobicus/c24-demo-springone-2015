/*
 * $Id$
 */

package biz.c24.trades;

/**
 * Class HeaderDataType.The Header complex data type.
 * 
 * 
 * 
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 * @see biz.c24.trades.Header
 */
public class HeaderDataType extends biz.c24.io.api.data.ComplexDataType {

    /**
     * Field instance.
     */
    protected static volatile HeaderDataType instance;

    /**
     * Field initialized.
     */
    private static volatile boolean initialized;

    protected HeaderDataType() {
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
                    instance = new biz.c24.trades.HeaderDataType();
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
        addElementDecl(element = new biz.c24.io.api.data.Element("ID", 1, 1, biz.c24.trades.HeaderDataType.IDDataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("TradeDate", 1, 1, biz.c24.trades.HeaderDataType.TradeDateDataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("BuySell", 1, 1, biz.c24.trades.HeaderDataType.BuySellDataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Currency1", 1, 1, biz.c24.trades.HeaderDataType.Currency1DataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Amount1", 1, 1, biz.c24.trades.HeaderDataType.Amount1DataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("ExchangeRate", 1, 1, biz.c24.trades.HeaderDataType.ExchangeRateDataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setDatabaseColumnName("Exchange Rate");
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Currency2", 1, 1, biz.c24.trades.HeaderDataType.Currency2DataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("Amount2", 1, 1, biz.c24.trades.HeaderDataType.Amount2DataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("SettlmentDate", 1, 1, biz.c24.trades.HeaderDataType.SettlmentDateDataType.class, biz.c24.trades.TradesDataModel.getInstance()));
        element.setDatabaseColumnName("Settlment Date");
        element.setIgnoredElement(false);
        addElementDecl(element = new biz.c24.io.api.data.Element("anyType", 0, 1, biz.c24.trades.HeaderDataType.AnyTypeDataType.class, biz.c24.trades.TradesDataModel.getInstance()));
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
    public static class Amount1DataType extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderDataType.Amount1DataType instance;

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
                        instance = new biz.c24.trades.HeaderDataType.Amount1DataType();
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
     * Class Amount2DataType.The Amount2 atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class Amount2DataType extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderDataType.Amount2DataType instance;

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
                        instance = new biz.c24.trades.HeaderDataType.Amount2DataType();
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
     * Class AnyTypeDataType.The anyType atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class AnyTypeDataType extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderDataType.AnyTypeDataType instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected AnyTypeDataType() {
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
                        instance = new biz.c24.trades.HeaderDataType.AnyTypeDataType();
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
        protected static volatile biz.c24.trades.HeaderDataType.BuySellDataType instance;

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
                        instance = new biz.c24.trades.HeaderDataType.BuySellDataType();
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
        protected static volatile biz.c24.trades.HeaderDataType.Currency1DataType instance;

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
                        instance = new biz.c24.trades.HeaderDataType.Currency1DataType();
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
        protected static volatile biz.c24.trades.HeaderDataType.Currency2DataType instance;

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
                        instance = new biz.c24.trades.HeaderDataType.Currency2DataType();
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
    public static class ExchangeRateDataType extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderDataType.ExchangeRateDataType instance;

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
                        instance = new biz.c24.trades.HeaderDataType.ExchangeRateDataType();
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
     * Class IDDataType.The ID atomic simple data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class IDDataType extends biz.c24.io.api.data.GenericStringDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderDataType.IDDataType instance;

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
                        instance = new biz.c24.trades.HeaderDataType.IDDataType();
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
     * Class SettlmentDateDataType.The Settlment Date atomic simple
     * data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     */
    public static class SettlmentDateDataType extends biz.c24.io.api.data.LocalDateDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.HeaderDataType.SettlmentDateDataType instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected SettlmentDateDataType() {
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
                        instance = new biz.c24.trades.HeaderDataType.SettlmentDateDataType();
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
        protected static volatile biz.c24.trades.HeaderDataType.TradeDateDataType instance;

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
                        instance = new biz.c24.trades.HeaderDataType.TradeDateDataType();
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
