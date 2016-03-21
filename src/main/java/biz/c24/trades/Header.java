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
public class Header extends biz.c24.io.api.data.ComplexDataObject 
implements biz.c24.io.api.data.preon.util.PreonConvertible
{

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
    public biz.c24.io.api.data.preon.PreonDataObject createPREON(byte[] buffer) {
        return new biz.c24.trades.preon.Header(buffer, 0);
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
     * Returns the number of bits in the bitmask that this type
     * uses to indicate the presence of optional attributes and
     * elements.
     */
    public static int getBitmaskLength() {
        return 1;
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
     */
    public Class<? extends biz.c24.trades.preon.Header> getPreonClass() {
        return biz.c24.trades.preon.Header.class;
    }

    /**
     */
    public biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 getPreonTypeHandler() {
        return biz.c24.trades.preon.Header.getPreonTypeHandler();
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
     * @param preon
     */
    public static biz.c24.trades.Header toCdo(biz.c24.trades.preon.Header preon) {
        int index = preon.getBufferOffset();
        byte[] data = preon.getPreonData();
        int dataOffset = preon.getPreonDataOffset();
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.Header.getPreonTypeHandler();
        biz.c24.trades.Header cdo = new biz.c24.trades.Header();
        // Store the details of our presence bitmap
        final byte bitmask0 = preonTypeHandler.readByte(data, index + 0);
        index += preonTypeHandler.skipBitmask(data, index, getBitmaskLength(), getBitmaskLength());


        // Read ID
        {
            cdo.setID(preonTypeHandler.readString(data, index));
            index += preonTypeHandler.skipString(data, index);
        }
        // Read TradeDate
        {
            cdo.setTradeDate(biz.c24.io.api.data.Java8Utils.fromIOType(preonTypeHandler.readISO8601Date(data, index)));
            index += preonTypeHandler.skipISO8601Date(data, index);
        }
        // Read BuySell
        {
            cdo.setBuySell(preonTypeHandler.readString(data, index));
            index += preonTypeHandler.skipString(data, index);
        }
        // Read Currency1
        {
            cdo.setCurrency1(preonTypeHandler.readString(data, index));
            index += preonTypeHandler.skipString(data, index);
        }
        // Read Amount1
        {
            cdo.setAmount1(preonTypeHandler.readString(data, index));
            index += preonTypeHandler.skipString(data, index);
        }
        // Read Exchange Rate
        {
            cdo.setExchangeRate(preonTypeHandler.readString(data, index));
            index += preonTypeHandler.skipString(data, index);
        }
        // Read Currency2
        {
            cdo.setCurrency2(preonTypeHandler.readString(data, index));
            index += preonTypeHandler.skipString(data, index);
        }
        // Read Amount2
        {
            cdo.setAmount2(preonTypeHandler.readString(data, index));
            index += preonTypeHandler.skipString(data, index);
        }
        // Read Settlment Date
        {
            cdo.setSettlmentDate(biz.c24.io.api.data.Java8Utils.fromIOType(preonTypeHandler.readISO8601Date(data, index)));
            index += preonTypeHandler.skipISO8601Date(data, index);
        }
        // Read anyType
        {
            if ((bitmask0 & 1) != 0) {
                cdo.setAnyType(preonTypeHandler.readString(data, index));
                index += preonTypeHandler.skipString(data, index);
            } else {
                // Do nothing
            }
        }
        return cdo;
    }

    /**
     */
    public biz.c24.trades.preon.Header toPreon() throws java.io.IOException {
        return toPreon(new biz.c24.io.api.presentation.stream.FastByteArrayOutputStream(72));
    }

    /**
     * 
     * 
     * @param stream
     */
    public biz.c24.trades.preon.Header toPreon(final biz.c24.io.api.presentation.stream.FastByteArrayOutputStream stream) throws java.io.IOException {
        writePreon(stream, null);
        biz.c24.trades.preon.Header preon = biz.c24.trades.preon.Header.allocate(stream.toByteArray(), 0);
        return preon;
    }

    /**
     */
    public biz.c24.io.api.data.preon.util.PreonContext toPreonWithContext() throws java.io.IOException {
        biz.c24.io.api.presentation.stream.FastByteArrayOutputStream stream = new biz.c24.io.api.presentation.stream.FastByteArrayOutputStream(72);
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.Header.getPreonTypeHandler();
        biz.c24.io.api.data.preon.util.PreonContext preonContext = new biz.c24.io.api.data.preon.util.PreonContext("Root", null);
        writePreon(stream, preonContext);
        biz.c24.trades.preon.Header preon = biz.c24.trades.preon.Header.allocate(stream.toByteArray(), 0);
        preonContext.setPreon(preon);
        return preonContext;
    }

    /**
     */
    public void validateMandatory() throws biz.c24.io.api.data.ValidationException {
        if (getID() != null) {
        } else {
            biz.c24.io.api.data.ValidationManager mgr = new biz.c24.io.api.data.ValidationManager();
            biz.c24.io.api.data.ValidationEvent event = new biz.c24.io.api.data.ValidationEvent(this, biz.c24.io.api.ValidationResultEnum.FAILED_SET_MISSING_MANDATORY_ELEMENTS, new biz.c24.io.api.data.EventMessage("Missing mandatory field ID"));
            mgr.fireValidationEvent(event);
        }
        if (getTradeDate() != null) {
        } else {
            biz.c24.io.api.data.ValidationManager mgr = new biz.c24.io.api.data.ValidationManager();
            biz.c24.io.api.data.ValidationEvent event = new biz.c24.io.api.data.ValidationEvent(this, biz.c24.io.api.ValidationResultEnum.FAILED_SET_MISSING_MANDATORY_ELEMENTS, new biz.c24.io.api.data.EventMessage("Missing mandatory field TradeDate"));
            mgr.fireValidationEvent(event);
        }
        if (getBuySell() != null) {
        } else {
            biz.c24.io.api.data.ValidationManager mgr = new biz.c24.io.api.data.ValidationManager();
            biz.c24.io.api.data.ValidationEvent event = new biz.c24.io.api.data.ValidationEvent(this, biz.c24.io.api.ValidationResultEnum.FAILED_SET_MISSING_MANDATORY_ELEMENTS, new biz.c24.io.api.data.EventMessage("Missing mandatory field BuySell"));
            mgr.fireValidationEvent(event);
        }
        if (getCurrency1() != null) {
        } else {
            biz.c24.io.api.data.ValidationManager mgr = new biz.c24.io.api.data.ValidationManager();
            biz.c24.io.api.data.ValidationEvent event = new biz.c24.io.api.data.ValidationEvent(this, biz.c24.io.api.ValidationResultEnum.FAILED_SET_MISSING_MANDATORY_ELEMENTS, new biz.c24.io.api.data.EventMessage("Missing mandatory field Currency1"));
            mgr.fireValidationEvent(event);
        }
        if (getAmount1() != null) {
        } else {
            biz.c24.io.api.data.ValidationManager mgr = new biz.c24.io.api.data.ValidationManager();
            biz.c24.io.api.data.ValidationEvent event = new biz.c24.io.api.data.ValidationEvent(this, biz.c24.io.api.ValidationResultEnum.FAILED_SET_MISSING_MANDATORY_ELEMENTS, new biz.c24.io.api.data.EventMessage("Missing mandatory field Amount1"));
            mgr.fireValidationEvent(event);
        }
        if (getExchangeRate() != null) {
        } else {
            biz.c24.io.api.data.ValidationManager mgr = new biz.c24.io.api.data.ValidationManager();
            biz.c24.io.api.data.ValidationEvent event = new biz.c24.io.api.data.ValidationEvent(this, biz.c24.io.api.ValidationResultEnum.FAILED_SET_MISSING_MANDATORY_ELEMENTS, new biz.c24.io.api.data.EventMessage("Missing mandatory field Exchange Rate"));
            mgr.fireValidationEvent(event);
        }
        if (getCurrency2() != null) {
        } else {
            biz.c24.io.api.data.ValidationManager mgr = new biz.c24.io.api.data.ValidationManager();
            biz.c24.io.api.data.ValidationEvent event = new biz.c24.io.api.data.ValidationEvent(this, biz.c24.io.api.ValidationResultEnum.FAILED_SET_MISSING_MANDATORY_ELEMENTS, new biz.c24.io.api.data.EventMessage("Missing mandatory field Currency2"));
            mgr.fireValidationEvent(event);
        }
        if (getAmount2() != null) {
        } else {
            biz.c24.io.api.data.ValidationManager mgr = new biz.c24.io.api.data.ValidationManager();
            biz.c24.io.api.data.ValidationEvent event = new biz.c24.io.api.data.ValidationEvent(this, biz.c24.io.api.ValidationResultEnum.FAILED_SET_MISSING_MANDATORY_ELEMENTS, new biz.c24.io.api.data.EventMessage("Missing mandatory field Amount2"));
            mgr.fireValidationEvent(event);
        }
        if (getSettlmentDate() != null) {
        } else {
            biz.c24.io.api.data.ValidationManager mgr = new biz.c24.io.api.data.ValidationManager();
            biz.c24.io.api.data.ValidationEvent event = new biz.c24.io.api.data.ValidationEvent(this, biz.c24.io.api.ValidationResultEnum.FAILED_SET_MISSING_MANDATORY_ELEMENTS, new biz.c24.io.api.data.EventMessage("Missing mandatory field Settlment Date"));
            mgr.fireValidationEvent(event);
        }
        if (getAnyType() != null) {
        }
    }

    /**
     * 
     * 
     * @param stream
     * @param preonContext
     */
    public int writePreon(final biz.c24.io.api.presentation.stream.FastByteArrayOutputStream stream,final biz.c24.io.api.data.preon.util.PreonContext preonContext) throws java.io.IOException {
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.Header.getPreonTypeHandler();
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
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.Header.getPreonTypeHandler();
        int startOffset = stream.size();

        byte[] bitmap = preonTypeHandler.createBitmask(getBitmaskLength());
        if (getAnyType() != null) {
            preonTypeHandler.setBit(bitmap, 0);
        }
        if (preonContext != null) {
            preonContext.add("Presence Bitmap", bitmap, preonTypeHandler.write(stream, bitmap, bitmap.length, bitmap.length));
        } else {
            preonTypeHandler.write(stream, bitmap, bitmap.length, bitmap.length);
        }

        // Write ID
        {
            if (preonContext != null) {
                preonContext.add("ID", getID(), preonTypeHandler.write(stream, getID()));
            } else {
                preonTypeHandler.write(stream, getID());
            }
        }
        // Write TradeDate
        {
            if (preonContext != null) {
                preonContext.add("TradeDate", biz.c24.io.api.data.Java8Utils.toIOType(getTradeDate()), preonTypeHandler.write(stream, biz.c24.io.api.data.Java8Utils.toIOType(getTradeDate())));
            } else {
                preonTypeHandler.write(stream, biz.c24.io.api.data.Java8Utils.toIOType(getTradeDate()));
            }
        }
        // Write BuySell
        {
            if (preonContext != null) {
                preonContext.add("BuySell", getBuySell(), preonTypeHandler.write(stream, getBuySell()));
            } else {
                preonTypeHandler.write(stream, getBuySell());
            }
        }
        // Write Currency1
        {
            if (preonContext != null) {
                preonContext.add("Currency1", getCurrency1(), preonTypeHandler.write(stream, getCurrency1()));
            } else {
                preonTypeHandler.write(stream, getCurrency1());
            }
        }
        // Write Amount1
        {
            if (preonContext != null) {
                preonContext.add("Amount1", getAmount1(), preonTypeHandler.write(stream, getAmount1()));
            } else {
                preonTypeHandler.write(stream, getAmount1());
            }
        }
        // Write Exchange Rate
        {
            if (preonContext != null) {
                preonContext.add("Exchange Rate", getExchangeRate(), preonTypeHandler.write(stream, getExchangeRate()));
            } else {
                preonTypeHandler.write(stream, getExchangeRate());
            }
        }
        // Write Currency2
        {
            if (preonContext != null) {
                preonContext.add("Currency2", getCurrency2(), preonTypeHandler.write(stream, getCurrency2()));
            } else {
                preonTypeHandler.write(stream, getCurrency2());
            }
        }
        // Write Amount2
        {
            if (preonContext != null) {
                preonContext.add("Amount2", getAmount2(), preonTypeHandler.write(stream, getAmount2()));
            } else {
                preonTypeHandler.write(stream, getAmount2());
            }
        }
        // Write Settlment Date
        {
            if (preonContext != null) {
                preonContext.add("Settlment Date", biz.c24.io.api.data.Java8Utils.toIOType(getSettlmentDate()), preonTypeHandler.write(stream, biz.c24.io.api.data.Java8Utils.toIOType(getSettlmentDate())));
            } else {
                preonTypeHandler.write(stream, biz.c24.io.api.data.Java8Utils.toIOType(getSettlmentDate()));
            }
        }
        // Write anyType
        {
            if (getAnyType() != null) {
                if (preonContext != null) {
                    preonContext.add("anyType", getAnyType(), preonTypeHandler.write(stream, getAnyType()));
                } else {
                    preonTypeHandler.write(stream, getAnyType());
                }
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
