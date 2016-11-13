package jhu.edu.WebStore.Data;

import jhu.edu.WebStore.Data.LogInCredentials;
import jhu.edu.WebStore.Data.Product;

import java.util.ArrayList;


public class SiteUser {

    private String ID;
    private String Name;
    private String Address;
    private String CreditCard;
    private ShoppingCart PurchasedItems;
    private jhu.edu.WebStore.Data.LogInCredentials LogInCredentials;

    public SiteUser(String id, String name, String address, String creditCardInfo, ShoppingCart purchasedItems,
                    LogInCredentials logInCredentials){
        this.ID = id;
        this.Name = name;
        this.Address = address;
        this.CreditCard = creditCardInfo;

        this.PurchasedItems = purchasedItems;
        this.LogInCredentials = logInCredentials;
    }

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

    public ShoppingCart getPurchasedItems() {
        return PurchasedItems;
    }

    public void setPurchasedItems(ShoppingCart purchasedItems) {
        PurchasedItems = purchasedItems;
    }



}
