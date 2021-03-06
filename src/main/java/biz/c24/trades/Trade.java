/*
 * $Id$
 */

package biz.c24.trades;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Arrays;

/**
 * Trade. <p/>
 * 
 * This object is composed of the following <i>elements</i>:
 * <ul>
 * <li><b>ID</b> of type <code>long</code> (1)</li>
 * <li><b>TradeDate</b> of type {@link java.time.LocalDate}
 * (1)</li>
 * <li><b>BuySell</b> of type {@link java.lang.String} (1)</li>
 * <li><b>Currency1</b> of type {@link java.lang.String} (1)</li>
 * <li><b>Amount1</b> of type {@link java.math.BigDecimal} (1)</li>
 * <li><b>Exchange Rate</b> of type <code>double</code> (1)</li>
 * <li><b>Currency2</b> of type {@link java.lang.String} (1)</li>
 * <li><b>Amount2</b> of type {@link java.math.BigDecimal} (1)</li>
 * <li><b>Settlement Date</b> of type {@link java.time.LocalDate}
 * (1)</li>
 * </ul>
 * 
 * 
 * @author C24 Integration Objects;
 * @version $Revision$ $Date$
 * @see biz.c24.trades.TradeDataType
 */
public class Trade extends biz.c24.io.api.data.ComplexDataObject 
implements biz.c24.io.api.data.preon.util.PreonConvertible
{

    /**
     * Field serialVersionUID.
     */
    private static final long serialVersionUID = 14L;

    /**
     * Field NATIVE_ELEMENTS.
     */
    private static final java.lang.String[] NATIVE_ELEMENTS = new String[] {"Amount1", "Amount2", "BuySell", "Currency1", "Currency2", "ExchangeRate", "ID", "SettlementDate", "TradeDate"};

    /**
     * Field iD.
     */
    private long iD;

    /**
     * Field isiDSet.
     */
    private boolean isiDSet;

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
    private java.math.BigDecimal amount1;

    /**
     * Field exchangeRate.
     */
    private double exchangeRate;

    /**
     * Field isexchangeRateSet.
     */
    private boolean isexchangeRateSet;

    /**
     * Field currency2.
     */
    private java.lang.String currency2;

    /**
     * Field amount2.
     */
    private java.math.BigDecimal amount2;

    /**
     * Field settlementDate.
     */
    private java.time.LocalDate settlementDate;

    public Trade() {
        this(biz.c24.trades.TradeDataType.getInstance().getNullDefiningElementDecl());
    }

    public Trade(biz.c24.io.api.data.Element definingElementDecl) {
        super(definingElementDecl);
    }

    public Trade(biz.c24.io.api.data.Element definingElementDecl, biz.c24.io.api.data.ComplexDataType type) {
        super(definingElementDecl, type);
    }

    public Trade(biz.c24.trades.Trade clone) {
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
                setID(biz.c24.io.api.Utils.longValue(value));
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
                setAmount1(biz.c24.io.api.Utils.decimalValue(value));
                return;
            case 5:
                setExchangeRate(biz.c24.io.api.Utils.doubleValue(value));
                return;
            case 4:
                setCurrency2((java.lang.String) value);
                return;
            case 1:
                setAmount2(biz.c24.io.api.Utils.decimalValue(value));
                return;
            case 7:
                setSettlementDate((java.time.LocalDate)(value));
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
        return new biz.c24.trades.Trade(this);
    }

    /**
     * Creates and returns a deep clone of this object.
     * 
     * @return The new object.
     * @see #clone()
     */
    public biz.c24.io.api.data.ComplexDataObject cloneDeep() throws java.lang.CloneNotSupportedException {
        biz.c24.io.api.data.ComplexDataObject obj = new biz.c24.trades.Trade(this);
        cloneDeep(obj);
        return obj;
    }

    /**
     * 
     * 
     * @param clone
     */
    protected void cloneDeep(biz.c24.io.api.data.ComplexDataObject clone) throws java.lang.CloneNotSupportedException {
        biz.c24.trades.Trade obj = (biz.c24.trades.Trade) clone;
        obj.isiDSet = this.isiDSet;
        obj.iD = this.iD;
        obj.tradeDate = (java.time.LocalDate) biz.c24.io.api.Utils.cloneDeep(this.tradeDate, obj, "TradeDate");
        obj.buySell = (java.lang.String) biz.c24.io.api.Utils.cloneDeep(this.buySell, obj, "BuySell");
        obj.currency1 = (java.lang.String) biz.c24.io.api.Utils.cloneDeep(this.currency1, obj, "Currency1");
        obj.amount1 = (java.math.BigDecimal) biz.c24.io.api.Utils.cloneDeep(this.amount1, obj, "Amount1");
        obj.isexchangeRateSet = this.isexchangeRateSet;
        obj.exchangeRate = this.exchangeRate;
        obj.currency2 = (java.lang.String) biz.c24.io.api.Utils.cloneDeep(this.currency2, obj, "Currency2");
        obj.amount2 = (java.math.BigDecimal) biz.c24.io.api.Utils.cloneDeep(this.amount2, obj, "Amount2");
        obj.settlementDate = (java.time.LocalDate) biz.c24.io.api.Utils.cloneDeep(this.settlementDate, obj, "SettlementDate");
    }

    /**
     * 
     * 
     * @param buffer
     */
    public biz.c24.io.api.data.preon.PreonDataObject createPREON(byte[] buffer) {
        return new biz.c24.trades.preon.Trade(buffer, 0);
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
    public java.math.BigDecimal getAmount1() {
        return this.amount1;
    }

    /**
     * Gets the value of Amount2 (1).
     * 
     * @return The value.
     */
    public java.math.BigDecimal getAmount2() {
        return this.amount2;
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
     * currency2, amount2, settlementDate</b>.
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
                return getSettlementDate();
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
                return this.isiDSet ? 1 : 0;
            case 8:
                return this.tradeDate == null ? 0 : 1;
            case 2:
                return this.buySell == null ? 0 : 1;
            case 3:
                return this.currency1 == null ? 0 : 1;
            case 0:
                return this.amount1 == null ? 0 : 1;
            case 5:
                return this.isexchangeRateSet ? 1 : 0;
            case 4:
                return this.currency2 == null ? 0 : 1;
            case 1:
                return this.amount2 == null ? 0 : 1;
            case 7:
                return this.settlementDate == null ? 0 : 1;
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
                return this.isiDSet ? (this.iD == biz.c24.io.api.Utils.longValue(element) ? 0 : -1) : -1;
            case 8:
                return this.tradeDate != null && this.tradeDate.equals(element) ? 0 : -1;
            case 2:
                return this.buySell != null && this.buySell.equals(element) ? 0 : -1;
            case 3:
                return this.currency1 != null && this.currency1.equals(element) ? 0 : -1;
            case 0:
                return this.amount1 != null && this.amount1.equals(element) ? 0 : -1;
            case 5:
                return this.isexchangeRateSet ? (this.exchangeRate == biz.c24.io.api.Utils.doubleValue(element) ? 0 : -1) : -1;
            case 4:
                return this.currency2 != null && this.currency2.equals(element) ? 0 : -1;
            case 1:
                return this.amount2 != null && this.amount2.equals(element) ? 0 : -1;
            case 7:
                return this.settlementDate != null && this.settlementDate.equals(element) ? 0 : -1;
            default:
                return super.getElementIndex(name, element);
        }
    }

    /**
     * Gets the value of ExchangeRate (1).
     * 
     * @return The value.
     */
    public double getExchangeRate() {
        return this.exchangeRate;
    }

    /**
     * Gets the value of ID (1).
     * 
     * @return The value.
     */
    public long getID() {
        return this.iD;
    }

    /**
     */
    public Class<? extends biz.c24.trades.preon.Trade> getPreonClass() {
        return biz.c24.trades.preon.Trade.class;
    }

    /**
     */
    public biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 getPreonTypeHandler() {
        return biz.c24.trades.preon.Trade.getPreonTypeHandler();
    }

    /**
     * Returns the raw element data called <code>name</code> at
     * <code>index</code>.<p>
     * The legal value(s) for <code>name</code> are: <b>iD,
     * tradeDate, buySell, currency1, amount1, exchangeRate,
     * currency2, amount2, settlementDate</b>.
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
                return this.settlementDate;
            default:
                return super.getElement(name, index);
        }
    }

    /**
     * Gets the value of SettlementDate (1).
     * 
     * @return The value.
     */
    public java.time.LocalDate getSettlementDate() {
        return this.settlementDate;
    }

    /**
     */
    public int getTotalElementCount() {
        int count = 0;
        count += this.isiDSet ? 1 : 0;
        count += this.tradeDate == null ? 0 : 1;
        count += this.buySell == null ? 0 : 1;
        count += this.currency1 == null ? 0 : 1;
        count += this.amount1 == null ? 0 : 1;
        count += this.isexchangeRateSet ? 1 : 0;
        count += this.currency2 == null ? 0 : 1;
        count += this.amount2 == null ? 0 : 1;
        count += this.settlementDate == null ? 0 : 1;
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
        result = 31 * result + hashCodeOf(isiDSet);
        result = 31 * result + hashCodeOf(tradeDate);
        result = 31 * result + hashCodeOf(buySell);
        result = 31 * result + hashCodeOf(currency1);
        result = 31 * result + hashCodeOf(amount1);
        result = 31 * result + hashCodeOf(exchangeRate);
        result = 31 * result + hashCodeOf(isexchangeRateSet);
        result = 31 * result + hashCodeOf(currency2);
        result = 31 * result + hashCodeOf(amount2);
        result = 31 * result + hashCodeOf(settlementDate);
        return result;
    }

    /**
     * Tests whether ExchangeRate has been set.
     */
    public boolean isExchangeRateSet() {
        return isexchangeRateSet;
    }

    /**
     * Tests whether ID has been set.
     */
    public boolean isIDSet() {
        return isiDSet;
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
                setID(0);
                this.isiDSet = false;
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
                setExchangeRate(0);
                this.isexchangeRateSet = false;
                return;
            case 4:
                setCurrency2(null);
                return;
            case 1:
                setAmount2(null);
                return;
            case 7:
                setSettlementDate(null);
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
    public void setAmount1(java.math.BigDecimal value) {
        this.amount1 = value;
    }

    /**
     * [Virtual Element] Sets the value of Amount2 (1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setAmount2(java.math.BigDecimal value) {
        this.amount2 = value;
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
                setID(biz.c24.io.api.Utils.longValue(value));
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
                setAmount1(biz.c24.io.api.Utils.decimalValue(value));
                return;
            case 5:
                setExchangeRate(biz.c24.io.api.Utils.doubleValue(value));
                return;
            case 4:
                setCurrency2((java.lang.String) value);
                return;
            case 1:
                setAmount2(biz.c24.io.api.Utils.decimalValue(value));
                return;
            case 7:
                setSettlementDate((java.time.LocalDate)(value));
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
    public void setExchangeRate(double value) {
        this.exchangeRate = value;
        this.isexchangeRateSet = true;
    }

    /**
     * [Virtual Element] Sets the value of ID (1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setID(long value) {
        this.iD = value;
        this.isiDSet = true;
    }

    /**
     * [Virtual Element] Sets the value of SettlementDate (1).
     * 
     * @param value
     * @param value The new value.
     */
    public void setSettlementDate(java.time.LocalDate value) {
        this.settlementDate = value;
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
    public static biz.c24.trades.Trade toCdo(biz.c24.trades.preon.Trade preon) {
        int index = preon.getBufferOffset();
        byte[] data = preon.getPreonData();
        int dataOffset = preon.getPreonDataOffset();
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.Trade.getPreonTypeHandler();
        biz.c24.trades.Trade cdo = new biz.c24.trades.Trade();

        // Read ID
        {
            cdo.setID(preonTypeHandler.readLong(data, index));
            index += preonTypeHandler.skipLong(data, index);
        }
        // Read TradeDate
        {
            cdo.setTradeDate(biz.c24.io.api.data.Java8Utils.fromIOType(preonTypeHandler.readISO8601Date(data, index)));
            index += preonTypeHandler.skipISO8601Date(data, index);
        }
        // Read BuySell
        {
            cdo.setBuySell(preonTypeHandler.readString(data, index, biz.c24.trades.preon.Trade.BuySellCommonValues));
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.BuySellCommonValues);
        }
        // Read Currency1
        {
            cdo.setCurrency1(preonTypeHandler.readString(data, index, biz.c24.trades.preon.Trade.Currency1CommonValues));
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.Currency1CommonValues);
        }
        // Read Amount1
        {
            cdo.setAmount1(preonTypeHandler.readBigDecimal(data, index));
            index += preonTypeHandler.skipBigDecimal(data, index);
        }
        // Read Exchange Rate
        {
            cdo.setExchangeRate(preonTypeHandler.readDouble(data, index));
            index += preonTypeHandler.skipDouble(data, index);
        }
        // Read Currency2
        {
            cdo.setCurrency2(preonTypeHandler.readString(data, index, biz.c24.trades.preon.Trade.Currency2CommonValues));
            index += preonTypeHandler.skipString(data, index, biz.c24.trades.preon.Trade.Currency2CommonValues);
        }
        // Read Amount2
        {
            cdo.setAmount2(preonTypeHandler.readBigDecimal(data, index));
            index += preonTypeHandler.skipBigDecimal(data, index);
        }
        // Read Settlement Date
        {
            cdo.setSettlementDate(biz.c24.io.api.data.Java8Utils.fromIOType(preonTypeHandler.readISO8601Date(data, index)));
            index += preonTypeHandler.skipISO8601Date(data, index);
        }
        return cdo;
    }

    /**
     */
    public biz.c24.trades.preon.Trade toPreon() throws java.io.IOException {
        return toPreon(new biz.c24.io.api.presentation.stream.FastByteArrayOutputStream(48));
    }

    /**
     * 
     * 
     * @param stream
     */
    public biz.c24.trades.preon.Trade toPreon(final biz.c24.io.api.presentation.stream.FastByteArrayOutputStream stream) throws java.io.IOException {
        writePreon(stream, null);
        biz.c24.trades.preon.Trade preon = biz.c24.trades.preon.Trade.allocate(stream.toByteArray(), 0);
        return preon;
    }

    /**
     */
    public biz.c24.io.api.data.preon.util.PreonContext toPreonWithContext() throws java.io.IOException {
        biz.c24.io.api.presentation.stream.FastByteArrayOutputStream stream = new biz.c24.io.api.presentation.stream.FastByteArrayOutputStream(48);
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.Trade.getPreonTypeHandler();
        biz.c24.io.api.data.preon.util.PreonContext preonContext = new biz.c24.io.api.data.preon.util.PreonContext("Root", null);
        writePreon(stream, preonContext);
        biz.c24.trades.preon.Trade preon = biz.c24.trades.preon.Trade.allocate(stream.toByteArray(), 0);
        preonContext.setPreon(preon);
        return preonContext;
    }

    /**
     */
    public void validateMandatory() throws biz.c24.io.api.data.ValidationException {
        if (isIDSet()) {
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
        if (isExchangeRateSet()) {
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
        if (getSettlementDate() != null) {
        } else {
            biz.c24.io.api.data.ValidationManager mgr = new biz.c24.io.api.data.ValidationManager();
            biz.c24.io.api.data.ValidationEvent event = new biz.c24.io.api.data.ValidationEvent(this, biz.c24.io.api.ValidationResultEnum.FAILED_SET_MISSING_MANDATORY_ELEMENTS, new biz.c24.io.api.data.EventMessage("Missing mandatory field Settlement Date"));
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
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.Trade.getPreonTypeHandler();
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
        biz.c24.io.api.preon.typeHandler.PreonTypeHandler2 preonTypeHandler = biz.c24.trades.preon.Trade.getPreonTypeHandler();
        int startOffset = stream.size();


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
                preonContext.add("BuySell", getBuySell(), preonTypeHandler.write(stream, getBuySell(), biz.c24.trades.preon.Trade.BuySellCommonValues));
            } else {
                preonTypeHandler.write(stream, getBuySell(), biz.c24.trades.preon.Trade.BuySellCommonValues);
            }
        }
        // Write Currency1
        {
            if (preonContext != null) {
                preonContext.add("Currency1", getCurrency1(), preonTypeHandler.write(stream, getCurrency1(), biz.c24.trades.preon.Trade.Currency1CommonValues));
            } else {
                preonTypeHandler.write(stream, getCurrency1(), biz.c24.trades.preon.Trade.Currency1CommonValues);
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
                preonContext.add("Currency2", getCurrency2(), preonTypeHandler.write(stream, getCurrency2(), biz.c24.trades.preon.Trade.Currency2CommonValues));
            } else {
                preonTypeHandler.write(stream, getCurrency2(), biz.c24.trades.preon.Trade.Currency2CommonValues);
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
        // Write Settlement Date
        {
            if (preonContext != null) {
                preonContext.add("Settlement Date", biz.c24.io.api.data.Java8Utils.toIOType(getSettlementDate()), preonTypeHandler.write(stream, biz.c24.io.api.data.Java8Utils.toIOType(getSettlementDate())));
            } else {
                preonTypeHandler.write(stream, biz.c24.io.api.data.Java8Utils.toIOType(getSettlementDate()));
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
        out.writeBoolean(this.isiDSet);
        if (this.isiDSet)
            out.writeLong(this.iD);
        out.writeObject(this.tradeDate);
        out.writeObject(this.buySell);
        out.writeObject(this.currency1);
        out.writeObject(this.amount1);
        out.writeBoolean(this.isexchangeRateSet);
        if (this.isexchangeRateSet)
            out.writeDouble(this.exchangeRate);
        out.writeObject(this.currency2);
        out.writeObject(this.amount2);
        out.writeObject(this.settlementDate);
    }

    /**
     * 
     * 
     * @param in
     */
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        this.isiDSet = in.readBoolean();
        if (this.isiDSet)
            this.iD = in.readLong();
        this.tradeDate = (java.time.LocalDate) in.readObject();
        this.buySell = (java.lang.String) in.readObject();
        this.currency1 = (java.lang.String) in.readObject();
        this.amount1 = (java.math.BigDecimal) in.readObject();
        this.isexchangeRateSet = in.readBoolean();
        if (this.isexchangeRateSet)
            this.exchangeRate = in.readDouble();
        this.currency2 = (java.lang.String) in.readObject();
        this.amount2 = (java.math.BigDecimal) in.readObject();
        this.settlementDate = (java.time.LocalDate) in.readObject();
    }

}
