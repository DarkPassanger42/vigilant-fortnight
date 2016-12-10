package jhu.edu.WebStore.Data;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
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


    public void removeProduct(String productID){    //-actual ID  of the product

        int productPositionToRemove = 0;
        boolean productValid = false;
        for (Product product : products) {      //products - is a LIST of products
            if(product.getID().equals(productID)){
                productValid = true;
                break;
            }
            ++productPositionToRemove;      //position of the product in the LIST
        }

        if(productValid){
            products.remove(productPositionToRemove);   //remove at position
        }

    }
    
    public void removeAllProducts() {
        while(products.size() > 0) {
            products.remove(0);
        }
    }
    
    public String getTotal() {
        double result = 0.0;
        
        for(Product product : products) {
            result += product.getActualPrice();
        }
        
        return Double.toString(result);
    }

    public ArrayList<Product> getItems(){
        return products;
    }

    //have to rebuild this every time, may not be very good...
    public IndexedContainer getCartContainer(){
        IndexedContainer indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("Product",String.class,"");
        indexedContainer.addContainerProperty("Price",String.class,"");

        for (Product product : products) {
            Item item = indexedContainer.addItem(product.getID());  //use product ID as an id in the container
            item.getItemProperty("Product").setValue(product.getName());
            item.getItemProperty("Price").setValue("$"+product.getPrice());
        }

        return indexedContainer;

    }
    
}
