package jhu.edu.WebStore.Data;

import jhu.edu.WebStore.Data.Product;

import java.util.ArrayList;

/**
 * Created by andri on 11/5/2016.
 */
public class ShoppingCart {
    
    private ArrayList<Product> products;
    
    public ShoppingCart(){
        products = new ArrayList<>();
    }
    
    public void addProduct(Product product){
        products.add(product);
    }
    
    public void removeProduct(Product product){
        //// TODO: 11/5/2016
    }

    public ArrayList<Product> getItems(){
        return products;
    }
    
}
