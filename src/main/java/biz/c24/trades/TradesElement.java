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
        super("trades", 1, 1, biz.c24.trades.TradesDataType.class, biz.c24.trades.TradesDataModel.getInstance());

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
                    biz.c24.io.api.data.ComplexDataObject message = (biz.c24.io.api.data.ComplexDataObject) biz.c24.io.api.C24.parse(biz.c24.trades.TradesElement.getInstance()).from(file);
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
            java.lang.System.out.println("Usage: java biz.c24.trades.TradesElement <filename or directory>");
        }
    }

    /**
     */
    private void init() {
        setIgnoredElement(false);
    }

}
