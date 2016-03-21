/*
 * $Id$
 */

package biz.c24.trades;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Arrays;

/**
 * Document Root. <p/>
 * 
 * This object is composed of the following <i>element</i>:
 * <ul>
 * <li><b>trades</b> of type {@link biz.c24.trades.Trades} (1)</li>
 * </ul>
 * 
 * 
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 * @see
 * biz.c24.trades.TradesDocumentRootElement.TradesDocumentRootDataType
 */
public class TradesDocumentRoot extends biz.c24.io.api.data.DocumentRoot 
implements biz.c24.io.api.data.preon.util.PreonConvertible
{

    /**
     * Field serialVersionUID.
     */
    private static final long serialVersionUID = 14L;

    /**
     * Field NATIVE_ELEMENTS.
     */
    private static final java.lang.String[] NATIVE_ELEMENTS = new String[] {"trades"};

    /**
     * Field trades.
     */
    private biz.c24.trades.Trades trades;

    public TradesDocumentRoot() {
        this(biz.c24.trades.TradesDocumentRootElement.TradesDocumentRootDataType.getInstance().getNullDefiningElementDecl());
    }

    public TradesDocumentRoot(biz.c24.io.api.data.Element definingElementDecl) {
        super(definingElementDecl);
    }

    public TradesDocumentRoot(biz.c24.trades.TradesDocumentRoot clone) {
        super(clone);
    }

    /**
     * Adds <code>value</code> as an element called
     * <code>name</code>.<p>
     * The legal value(s) for <code>name</code> are defined in
     * {@link #getElement}.
     * 
     * @param name
     * @param value
     */
    public void addElement(java.lang.String name,java.lang.Object value) {
        name = makeSubstitution(name, -1);
        int i = Arrays.binarySearch(NATIVE_ELEMENTS, name);
        switch (i)
        {
            case 0:
                setTrades((biz.c24.trades.Trades) value);
                return;
            default:
                super.addElement(name, value);
        }
    }

    /**
     * Creates and returns a shallow clone of this object.
     * 
     * @see #cloneDeep()
     */
    public java.lang.Object clone() {
        return new biz.c24.trades.TradesDocumentRoot(this);
    }

    /**
     * Creates and returns a deep clone of this object.
     * 
     * @return The new object.
     * @see #clone()
     */
    public biz.c24.io.api.data.ComplexDataObject cloneDeep() throws java.lang.CloneNotSupportedException {
        biz.c24.io.api.data.ComplexDataObject obj = new biz.c24.trades.TradesDocumentRoot(this);
        cloneDeep(obj);
        return obj;
    }

    /**
     * 
     * 
     * @param clone
     */
    protected void cloneDeep(biz.c24.io.api.data.ComplexDataObject clone) throws java.lang.CloneNotSupportedException {
        biz.c24.trades.TradesDocumentRoot obj = (biz.c24.trades.TradesDocumentRoot) clone;
        obj.trades = (biz.c24.trades.Trades) biz.c24.io.api.Utils.cloneDeep(this.trades, obj, "trades");
    }

    /**
     * 
     * 
     * @param buffer
     */
    public biz.c24.io.api.data.preon.PreonDataObject createPREON(byte[] buffer) {
        return new biz.c24.trades.preon.TradesDocumentRoot(buffer, 0);
    }

    /**
     * Creates, adds and returns a new trades (1).
     * 
     * @return The new value.
     */
    public biz.c24.trades.Trades createTrades() {
        biz.c24.trades.Trades obj = (biz.c24.trades.Trades) getElementDecl("trades").createObject();
        setTrades(obj);
        return obj;
    }

    public boolean equals(java.lang.Object obj) {

        if(obj == null)
            return false;
        else if(obj instanceof biz.c24.io.api.data.ComplexDataObject)
            return equalContents((biz.c24.io.api.data.ComplexDataObject) obj, true, true, true, true);
        else
            return obj.equals(this);
    }

    /**
     * Returns the number of bits in the bitmask that this type
     * uses to indicate the presence of optional attributes and
     * elements.
     */
    public static int getBitmaskLength() {
        return 1;
    }

    /**
     * Returns the element called <code>name</code> at
     * <code>index</code>.<p>
     * The legal value(s) for <code>name</code> are: <b>trades</b>.
     * 
     * @param name
     * @param index
     */
    public java.lang.Object getElement(java.lang.String name,int index) {
        int i = Arrays.binarySearch(NATIVE_ELEMENTS, name);
        if (i < 0)
        {
            name = getSubstitute(name);
            i = Arrays.binarySearch(NATIVE_ELEMENTS, name);
        }
        switch (i)
        {
            case 0:
                return getTrades();
            default:
                return super.getElement(name, index);
        }
    }

    /**
     * Returns the count of elements called <code>name</code>.<p>
     * The legal value(s) for <code>name</code> are defined in
     * {@link #getElement}.
     * 
     * @param name
     */
    public int getElementCount(java.lang.String name) {
        if (null == name) throw new NullPointerException(toString() + " was asked to calculate elements without name");
        int i = Arrays.binarySearch(NATIVE_ELEMENTS, name);
        if (i < 0)
        {
            name = getSubstitute(name);
            i = Arrays.binarySearch(NATIVE_ELEMENTS, name);
        }
        switch (i)
        {
            case 0:
                return this.trades == null ? 0 : 1;
            default:
                return super.getElementCount(name);
        }
    }

    /**
     * Returns the element called <code>name</code> at
     * <code>index</code>.<p>
     * The legal value(s) for <code>name</code> are defined in
     * {@link #getElement}.
     * 
     * @param name
     * @param element
     */
    public int getElementIndex(java.lang.String name,java.lang.Object element) {
        int i = Arrays.binarySearch(NATIVE_ELEMENTS, name);
        if (i < 0)
        {
            name = getSubstitute(name);
            i = Arrays.binarySearch(NATIVE_ELEMENTS, name);
        }
        switch (i)
        {
            case 0:
                return this.trades != null && this.trades.equals(element) ? 0 : -1;
            default:
                return super.getElementIndex(name, element);
        }
    }

    /**
     */
    public Class<? extends biz.c24.trades.preon.TradesDocumentRoot> getPreonClass() {
        return biz.c24.trades.preon.TradesDocumentRoot.class;
    }

    /**
     */
    public biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 getPreonTypeHandler() {
        return biz.c24.trades.preon.TradesDocumentRoot.getPreonTypeHandler();
    }

    /**
     * Returns the raw element data called <code>name</code> at
     * <code>index</code>.<p>
     * The legal value(s) for <code>name</code> are: <b>trades</b>.
     * 
     * @param name
     * @param index
     */
    public java.lang.Object getRawElement(java.lang.String name,int index) {
        int i = Arrays.binarySearch(NATIVE_ELEMENTS, name);
        if (i < 0)
        {
            name = getSubstitute(name);
            i = Arrays.binarySearch(NATIVE_ELEMENTS, name);
        }
        switch (i)
        {
            case 0:
                return this.trades;
            default:
                return super.getElement(name, index);
        }
    }

    /**
     */
    public int getTotalElementCount() {
        int count = 0;
        count += this.trades == null ? 0 : 1;
        return count;
    }

    /**
     * Gets the value of trades (1).
     * 
     * @return The value.
     */
    public biz.c24.trades.Trades getTrades() {
        return this.trades;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + hashCodeOf(serialVersionUID);
        result = 31 * result + hashCodeOf(NATIVE_ELEMENTS);
        result = 31 * result + hashCodeOf(trades);
        return result;
    }

    /**
     * Removes the element called <code>name</code> at
     * <code>index</code>.<p>
     * The legal value(s) for <code>name</code> are defined in
     * {@link #getElement}.
     * 
     * @param name
     * @param index
     */
    public void removeElement(java.lang.String name,int index) {
        name = unmakeSubstitution(name, index);
        int i = Arrays.binarySearch(NATIVE_ELEMENTS, name);
        switch (i)
        {
            case 0:
                setTrades(null);
                return;
            default:
            super.removeElement(name, index);
        }
    }

    /**
     * Sets <code>value</code> as an element called
     * <code>name</code> at <code>index</code>.<p>
     * The legal value(s) for <code>name</code> are defined in
     * {@link #getElement}.
     * 
     * @param name
     * @param value
     * @param index
     */
    public void setElement(java.lang.String name,int index,java.lang.Object value) {
        name = makeSubstitution(name, index);
        int i = (Arrays.binarySearch(NATIVE_ELEMENTS, name));
        switch (i)
        {
            case 0:
                setTrades((biz.c24.trades.Trades) value);
                return;
            default:
                super.setElement(name, index, value);
        }
    }

    /**
     * [Virtual Element] Sets the value of trades (1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setTrades(biz.c24.trades.Trades value) {
        this.trades = value;
        if (this.trades != null)
            ((biz.c24.io.api.data.ComplexDataObject) this.trades).setParent(this, "trades");
    }

    /**
     * 
     * 
     * @param preon
     */
    public static biz.c24.trades.TradesDocumentRoot toCdo(biz.c24.trades.preon.TradesDocumentRoot preon) {
        int index = preon.getBufferOffset();
        byte[] data = preon.getPreonData();
        int dataOffset = preon.getPreonDataOffset();
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.TradesDocumentRoot.getPreonTypeHandler();
        biz.c24.trades.TradesDocumentRoot cdo = new biz.c24.trades.TradesDocumentRoot();

        int choice = preonTypeHandler.readInt(data, index);
        index += preonTypeHandler.sizeOf(choice);
        if(choice == 0) {
            // Read trades
            {
                int length = preonTypeHandler.readInt(data, index);
                index += preonTypeHandler.skipInt(data, index);
                index += length;
                biz.c24.trades.Trades childCdo = biz.c24.trades.Trades.toCdo(biz.c24.trades.preon.Trades.allocate(data, dataOffset, index - length));
                cdo.setTrades(childCdo);
            }
        }
        return cdo;
    }

    /**
     */
    public biz.c24.trades.preon.TradesDocumentRoot toPreon() throws java.io.IOException {
        return toPreon(new biz.c24.io.api.presentation.stream.FastByteArrayOutputStream(48));
    }

    /**
     * 
     * 
     * @param stream
     */
    public biz.c24.trades.preon.TradesDocumentRoot toPreon(final biz.c24.io.api.presentation.stream.FastByteArrayOutputStream stream) throws java.io.IOException {
        writePreon(stream, null);
        biz.c24.trades.preon.TradesDocumentRoot preon = biz.c24.trades.preon.TradesDocumentRoot.allocate(stream.toByteArray(), 0);
        return preon;
    }

    /**
     */
    public biz.c24.io.api.data.preon.util.PreonContext toPreonWithContext() throws java.io.IOException {
        biz.c24.io.api.presentation.stream.FastByteArrayOutputStream stream = new biz.c24.io.api.presentation.stream.FastByteArrayOutputStream(48);
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.TradesDocumentRoot.getPreonTypeHandler();
        biz.c24.io.api.data.preon.util.PreonContext preonContext = new biz.c24.io.api.data.preon.util.PreonContext("Root", null);
        writePreon(stream, preonContext);
        biz.c24.trades.preon.TradesDocumentRoot preon = biz.c24.trades.preon.TradesDocumentRoot.allocate(stream.toByteArray(), 0);
        preonContext.setPreon(preon);
        return preonContext;
    }

    /**
     */
    public void validateMandatory() throws biz.c24.io.api.data.ValidationException {
        int fieldCount = 0;
        if (getTrades() != null) {
            fieldCount++;
            getTrades().validateMandatory();
        }
        if (fieldCount != 1) {
            biz.c24.io.api.data.ValidationManager mgr = new biz.c24.io.api.data.ValidationManager();
            biz.c24.io.api.data.ValidationEvent event = new biz.c24.io.api.data.ValidationEvent(this, biz.c24.io.api.ValidationResultEnum.FAILED_CHOICE_SUBFIELD_COUNT, new biz.c24.io.api.data.EventMessage("Choice content model requires a single child is set however " + fieldCount + " children are"));
            mgr.fireValidationEvent(event);
        }
    }

    /**
     * 
     * 
     * @param stream
     * @param preonContext
     */
    public int writePreon(final biz.c24.io.api.presentation.stream.FastByteArrayOutputStream stream,final biz.c24.io.api.data.preon.util.PreonContext preonContext) throws java.io.IOException {
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.TradesDocumentRoot.getPreonTypeHandler();
        int length = 0;
        if (preonContext != null) {
            preonContext.add("Format Identifier", 2, length += preonTypeHandler.write(stream, 2));
        } else {
            length += preonTypeHandler.write(stream, 2);
        }
        length += writePreonData(stream, preonContext);
        return length;
    }

    /**
     * 
     * 
     * @param stream
     * @param preonContext
     */
    public int writePreonData(final biz.c24.io.api.presentation.stream.FastByteArrayOutputStream stream,final biz.c24.io.api.data.preon.util.PreonContext preonContext) throws java.io.IOException {
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.TradesDocumentRoot.getPreonTypeHandler();
        int startOffset = stream.size();

        if(getTrades() != null) {
            if (preonContext != null) {
                preonContext.add("Choice index", 0, preonTypeHandler.write(stream, 0));
            } else {
                preonTypeHandler.write(stream, 0);
            }
            // Write trades
            {
                writePreon(stream, getTrades(), "trades", preonTypeHandler, preonContext);
            }
        }
        return stream.size() - startOffset;
    }

    /**
     * 
     * 
     * @param out
     */
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        out.writeObject(this.trades);
    }

    /**
     * 
     * 
     * @param in
     */
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        this.trades = (biz.c24.trades.Trades) in.readObject();
    }

}
