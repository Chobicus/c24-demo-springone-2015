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
     * or list of files based on the path argument. For each file
     * parses it, prints the output to Standard.out and validates
     * it.
     * 
     * @param args Should be of length one, where the first element
     * is the filename to read from.
     * @param args
     */
    public static void main(java.lang.String[] args) {
        // Use C24.init().withLicence(licencePath) to specify a licence path
        if (args.length == 1) {
            java.io.File path = new java.io.File(args[0]);
            java.io.File[] files;
            if (path.isDirectory()) {
                files = path.listFiles();
            } else {
                files = new java.io.File[]{path};
            }
            for (java.io.File file : files) {
                try {
                    java.lang.System.out.println(java.lang.String.format("%s\t->\t", file.getName()));
                    biz.c24.io.api.data.ComplexDataObject message = (biz.c24.io.api.data.ComplexDataObject) biz.c24.io.api.C24.parse(biz.c24.trades.TradesDocumentRootElement.getInstance()).from(file);
                    biz.c24.io.api.data.ValidationEvent[] validationEvents = biz.c24.io.api.C24.validateFully(message);
                    if (validationEvents == null) {
                        java.lang.System.out.println(java.lang.String.format("VALID%n"));
                        biz.c24.io.api.C24.write(message).to(java.lang.System.out);
                    } else {
                        for (biz.c24.io.api.data.ValidationEvent event : validationEvents) {
                            java.lang.System.out.println(java.lang.String.format("INVALID %s: %s%n", event.getLocation(), event.getMessage()));
                        }
                    }
                } catch (java.io.IOException e) {
                    java.lang.System.out.println(java.lang.String.format("IOException: %s%n", e.getMessage()));
                }
            }
        } else {
            java.lang.System.out.println("Usage: java biz.c24.trades.TradesDocumentRootElement <filename or directory>");
        }
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
