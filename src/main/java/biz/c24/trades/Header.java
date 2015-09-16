/*
 * $Id$
 */

package biz.c24.trades;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Arrays;

/**
 * Header. <p/>
 * 
 * This object is composed of the following <i>elements</i>:
 * <ul>
 * <li><b>ID</b> of type {@link java.lang.String} (1)</li>
 * <li><b>TradeDate</b> of type {@link java.time.LocalDate}
 * (1)</li>
 * <li><b>BuySell</b> of type {@link java.lang.String} (1)</li>
 * <li><b>Currency1</b> of type {@link java.lang.String} (1)</li>
 * <li><b>Amount1</b> of type {@link java.lang.String} (1)</li>
 * <li><b>Exchange Rate</b> of type {@link java.lang.String}
 * (1)</li>
 * <li><b>Currency2</b> of type {@link java.lang.String} (1)</li>
 * <li><b>Amount2</b> of type {@link java.lang.String} (1)</li>
 * <li><b>Settlment Date</b> of type {@link java.time.LocalDate}
 * (1)</li>
 * <li><b>anyType</b> of type {@link java.lang.String} (0..1)</li>
 * </ul>
 * 
 * 
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 * @see biz.c24.trades.HeaderDataType
 */
public class Header extends biz.c24.io.api.data.ComplexDataObject {

    /**
     * Field serialVersionUID.
     */
    private static final long serialVersionUID = 14L;

    /**
     * Field NATIVE_ELEMENTS.
     */
    private static final java.lang.String[] NATIVE_ELEMENTS = new String[] {"Amount1", "Amount2", "BuySell", "Currency1", "Currency2", "ExchangeRate", "ID", "SettlmentDate", "TradeDate", "anyType"};

    /**
     * Field iD.
     */
    private java.lang.String iD;

    /**
     * Field tradeDate.
     */
    private java.time.LocalDate tradeDate;

    /**
     * Field buySell.
     */
    private java.lang.String buySell;

    /**
     * Field currency1.
     */
    private java.lang.String currency1;

    /**
     * Field amount1.
     */
    private java.lang.String amount1;

    /**
     * Field exchangeRate.
     */
    private java.lang.String exchangeRate;

    /**
     * Field currency2.
     */
    private java.lang.String currency2;

    /**
     * Field amount2.
     */
    private java.lang.String amount2;

    /**
     * Field settlmentDate.
     */
    private java.time.LocalDate settlmentDate;

    /**
     * Field anyType.
     */
    private java.lang.String anyType;

    public Header() {
        this(biz.c24.trades.HeaderDataType.getInstance().getNullDefiningElementDecl());
    }

    public Header(biz.c24.io.api.data.Element definingElementDecl) {
        super(definingElementDecl);
    }

    public Header(biz.c24.io.api.data.Element definingElementDecl, biz.c24.io.api.data.ComplexDataType type) {
        super(definingElementDecl, type);
    }

    public Header(biz.c24.trades.Header clone) {
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
            case 6:
                setID((java.lang.String) value);
                return;
            case 8:
                setTradeDate((java.time.LocalDate)(value));
                return;
            case 2:
                setBuySell((java.lang.String) value);
                return;
            case 3:
                setCurrency1((java.lang.String) value);
                return;
            case 0:
                setAmount1((java.lang.String) value);
                return;
            case 5:
                setExchangeRate((java.lang.String) value);
                return;
            case 4:
                setCurrency2((java.lang.String) value);
                return;
            case 1:
                setAmount2((java.lang.String) value);
                return;
            case 7:
                setSettlmentDate((java.time.LocalDate)(value));
                return;
            case 9:
                setAnyType((java.lang.String) value);
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
        return new biz.c24.trades.Header(this);
    }

    /**
     * Creates and returns a deep clone of this object.
     * 
     * @return The new object.
     * @see #clone()
     */
    public biz.c24.io.api.data.ComplexDataObject cloneDeep() throws java.lang.CloneNotSupportedException {
        biz.c24.io.api.data.ComplexDataObject obj = new biz.c24.trades.Header(this);
        cloneDeep(obj);
        return obj;
    }

    /**
     * 
     * 
     * @param clone
     */
    protected void cloneDeep(biz.c24.io.api.data.ComplexDataObject clone) throws java.lang.CloneNotSupportedException {
        biz.c24.trades.Header obj = (biz.c24.trades.Header) clone;
        obj.iD = (java.lang.String) biz.c24.io.api.Utils.cloneDeep(this.iD, obj, "ID");
        obj.tradeDate = (java.time.LocalDate) biz.c24.io.api.Utils.cloneDeep(this.tradeDate, obj, "TradeDate");
        obj.buySell = (java.lang.String) biz.c24.io.api.Utils.cloneDeep(this.buySell, obj, "BuySell");
        obj.currency1 = (java.lang.String) biz.c24.io.api.Utils.cloneDeep(this.currency1, obj, "Currency1");
        obj.amount1 = (java.lang.String) biz.c24.io.api.Utils.cloneDeep(this.amount1, obj, "Amount1");
        obj.exchangeRate = (java.lang.String) biz.c24.io.api.Utils.cloneDeep(this.exchangeRate, obj, "ExchangeRate");
        obj.currency2 = (java.lang.String) biz.c24.io.api.Utils.cloneDeep(this.currency2, obj, "Currency2");
        obj.amount2 = (java.lang.String) biz.c24.io.api.Utils.cloneDeep(this.amount2, obj, "Amount2");
        obj.settlmentDate = (java.time.LocalDate) biz.c24.io.api.Utils.cloneDeep(this.settlmentDate, obj, "SettlmentDate");
        obj.anyType = (java.lang.String) biz.c24.io.api.Utils.cloneDeep(this.anyType, obj, "anyType");
    }

    /**
     * 
     * 
     * @param buffer
     */
    public biz.c24.io.api.data.SimpleDataObject createSDO(byte[] buffer) {
        return new biz.c24.trades.sdo.Header(buffer, 0);
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
     * Gets the value of Amount1 (1).
     * 
     * @return The value.
     */
    public java.lang.String getAmount1() {
        return this.amount1;
    }

    /**
     * Gets the value of Amount2 (1).
     * 
     * @return The value.
     */
    public java.lang.String getAmount2() {
        return this.amount2;
    }

    /**
     * Gets the value of anyType (0..1).
     * 
     * @return The value.
     */
    public java.lang.String getAnyType() {
        return this.anyType;
    }

    /**
     * Gets the value of BuySell (1).
     * 
     * @return The value.
     */
    public java.lang.String getBuySell() {
        return this.buySell;
    }

    /**
     * Gets the value of Currency1 (1).
     * 
     * @return The value.
     */
    public java.lang.String getCurrency1() {
        return this.currency1;
    }

    /**
     * Gets the value of Currency2 (1).
     * 
     * @return The value.
     */
    public java.lang.String getCurrency2() {
        return this.currency2;
    }

    /**
     * Returns the element called <code>name</code> at
     * <code>index</code>.<p>
     * The legal value(s) for <code>name</code> are: <b>iD,
     * tradeDate, buySell, currency1, amount1, exchangeRate,
     * currency2, amount2, settlmentDate, anyType</b>.
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
            case 6:
                return getID();
            case 8:
                return getTradeDate();
            case 2:
                return getBuySell();
            case 3:
                return getCurrency1();
            case 0:
                return getAmount1();
            case 5:
                return getExchangeRate();
            case 4:
                return getCurrency2();
            case 1:
                return getAmount2();
            case 7:
                return getSettlmentDate();
            case 9:
                return getAnyType();
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
            case 6:
                return this.iD == null ? 0 : 1;
            case 8:
                return this.tradeDate == null ? 0 : 1;
            case 2:
                return this.buySell == null ? 0 : 1;
            case 3:
                return this.currency1 == null ? 0 : 1;
            case 0:
                return this.amount1 == null ? 0 : 1;
            case 5:
                return this.exchangeRate == null ? 0 : 1;
            case 4:
                return this.currency2 == null ? 0 : 1;
            case 1:
                return this.amount2 == null ? 0 : 1;
            case 7:
                return this.settlmentDate == null ? 0 : 1;
            case 9:
                return this.anyType == null ? 0 : 1;
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
            case 6:
                return this.iD != null && this.iD.equals(element) ? 0 : -1;
            case 8:
                return this.tradeDate != null && this.tradeDate.equals(element) ? 0 : -1;
            case 2:
                return this.buySell != null && this.buySell.equals(element) ? 0 : -1;
            case 3:
                return this.currency1 != null && this.currency1.equals(element) ? 0 : -1;
            case 0:
                return this.amount1 != null && this.amount1.equals(element) ? 0 : -1;
            case 5:
                return this.exchangeRate != null && this.exchangeRate.equals(element) ? 0 : -1;
            case 4:
                return this.currency2 != null && this.currency2.equals(element) ? 0 : -1;
            case 1:
                return this.amount2 != null && this.amount2.equals(element) ? 0 : -1;
            case 7:
                return this.settlmentDate != null && this.settlmentDate.equals(element) ? 0 : -1;
            case 9:
                return this.anyType != null && this.anyType.equals(element) ? 0 : -1;
            default:
                return super.getElementIndex(name, element);
        }
    }

    /**
     * Gets the value of ExchangeRate (1).
     * 
     * @return The value.
     */
    public java.lang.String getExchangeRate() {
        return this.exchangeRate;
    }

    /**
     * Gets the value of ID (1).
     * 
     * @return The value.
     */
    public java.lang.String getID() {
        return this.iD;
    }

    /**
     * Returns the raw element data called <code>name</code> at
     * <code>index</code>.<p>
     * The legal value(s) for <code>name</code> are: <b>iD,
     * tradeDate, buySell, currency1, amount1, exchangeRate,
     * currency2, amount2, settlmentDate, anyType</b>.
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
            case 6:
                return this.iD;
            case 8:
                return this.tradeDate;
            case 2:
                return this.buySell;
            case 3:
                return this.currency1;
            case 0:
                return this.amount1;
            case 5:
                return this.exchangeRate;
            case 4:
                return this.currency2;
            case 1:
                return this.amount2;
            case 7:
                return this.settlmentDate;
            case 9:
                return this.anyType;
            default:
                return super.getElement(name, index);
        }
    }

    /**
     * Gets the value of SettlmentDate (1).
     * 
     * @return The value.
     */
    public java.time.LocalDate getSettlmentDate() {
        return this.settlmentDate;
    }

    /**
     */
    public int getTotalElementCount() {
        int count = 0;
        count += this.iD == null ? 0 : 1;
        count += this.tradeDate == null ? 0 : 1;
        count += this.buySell == null ? 0 : 1;
        count += this.currency1 == null ? 0 : 1;
        count += this.amount1 == null ? 0 : 1;
        count += this.exchangeRate == null ? 0 : 1;
        count += this.currency2 == null ? 0 : 1;
        count += this.amount2 == null ? 0 : 1;
        count += this.settlmentDate == null ? 0 : 1;
        count += this.anyType == null ? 0 : 1;
        return count;
    }

    /**
     * Gets the value of TradeDate (1).
     * 
     * @return The value.
     */
    public java.time.LocalDate getTradeDate() {
        return this.tradeDate;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + hashCodeOf(serialVersionUID);
        result = 31 * result + hashCodeOf(NATIVE_ELEMENTS);
        result = 31 * result + hashCodeOf(iD);
        result = 31 * result + hashCodeOf(tradeDate);
        result = 31 * result + hashCodeOf(buySell);
        result = 31 * result + hashCodeOf(currency1);
        result = 31 * result + hashCodeOf(amount1);
        result = 31 * result + hashCodeOf(exchangeRate);
        result = 31 * result + hashCodeOf(currency2);
        result = 31 * result + hashCodeOf(amount2);
        result = 31 * result + hashCodeOf(settlmentDate);
        result = 31 * result + hashCodeOf(anyType);
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
            case 6:
                setID(null);
                return;
            case 8:
                setTradeDate(null);
                return;
            case 2:
                setBuySell(null);
                return;
            case 3:
                setCurrency1(null);
                return;
            case 0:
                setAmount1(null);
                return;
            case 5:
                setExchangeRate(null);
                return;
            case 4:
                setCurrency2(null);
                return;
            case 1:
                setAmount2(null);
                return;
            case 7:
                setSettlmentDate(null);
                return;
            case 9:
                setAnyType(null);
                return;
            default:
            super.removeElement(name, index);
        }
    }

    /**
     * [Virtual Element] Sets the value of Amount1 (1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setAmount1(java.lang.String value) {
        this.amount1 = value;
    }

    /**
     * [Virtual Element] Sets the value of Amount2 (1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setAmount2(java.lang.String value) {
        this.amount2 = value;
    }

    /**
     * [Virtual Element] Sets the value of anyType (0..1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setAnyType(java.lang.String value) {
        this.anyType = value;
    }

    /**
     * [Virtual Element] Sets the value of BuySell (1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setBuySell(java.lang.String value) {
        this.buySell = value;
    }

    /**
     * [Virtual Element] Sets the value of Currency1 (1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setCurrency1(java.lang.String value) {
        this.currency1 = value;
    }

    /**
     * [Virtual Element] Sets the value of Currency2 (1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setCurrency2(java.lang.String value) {
        this.currency2 = value;
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
            case 6:
                setID((java.lang.String) value);
                return;
            case 8:
                setTradeDate((java.time.LocalDate)(value));
                return;
            case 2:
                setBuySell((java.lang.String) value);
                return;
            case 3:
                setCurrency1((java.lang.String) value);
                return;
            case 0:
                setAmount1((java.lang.String) value);
                return;
            case 5:
                setExchangeRate((java.lang.String) value);
                return;
            case 4:
                setCurrency2((java.lang.String) value);
                return;
            case 1:
                setAmount2((java.lang.String) value);
                return;
            case 7:
                setSettlmentDate((java.time.LocalDate)(value));
                return;
            case 9:
                setAnyType((java.lang.String) value);
                return;
            default:
                super.setElement(name, index, value);
        }
    }

    /**
     * [Virtual Element] Sets the value of ExchangeRate (1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setExchangeRate(java.lang.String value) {
        this.exchangeRate = value;
    }

    /**
     * [Virtual Element] Sets the value of ID (1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setID(java.lang.String value) {
        this.iD = value;
    }

    /**
     * [Virtual Element] Sets the value of SettlmentDate (1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setSettlmentDate(java.time.LocalDate value) {
        this.settlmentDate = value;
    }

    /**
     * [Virtual Element] Sets the value of TradeDate (1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setTradeDate(java.time.LocalDate value) {
        this.tradeDate = value;
    }

    /**
     * 
     * 
     * @param out
     */
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        out.writeObject(this.iD);
        out.writeObject(this.tradeDate);
        out.writeObject(this.buySell);
        out.writeObject(this.currency1);
        out.writeObject(this.amount1);
        out.writeObject(this.exchangeRate);
        out.writeObject(this.currency2);
        out.writeObject(this.amount2);
        out.writeObject(this.settlmentDate);
        out.writeObject(this.anyType);
    }

    /**
     * 
     * 
     * @param in
     */
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        this.iD = (java.lang.String) in.readObject();
        this.tradeDate = (java.time.LocalDate) in.readObject();
        this.buySell = (java.lang.String) in.readObject();
        this.currency1 = (java.lang.String) in.readObject();
        this.amount1 = (java.lang.String) in.readObject();
        this.exchangeRate = (java.lang.String) in.readObject();
        this.currency2 = (java.lang.String) in.readObject();
        this.amount2 = (java.lang.String) in.readObject();
        this.settlmentDate = (java.time.LocalDate) in.readObject();
        this.anyType = (java.lang.String) in.readObject();
    }

}
