package jhu.edu.WebStore.Data;

import sun.security.krb5.internal.crypto.Des;

public class Product {

    private String ID;
    private String Category;
    private String Subcategory;
    private String Name;
    private String Description;
    private String Price;
    private String Image;

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Product(String ID, String Category, String Subcategory,
                   String Name, String Description, String Price, String Image){
        this.ID = ID;
        this.Category = Category;
        this.Subcategory = Subcategory;
        this.Name = Name;
        this.Description = Description;
        this.Price = Price;
        this.Image = Image;

    }

    public Product(){

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getSubcategory() {
        return Subcategory;
    }

    public void setSubcategory(String subcategory) {
        Subcategory = subcategory;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }
    
    public double getActualPrice() {
        double price = 0.0;
        
        price = Double.parseDouble(Price);
        
        return price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
