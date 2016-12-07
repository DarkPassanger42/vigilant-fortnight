package jhu.edu.WebStore.Data;

import jhu.edu.WebStore.Data.LogInCredentials;
import jhu.edu.WebStore.Data.Product;

import java.util.ArrayList;


public class SiteUser {

    private int ID;
    private String username;
    private String fname;
    private String lname;
    private ShoppingCart PurchasedItems;
    private jhu.edu.WebStore.Data.LogInCredentials LogInCredentials;

    public SiteUser(int id, String name, String fname, String lname, ShoppingCart purchasedItems,
                    LogInCredentials logInCredentials){
        this.ID = id;
        this.username = name;
        this.fname = fname;
        this.lname = lname;

        this.PurchasedItems = purchasedItems;
        this.LogInCredentials = logInCredentials;
    }

    public LogInCredentials getLogInCredentials() {
        return LogInCredentials;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String name) {
        this.username = name;
    }
    
    public String getFirstName() {
        return fname;
    }
    
    public void setFirstName(String fname) {
        this.fname = fname;
    }
    
    public String getLastName() {
        return lname;
    }
    
    public void setLastName(String lname) {
        this.lname = lname;
    }

    public ShoppingCart getPurchasedItems() {
        return PurchasedItems;
    }

    public void setPurchasedItems(ShoppingCart purchasedItems) {
        PurchasedItems = purchasedItems;
    }



}
