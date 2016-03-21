/*
 * $Id$
 */

package biz.c24.trades;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Arrays;

/**
 * trades. <p/>
 * 
 * This object is composed of the following <i>element</i>:
 * <ul>
 * <li><b>Trade</b> of type {@link biz.c24.trades.Trade}
 * (1..*)</li>
 * </ul>
 * 
 * 
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 * @see biz.c24.trades.TradesDataType
 */
public class Trades extends biz.c24.io.api.data.ComplexDataObject 
implements biz.c24.io.api.data.preon.util.PreonConvertible
{

    /**
     * Field serialVersionUID.
     */
    private static final long serialVersionUID = 14L;

    /**
     * Field NATIVE_ELEMENTS.
     */
    private static final java.lang.String[] NATIVE_ELEMENTS = new String[] {"Trade"};

    /**
     * Field trade.
     */
    private java.util.List<biz.c24.trades.Trade> trade;

    public Trades() {
        this(biz.c24.trades.TradesDataType.getInstance().getNullDefiningElementDecl());
    }

    public Trades(biz.c24.io.api.data.Element definingElementDecl) {
        super(definingElementDecl);
    }

    public Trades(biz.c24.io.api.data.Element definingElementDecl, biz.c24.io.api.data.ComplexDataType type) {
        super(definingElementDecl, type);
    }

    public Trades(biz.c24.trades.Trades clone) {
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
                addTrade((biz.c24.trades.Trade) value);
                return;
            default:
                super.addElement(name, value);
        }
    }

    /**
     * Adds a Trade (1..*).
     * 
     * @param value
     * @param value The new Trade.
     */
    public void addTrade(biz.c24.trades.Trade value) {
         if(this.trade == null) { 
            this.trade = new java.util.ArrayList<biz.c24.trades.Trade>();
        }
        this.trade.add(value);
        ((biz.c24.io.api.data.ComplexDataObject) value).setParent(this, "Trade");
    }

    /**
     * Creates and returns a shallow clone of this object.
     * 
     * @see #cloneDeep()
     */
    public java.lang.Object clone() {
        return new biz.c24.trades.Trades(this);
    }

    /**
     * Creates and returns a deep clone of this object.
     * 
     * @return The new object.
     * @see #clone()
     */
    public biz.c24.io.api.data.ComplexDataObject cloneDeep() throws java.lang.CloneNotSupportedException {
        biz.c24.io.api.data.ComplexDataObject obj = new biz.c24.trades.Trades(this);
        cloneDeep(obj);
        return obj;
    }

    /**
     * 
     * 
     * @param clone
     */
    protected void cloneDeep(biz.c24.io.api.data.ComplexDataObject clone) throws java.lang.CloneNotSupportedException {
        biz.c24.trades.Trades obj = (biz.c24.trades.Trades) clone;
        obj.trade = (java.util.List<biz.c24.trades.Trade>) biz.c24.io.api.Utils.cloneDeep(this.trade, obj, "Trade");
    }

    /**
     * 
     * 
     * @param buffer
     */
    public biz.c24.io.api.data.preon.PreonDataObject createPREON(byte[] buffer) {
        return new biz.c24.trades.preon.Trades(buffer, 0);
    }

    /**
     * Creates, adds and returns a new Trade (1..*).
     * 
     * @return The new value.
     */
    public biz.c24.trades.Trade createTrade() {
        biz.c24.trades.Trade obj = (biz.c24.trades.Trade) getElementDecl("Trade").createObject();
        addTrade(obj);
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
     * Returns the element called <code>name</code> at
     * <code>index</code>.<p>
     * The legal value(s) for <code>name</code> are: <b>trade</b>.
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
            if (this.trade == null)
                throw new java.lang.IndexOutOfBoundsException();
            else
                return this.trade.get(index);
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
                return this.trade == null ? 0 : this.trade.size();
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
                return getTradeIndex((biz.c24.trades.Trade) element);
            default:
                return super.getElementIndex(name, element);
        }
    }

    /**
     */
    public Class<? extends biz.c24.trades.preon.Trades> getPreonClass() {
        return biz.c24.trades.preon.Trades.class;
    }

    /**
     */
    public biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 getPreonTypeHandler() {
        return biz.c24.trades.preon.Trades.getPreonTypeHandler();
    }

    /**
     * Returns the raw element data called <code>name</code> at
     * <code>index</code>.<p>
     * The legal value(s) for <code>name</code> are: <b>trade</b>.
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
            if (this.trade == null)
                throw new java.lang.IndexOutOfBoundsException();
            else
                return this.trade.get(index);
            default:
                return super.getElement(name, index);
        }
    }

    /**
     */
    public int getTotalElementCount() {
        int count = 0;
        count += this.trade == null ? 0 : this.trade.size();
        return count;
    }

    /**
     * Gets the value of Trade (1..*).
     * 
     * @return The value.
     */
    public java.util.List<biz.c24.trades.Trade> getTrade() {
        if (this.trade == null)
            return new java.util.ArrayList<biz.c24.trades.Trade>();
        else
            return this.trade;
    }

    /**
     * Gets the value of Trade by ordinal position in the
     * collection.
     * 
     * @param ordinal
     */
    public biz.c24.trades.Trade getTrade(int ordinal) {
        if (this.trade == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.trade.get(ordinal);
    }

    /**
     * Gets the index of <code>value</code> (1..*).
     * 
     * @param value
     * @param value The Trade to get the index of.
     * @return The index.
     */
    public int getTradeIndex(biz.c24.trades.Trade value) {
        if (this.trade == null)
            return -1;
        for (int i=0; i<this.trade.size(); i++)
            if (this.trade.get(i) == value)
                return i;
        return -1;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + hashCodeOf(serialVersionUID);
        result = 31 * result + hashCodeOf(NATIVE_ELEMENTS);
        result = 31 * result + hashCodeOf(trade);
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
                removeTrade(index);
                return;
            default:
            super.removeElement(name, index);
        }
    }

    /**
     * Removes a Trade (1..*).
     * 
     * @param index
     * @param index The index of the Trade to get.
     */
    public void removeTrade(int index) {
        if (this.trade == null || index > this.trade.size() - 1) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        this.trade.remove(index);
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
                if (value != null && value instanceof java.util.List) {
                    setTrade((java.util.List<biz.c24.trades.Trade>)value);
                } else if (this.trade == null) {
                    throw new java.lang.IndexOutOfBoundsException();
                } else if (value == null) {
                    removeElement(name, index);
                } else {
                    this.trade.set(index, (biz.c24.trades.Trade) value);
                    ((biz.c24.io.api.data.ComplexDataObject) this.trade.get(index)).setParent(this, "Trade");
                }
                return;
            default:
                super.setElement(name, index, value);
        }
    }

    /**
     * [Virtual Element] Sets the value of Trade (1..*).
     * 
     * @param value
     * @param value The new value.
     */
    public void setTrade(java.util.List value) {
        biz.c24.io.api.Utils.clearNulls(value);
        this.trade = value;
        for (int i=0; this.trade != null && i<this.trade.size(); i++)
            ((biz.c24.io.api.data.ComplexDataObject) this.trade.get(i)).setParent(this, "Trade");
    }

    /**
     * 
     * 
     * @param preon
     */
    public static biz.c24.trades.Trades toCdo(biz.c24.trades.preon.Trades preon) {
        int index = preon.getBufferOffset();
        byte[] data = preon.getPreonData();
        int dataOffset = preon.getPreonDataOffset();
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.Trades.getPreonTypeHandler();
        biz.c24.trades.Trades cdo = new biz.c24.trades.Trades();

        // Read Trade
        {
            int cardinality = preonTypeHandler.readInt(data, index);
            index += preonTypeHandler.skipInt(data, index);
            java.util.List<biz.c24.trades.Trade> list = new java.util.LinkedList<biz.c24.trades.Trade>();
            for(int i=0; i < cardinality; i++) {
                int length = preonTypeHandler.readInt(data, index);
                index += preonTypeHandler.skipInt(data, index);
                index += length;
                biz.c24.trades.Trade childCdo = biz.c24.trades.Trade.toCdo(biz.c24.trades.preon.Trade.allocate(data, dataOffset, index - length));
                list.add(childCdo);
            }
            cdo.setTrade(list);
        }
        return cdo;
    }

    /**
     */
    public biz.c24.trades.preon.Trades toPreon() throws java.io.IOException {
        return toPreon(new biz.c24.io.api.presentation.stream.FastByteArrayOutputStream(48));
    }

    /**
     * 
     * 
     * @param stream
     */
    public biz.c24.trades.preon.Trades toPreon(final biz.c24.io.api.presentation.stream.FastByteArrayOutputStream stream) throws java.io.IOException {
        writePreon(stream, null);
        biz.c24.trades.preon.Trades preon = biz.c24.trades.preon.Trades.allocate(stream.toByteArray(), 0);
        return preon;
    }

    /**
     */
    public biz.c24.io.api.data.preon.util.PreonContext toPreonWithContext() throws java.io.IOException {
        biz.c24.io.api.presentation.stream.FastByteArrayOutputStream stream = new biz.c24.io.api.presentation.stream.FastByteArrayOutputStream(48);
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.Trades.getPreonTypeHandler();
        biz.c24.io.api.data.preon.util.PreonContext preonContext = new biz.c24.io.api.data.preon.util.PreonContext("Root", null);
        writePreon(stream, preonContext);
        biz.c24.trades.preon.Trades preon = biz.c24.trades.preon.Trades.allocate(stream.toByteArray(), 0);
        preonContext.setPreon(preon);
        return preonContext;
    }

    /**
     */
    public void validateMandatory() throws biz.c24.io.api.data.ValidationException {
        if (getTrade() != null && getTrade().size() > 0) {
            for(biz.c24.trades.Trade child : (java.util.Collection<biz.c24.trades.Trade>)getTrade()) {
                child.validateMandatory();
            }
        } else {
            biz.c24.io.api.data.ValidationManager mgr = new biz.c24.io.api.data.ValidationManager();
            biz.c24.io.api.data.ValidationEvent event = new biz.c24.io.api.data.ValidationEvent(this, biz.c24.io.api.ValidationResultEnum.FAILED_SET_MISSING_MANDATORY_ELEMENTS, new biz.c24.io.api.data.EventMessage("Missing mandatory field Trade"));
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
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.Trades.getPreonTypeHandler();
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
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.Trades.getPreonTypeHandler();
        int startOffset = stream.size();


        // Write Trade
        {
            int cardinality = getTrade().size();
            if (preonContext != null) {
                preonContext.add("Cardinality", cardinality, preonTypeHandler.write(stream, cardinality));
            } else {
                preonTypeHandler.write(stream, cardinality);
            }
            for(int i=0; i < cardinality; i++) {
                writePreon(stream, getTrade(i), "Trade", preonTypeHandler, preonContext);
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
        out.writeObject(this.trade);
    }

    /**
     * 
     * 
     * @param in
     */
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        this.trade = (java.util.List<biz.c24.trades.Trade>) in.readObject();
    }

}
