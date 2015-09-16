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
 * This object is composed of the following <i>elements</i>:
 * <ul>
 * <li><b>Header</b> of type {@link biz.c24.trades.Header}
 * (0..1)</li>
 * <li><b>Trade</b> of type {@link biz.c24.trades.Trade}
 * (1..*)</li>
 * </ul>
 * 
 * 
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 * @see biz.c24.trades.TradesCls
 */
public class Trades extends biz.c24.io.api.data.ComplexDataObject {

    /**
     * Field serialVersionUID.
     */
    private static final long serialVersionUID = 12L;

    /**
     * Field NATIVE_ELEMENTS.
     */
    private static final java.lang.String[] NATIVE_ELEMENTS = new String[] {"Header", "Trade"};

    /**
     * Field header.
     */
    private biz.c24.trades.Header header;

    /**
     * Field trade.
     */
    private java.util.List<biz.c24.trades.Trade> trade;

    public Trades() {
        this(biz.c24.trades.TradesCls.getInstance().getNullDefiningElementDecl());
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
                setHeader((biz.c24.trades.Header) value);
                return;
            case 1:
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
        obj.header = (biz.c24.trades.Header) biz.c24.io.api.Utils.cloneDeep(this.header, obj, "Header");
        obj.trade = (java.util.List<biz.c24.trades.Trade>) biz.c24.io.api.Utils.cloneDeep(this.trade, obj, "Trade");
    }

    /**
     * Creates, adds and returns a new Header (0..1).
     * 
     * @return The new value.
     */
    public biz.c24.trades.Header createHeader() {
        biz.c24.trades.Header obj = (biz.c24.trades.Header) getElementDecl("Header").createObject();
        setHeader(obj);
        return obj;
    }

    /**
     * 
     * 
     * @param buffer
     */
    public biz.c24.io.api.data.SimpleDataObject createSDO(byte[] buffer) {
        return new biz.c24.trades.sdo.Trades(buffer, 0);
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
     * The legal value(s) for <code>name</code> are: <b>header,
     * trade</b>.
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
                return getHeader();
            case 1:
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
                return this.header == null ? 0 : 1;
            case 1:
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
                return this.header != null && this.header.equals(element) ? 0 : -1;
            case 1:
                return getTradeIndex((biz.c24.trades.Trade) element);
            default:
                return super.getElementIndex(name, element);
        }
    }

    /**
     * Gets the value of Header (0..1).
     * 
     * @return The value.
     */
    public biz.c24.trades.Header getHeader() {
        return this.header;
    }

    /**
     * Returns the raw element data called <code>name</code> at
     * <code>index</code>.<p>
     * The legal value(s) for <code>name</code> are: <b>header,
     * trade</b>.
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
                return this.header;
            case 1:
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
        count += this.header == null ? 0 : 1;
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
        result = 31 * result + hashCodeOf(header);
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
                setHeader(null);
                return;
            case 1:
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
                setHeader((biz.c24.trades.Header) value);
                return;
            case 1:
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
     * [Virtual Element] Sets the value of Header (0..1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setHeader(biz.c24.trades.Header value) {
        this.header = value;
        if (this.header != null)
            ((biz.c24.io.api.data.ComplexDataObject) this.header).setParent(this, "Header");
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
     * @param out
     */
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        out.writeObject(this.header);
        out.writeObject(this.trade);
    }

    /**
     * 
     * 
     * @param in
     */
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        this.header = (biz.c24.trades.Header) in.readObject();
        this.trade = (java.util.List<biz.c24.trades.Trade>) in.readObject();
    }

}
