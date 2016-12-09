package jhu.edu.WebStore.Helpers;

import java.util.Arrays;

/**
 * This domain class represents a credit card, including the card number,
 * expiration date, card type and card security value (CSV). Instances of this
 * class are immutable.
 * 
 * @author Petter Holmström (IT Mill)
 */
public final class CreditCard {

    /**
     * The length of a credit card number ({@value} ).
     */
    public static final int CREDIT_CARD_NUMBER_LENGTH = 16;

    /**
     * The minimum length of a card security value ({@value} ).
     */
    public static final int CSV_MIN_LENGTH = 3;

    /**
     * The maximum length of a card security value ({@value} ).
     */
    public static final int CSV_MAX_LENGTH = 4;

    private final char[] cardNumber;

    private final short expiresMonth;

    private final short expiresYear;

    private final char[] csv;

    private final CreditCardType type;

    private final String holderName;

    /**
     * Creates a new <code>CreditCard</code> with the specified information.
     * 
     * @param type
     *            the type of the card (must not be <code>null</code>).
     * @param holderName
     *            the name of the credit card's holder (must not be
     *            <code>null</code>).
     * @param cardNumber
     *            the card number in the form of an array of
     *            {@link #CREDIT_CARD_NUMBER_LENGTH} chars (must not be
     *            <code>null</code>).
     * @param expiresMonth
     *            the month of expiration (must be between 1 and 12).
     * @param expiresYear
     *            the year of expiration (must be between 0 and 99).
     * @param csv
     *            the card security value in the form of an array of at least
     *            {@link #CSV_MIN_LENGTH} and at most {@link #CSV_MAX_LENGTH}
     *            chars (must not be <code>null</code>).
     */
    public CreditCard(final CreditCardType type, final String holderName,
            final char[] cardNumber, final short expiresMonth,
            final short expiresYear, final char[] csv) {
        assert type != null : "type must not be null";
        assert holderName != null : "holderName must not be null";
        assert cardNumber != null : "cardNumber must not be null";
        assert cardNumber.length == CREDIT_CARD_NUMBER_LENGTH : "cardNumber must be of length "
                + CREDIT_CARD_NUMBER_LENGTH;
        assert expiresMonth >= 1 && expiresMonth <= 12 : "expiresMonth must be in the interval [1..12]";
        assert expiresYear >= 0 && expiresYear <= 99 : "expiresYear must be in the interval [0..99]";
        assert csv != null : "csv must not be null";
        assert csv.length >= CSV_MIN_LENGTH && csv.length <= CSV_MAX_LENGTH : "length of csv must be at least "
                + CSV_MIN_LENGTH + " and at most " + CSV_MAX_LENGTH;

        this.type = type;
        this.holderName = holderName;
        this.cardNumber = Arrays.copyOf(cardNumber, cardNumber.length);
        this.expiresMonth = expiresMonth;
        this.expiresYear = expiresYear;
        this.csv = Arrays.copyOf(csv, csv.length);
    }

    /**
     * Creates a new <code>CreditCard</code> with the specified information.
     * 
     * @param type
     *            the type of the card (must not be <code>null</code>).
     * @param holderName
     *            the name of the credit card's holder (must not be
     *            <code>null</code>).
     * @param cardNumber
     *            the card number in the form of a string of length
     *            {@link #CREDIT_CARD_NUMBER_LENGTH} (must not be
     *            <code>null</code>).
     * @param expiresMonth
     *            the month of expiration (must be between 1 and 12).
     * @param expiresYear
     *            the year of expiration (must be between 0 and 99).
     * @param csv
     *            the card security value in the form of string whose length is
     *            at least {@link #CSV_MIN_LENGTH} and at most
     *            {@link #CSV_MAX_LENGTH} (must not be <code>null</code>).
     */
    public CreditCard(final CreditCardType type, final String holderName,
            final String cardNumber, final short expiresMonth,
            final short expiresYear, final String csv) {
        this(type, holderName, cardNumber.toCharArray(), expiresMonth,
                expiresYear, csv.toCharArray());
    }

    @Override
    protected void finalize() throws Throwable {
        /*
         * Overwrite sensitive information with zeros.
         */
        for (int i = 0; i < cardNumber.length; i++) {
            cardNumber[i] = 0;
        }
        for (int i = 0; i < csv.length; i++) {
            csv[i] = 0;
        }
        super.finalize();
    }

    /**
     * Gets the credit card number. The returned array will contain
     * {@link #CREDIT_CARD_NUMBER_LENGTH} characters and it can be modified
     * without affecting this <code>CreditCard</code> instance.
     * 
     * @return an array containing the card number (never <code>null</code>).
     */
    public char[] getCardNumber() {
        return Arrays.copyOf(cardNumber, cardNumber.length);
    }

    /**
     * Gets the name of the credit card's holder.
     * 
     * @return the holder name (never <code>null</code>).
     */
    public String getHolderName() {
        return holderName;
    }

    /**
     * Gets the month of expiration. The returned short will always be in the
     * interval [1..12].
     * 
     * @return the month.
     */
    public short getExpiresMonth() {
        return expiresMonth;
    }

    /**
     * Gets the year of expiration. The returned short will always be in the
     * interval [0..99].
     * 
     * @return the year.
     */
    public short getExpiresYear() {
        return expiresYear;
    }

    /**
     * Gets the credit card security value (CSV). The returned array will
     * contain between {@link #CSV_MIN_LENGTH} and {@link #CSV_MAX_LENGTH}
     * characters, and it can be modified without affecting this
     * <code>CreditCard</code> instance.
     * 
     * @return an array containing the card security value (never
     *         <code>null</code>).
     */
    public char[] getCsv() {
        return Arrays.copyOf(csv, csv.length);
    }

    /**
     * Gets the credit card type.
     * 
     * @return the credit card type (never <code>null</code>).
     */
    public CreditCardType getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < cardNumber.length; i++) {
            if (i < (cardNumber.length - 4)) {
                number.append('x');
            } else {
                number.append(cardNumber[i]);
            }
        }
        return String.format("%s %s %02d/%02d", type, number.toString(),
                expiresMonth, expiresYear);
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = 97 * hash + holderName.hashCode();
        hash = 97 * hash + Arrays.hashCode(cardNumber);
        hash = 97 * hash + expiresMonth;
        hash = 97 * hash + expiresYear;
        hash = 97 * hash + Arrays.hashCode(csv);
        hash = 97 * hash + type.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final CreditCard other = (CreditCard) obj;
        if (!holderName.equals(other.holderName)) {
            return false;
        }
        if (!Arrays.equals(cardNumber, other.cardNumber)) {
            return false;
        }
        if (expiresMonth != other.expiresMonth
                || expiresYear != other.expiresYear) {
            return false;
        }
        if (!Arrays.equals(csv, other.csv)) {
            return false;
        }
        if (!type.equals(other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
