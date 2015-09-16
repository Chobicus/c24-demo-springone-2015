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
        super("DocumentRoot", 1, 1, biz.c24.trades.TradesDocumentRootElement.TradesDocumentRootDataType.class, biz.c24.trades.TradesDataModel.getInstance());

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
     * Test method. Reads in a file (called <code>arg[0]</code>),
     * parses it, prints the output to Standard.out and validates
     * it.
     * 
     * @param args Should be of length one, where the first element
     * is the filename to read from.
     * @param args
     */
    public static void main(java.lang.String[] args) {
        if (args.length == 1)
        {
            biz.c24.io.api.data.Element element = biz.c24.trades.TradesDocumentRootElement.getInstance();
            org.apache.log4j.Appender appender = new org.apache.log4j.ConsoleAppender(new org.apache.log4j.SimpleLayout());
            element.getLog().addAppender(appender);
            element.getLog().setLevel(org.apache.log4j.Level.OFF); // change this to see console logging

            try
            {
                java.lang.System.out.println("Parsing... ");
                biz.c24.io.api.presentation.Source source = element.getModel().source();
                source.setInputStream(new java.io.FileInputStream(args[0]));
                biz.c24.io.api.data.ComplexDataObject bean = source.readObject(element);
                source.getInputStream().close();
                java.lang.System.out.println(bean.toString());

                java.lang.System.out.println("Validating... ");
                new biz.c24.io.api.data.ValidationManager().validateByException(bean);

                java.lang.System.out.println("Finished");
            }
            catch (java.lang.Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                element.getLog().removeAppender(appender);
            }
        }
        else
            java.lang.System.out.println("Usage: java biz.c24.trades.TradesDocumentRootElement <filename>");
    }

    /**
     */
    private void init() {
        setDatabaseColumnName("Document Root");
        setIgnoredElement(false);
    }

    /**
     * Class TradesDocumentRootDataType.The Document Root complex
     * data type.
     * 
     * 
     * 
     * @author C24 Integration Objects;
     * @version $Revision$ $Date$
     * @see biz.c24.trades.TradesDocumentRoot
     */
    public static class TradesDocumentRootDataType extends biz.c24.io.api.data.ComplexDataType {

        /**
         * Field instance.
         */
        protected static volatile biz.c24.trades.TradesDocumentRootElement.TradesDocumentRootDataType instance;

        /**
         * Field initialized.
         */
        private static volatile boolean initialized;

        protected TradesDocumentRootDataType() {
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
                        instance = new biz.c24.trades.TradesDocumentRootElement.TradesDocumentRootDataType();
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
            addElementDecl(element = new biz.c24.io.api.data.Element("trades", 1, 1, biz.c24.trades.TradesDataType.class, biz.c24.trades.TradesDataModel.getInstance()));
            element.setIgnoredElement(false);
        }

        /**
         */
        private java.lang.Object readResolve() {
            return getInstance();
        }

    }

}
