/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhu.edu.WebStore.ViewsAndControl;

import com.sun.org.apache.xalan.internal.utils.FeatureManager;
import com.vaadin.data.Container;
import com.vaadin.data.Validator;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import jhu.edu.WebStore.Helpers.CreditCard;
import jhu.edu.WebStore.Helpers.CreditCardType;
import jhu.edu.WebStore.Helpers.State;

/**
 *
 * @author Sharnay
 */
public class CreditCardForm extends CustomLayout{
    
    private static final String STYLE_CREDIT_CARD_FORM = "creditCardForm";
    
    private ComboBox card;
    
    private TextField nr1, nr2, nr3, nr4;
    private TextField year, month, csv;
    private TextField fName, lName, street, zip, city;
    private ComboBox state;
    
    public CreditCardForm() {
        super("creditcardlayout");
        setWidth("350px");
        
        addStyleName(STYLE_CREDIT_CARD_FORM);
        
        initializeComponents();
    }
    
    /**
     * Initializes the components in this view and sets their default parameters
     */
    private void initializeComponents() {
        
        //VerticalLayout leftLayout = new VerticalLayout();
        //VerticalLayout rightLayout = new VerticalLayout();

        card = new ComboBox();
        card.setImmediate(false);
        card.setBuffered(true);
        card.setWidth("220px");
        card.setInputPrompt("Select credit card");

        addComponent(card, "ccselect");

        nr1 = new TextField();
        nr1.setBuffered(true);
        nr1.setImmediate(false);
        nr1.setWidth("60px");
        nr1.setInputPrompt("xxxx");
        nr1.setMaxLength(4);

        nr2 = new TextField();
        nr2.setBuffered(true);
        nr2.setImmediate(false);
        nr2.setWidth("60px");
        nr2.setInputPrompt("xxxx");
        nr2.setMaxLength(4);

        nr3 = new TextField();
        nr3.setBuffered(true);;
        nr3.setImmediate(false);
        nr3.setWidth("60px");
        nr3.setInputPrompt("xxxx");
        nr3.setMaxLength(4);

        nr4 = new TextField();
        nr4.setBuffered(true);
        nr4.setImmediate(false);
        nr4.setWidth("60px");
        nr4.setInputPrompt("xxxx");
        nr4.setMaxLength(4);

        addComponent(nr1, "ccnr1");
        addComponent(nr2, "ccnr2");
        addComponent(nr3, "ccnr3");
        addComponent(nr4, "ccnr4");

        month = new TextField();
        month.setBuffered(true);
        month.setImmediate(false);
        month.setWidth("50px");
        month.setInputPrompt("mm");
        month.setMaxLength(2);

        addComponent(month, "month");

        year = new TextField();
        year.setBuffered(true);
        year.setImmediate(false);
        year.setWidth("50px");
        year.setInputPrompt("yy");
        year.setMaxLength(4);

        addComponent(year, "year");

        csv = new TextField();
        csv.setBuffered(true);
        csv.setImmediate(false);
        csv.setWidth("50px");
        csv.setInputPrompt("csv");
        csv.setMaxLength(CreditCard.CSV_MAX_LENGTH);

        addComponent(csv, "csv");

        fName = new TextField();
        fName.setBuffered(true);
        fName.setImmediate(false);
        fName.setWidth("124px");
        fName.setCaption("First name");

        addComponent(fName, "fname");

        lName = new TextField();
        lName.setBuffered(true);
        lName.setImmediate(false);
        lName.setWidth("180px");
        lName.setCaption("Last name");

        addComponent(lName, "lname");

        street = new TextField();
        street.setBuffered(true);
        street.setImmediate(false);
        street.setWidth("308px");
        street.setCaption("Address");
        street.setInputPrompt("Street");
        addComponent(street, "street");

        zip = new TextField();
        zip.setBuffered(true);
        zip.setImmediate(false);
        zip.setWidth("70px");
        zip.setInputPrompt("Zip");

        addComponent(zip, "zip");

        city = new TextField();
        city.setBuffered(true);
        city.setImmediate(false);
        city.setWidth("100px");
        city.setInputPrompt("City");

        addComponent(city, "city");

        state = new ComboBox();
        state.setBuffered(true);
        state.setImmediate(false);
        state.setWidth("130px");
        state.setInputPrompt("State");
        state.setNullSelectionAllowed(false);

        addComponent(state, "state");

        createValidators();
    }
    
    /**
     * Creates the validators that are used in this form
     */
    private void createValidators() {

        Validator cardNumberValidator = new RegexpValidator("^\\d{4}$",
                "Credit card number should have 4 sets of 4 digits!");

        nr1.addValidator(cardNumberValidator);
        nr2.addValidator(cardNumberValidator);
        nr3.addValidator(cardNumberValidator);
        nr4.addValidator(cardNumberValidator);

        // Years are also 4 digits, so we can use the ccValidator for it to
        // begin with

        year.addValidator(new RegexpValidator("^\\d{4}$|^\\d{2}$",
                "Year must be in the form xxxx or xx!"));

        Validator monthValidator = new RegexpValidator("^0[1-9]|1[0-2]$",
                "Months shold be 01-12!");

        month.addValidator(monthValidator);

        csv.addValidator(new RegexpValidator("^\\d{3}$",
                "Confirmation number should be 3 digits"));

        zip.addValidator(new RegexpValidator("\\d{5}", "Zip must be 5 digits"));

    }
    
    /**
     * Set the available credit cards that can be used in this form
     */
    public void setAvailableCreditCards() {

        for (CreditCardType cct : CreditCardType.values()) {
            card.addItem(cct);
        }

    }

    /**
     * Set the current city/postalOffice
     * 
     * @param cityorpostal
     */
    public void setCityOrPostalOffice(String cityorpostal) {
        city.setValue(cityorpostal);
    }

    /**
     * Set the countries that user can choose from
     * 
     * @param countries
     */
    public void setAvailableCountries() {
        for(State stateName: State.values()) {
            state.addItem(stateName.toString());
        }

    }

    /**
     * Checks that all fields are correctly filled in and that they are not
     * empty.
     * 
     * @return
     */
    public boolean checkFields() throws InvalidValueException {
        boolean fieldsOk = true;

        if (card.getValue() != card.getNullSelectionItemId()) {
            card.setRequired(false);
        } else {
            card.setRequired(true);
            fieldsOk = false;
        }

        nr1.validate();
        nr2.validate();
        nr3.validate();
        nr4.validate();

        year.validate();
        month.validate();
        csv.validate();
        fName.validate();
        lName.validate();
        street.validate();
        zip.validate();
        city.validate();
        state.validate();

        if (nr1.getValue() == nr1.getNullRepresentation()
                || ((String) nr1.getValue()).equalsIgnoreCase("")) {
            nr1.setRequired(true);
            fieldsOk = false;
        } else {
            nr1.setRequired(false);
        }

        if (nr2.getValue() == nr2.getNullRepresentation()
                || ((String) nr2.getValue()).equals("")) {
            nr2.setRequired(true);
            fieldsOk = false;
        } else {
            nr2.setRequired(false);
        }

        if (nr3.getValue() == nr3.getNullRepresentation()
                || ((String) nr3.getValue()).equals("")) {
            nr3.setRequired(true);
            fieldsOk = false;
        } else {
            nr3.setRequired(false);
        }

        if (nr4.getValue() == nr4.getNullRepresentation()
                || ((String) nr4.getValue()).equals("")) {
            nr4.setRequired(true);
            fieldsOk = false;
        } else {
            nr4.setRequired(false);
        }

        if (year.getValue() == year.getNullRepresentation()
                || ((String) year.getValue()).equals("")) {
            year.setRequired(true);
            fieldsOk = false;
        } else {
            year.setRequired(false);
        }

        if (month.getValue() == month.getNullRepresentation()
                || ((String) month.getValue()).equals("")) {
            month.setRequired(true);
            fieldsOk = false;
        } else {
            month.setRequired(false);
        }

        if (csv.getValue() == csv.getNullRepresentation()
                || ((String) csv.getValue()).equals("")) {
            csv.setRequired(true);
            fieldsOk = false;
        } else {
            csv.setRequired(false);
        }

        if (fName.getValue() == fName.getNullRepresentation()
                || ((String) fName.getValue()).equals("")) {
            fName.setRequired(true);
            fieldsOk = false;
        } else {
            fName.setRequired(false);
        }
        if (lName.getValue() == lName.getNullRepresentation()
                || ((String) lName.getValue()).equals("")) {
            lName.setRequired(true);
            fieldsOk = false;
        } else {
            lName.setRequired(false);
        }

        if (street.getValue() == street.getNullRepresentation()
                || ((String) street.getValue()).equalsIgnoreCase("")) {
            street.setRequired(true);
            fieldsOk = false;
        } else {
            street.setRequired(false);
        }

        if (zip.getValue() == zip.getNullRepresentation()
                || ((String) zip.getValue()).equals("")) {
            zip.setRequired(true);
            fieldsOk = false;
        } else {
            zip.setRequired(false);
        }
        if (city.getValue() == city.getNullRepresentation()
                || ((String) city.getValue()).equals("")) {
            city.setRequired(true);
            fieldsOk = false;
        } else {
            city.setRequired(false);
        }

        if (fieldsOk) {
            checkCreditCardValidity();
        }

        return fieldsOk;
    }

    /**
     * Stub method to be used to check the credit card validity, will accept all
     * cards for now.
     * 
     * @return
     */
    private boolean checkCreditCardValidity() {
        return true;
    }

    /**
     * Fills in the credit card information from input to the provided credit
     * card. If card == null, a new credit card is created.
     * 
     * @param card
     *            - the card to which data should be filled
     * @return the filled in credit card.
     */
    public CreditCard getCreditInformation() {

        char[] cardNr = (((String) nr1.getValue()) + ((String) nr2.getValue())
                + ((String) nr3.getValue()) + ((String) nr4.getValue()))
                .toCharArray();

        String expYearStr = (String) year.getValue();
        if (expYearStr.length() == 4) {
            expYearStr = expYearStr.substring(2);
        }
        short expYear = new Short(expYearStr);

        CreditCardType cctype = (CreditCardType) card.getValue();
        String cardHolderName = (String) fName.getValue() + " "
                + (String) lName.getValue();
        short expMonth = new Short((String) month.getValue());
        char[] csvNr = ((String) csv.getValue()).toCharArray();

        CreditCard ccard = new CreditCard(cctype, cardHolderName, cardNr,
                expMonth, expYear, csvNr);

        return ccard;
    }

    public String getFirstNameAsString() {
        return (String) fName.getValue();
    }

    public String getLastNameAsString() {
        return (String) lName.getValue();
    }
    
    public String getStreetAsString() {
        return (String) street.getValue();
    }

    public String getZipAsString() {
        return (String) zip.getValue();
    }

    public String getCityAsString() {
        return (String) city.getValue();
    }
    
    public String getStateAsString() {
        return (String) state.getValue();
    }

    /*
     * Getters and setters
     */

    public ComboBox getCard() {
        return card;
    }

    public void setCard(ComboBox card) {
        this.card = card;
    }

    public TextField getNr1() {
        return nr1;
    }

    public void setNr1(TextField nr1) {
        this.nr1 = nr1;
    }

    public TextField getNr2() {
        return nr2;
    }

    public void setNr2(TextField nr2) {
        this.nr2 = nr2;
    }

    public TextField getNr3() {
        return nr3;
    }

    public void setNr3(TextField nr3) {
        this.nr3 = nr3;
    }

    public TextField getNr4() {
        return nr4;
    }

    public void setNr4(TextField nr4) {
        this.nr4 = nr4;
    }

    public TextField getYear() {
        return year;
    }

    public void setYear(TextField year) {
        this.year = year;
    }

    public TextField getMonth() {
        return month;
    }

    public void setMonth(TextField month) {
        this.month = month;
    }

    public TextField getCsv() {
        return csv;
    }

    public void setCsv(TextField csv) {
        this.csv = csv;
    }

    
    public TextField getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName.setValue(fName);
    }

    public TextField getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName.setValue(lName);
    }
    
    public TextField getStreet() {
        return street;
    }

    public void setStreet(TextField street) {
        this.street = street;
    }

    public TextField getZip() {
        return zip;
    }

    public void setZip(TextField zip) {
        this.zip = zip;
    }

    public TextField getCity() {
        return city;
    }

    public void setCity(TextField city) {
        this.city = city;
    }

    public ComboBox getUSState() {
        return state;
    }

    public void setUSState(ComboBox state) {
        this.state = state;
    }

    public void cleanUp() {
        card.setContainerDataSource(null);
        state.setContainerDataSource(null);
    }

}
