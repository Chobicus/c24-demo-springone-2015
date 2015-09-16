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
 * biz.c24.trades.TradesDocumentRootElement.TradesDocumentRootCls
 */
public class TradesDocumentRoot extends biz.c24.io.api.data.DocumentRoot {

    /**
     * Field serialVersionUID.
     */
    private static final long serialVersionUID = 12L;

    /**
     * Field NATIVE_ELEMENTS.
     */
    private static final java.lang.String[] NATIVE_ELEMENTS = new String[] {"trades"};

    /**
     * Field trades.
     */
    private biz.c24.trades.Trades trades;

    public TradesDocumentRoot() {
        this(biz.c24.trades.TradesDocumentRootElement.TradesDocumentRootCls.getInstance().getNullDefiningElementDecl());
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
    public biz.c24.io.api.data.SimpleDataObject createSDO(byte[] buffer) {
        return new biz.c24.trades.sdo.TradesDocumentRoot(buffer, 0);
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
