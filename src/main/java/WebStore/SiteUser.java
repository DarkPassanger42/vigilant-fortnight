package WebStore;

import java.util.ArrayList;


public class SiteUser {

    private String ID;
    private String Name;
    private String Address;
    private String CreditCard;
    private ArrayList<Product> PurchasedItems;
    private LogInCredentials LogInCredentials;

    public LogInCredentials getLogInCredentials() {
        return LogInCredentials;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCreditCard() {
        return CreditCard;
    }

    public void setCreditCard(String creditCard) {
        CreditCard = creditCard;
    }

    public ArrayList<Product> getPurchasedItems() {
        return PurchasedItems;
    }

    public void setPurchasedItems(ArrayList<Product> purchasedItems) {
        PurchasedItems = purchasedItems;
    }



}
