package jhu.edu.WebStore.WindowsAndControl;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.*;
import jhu.edu.WebStore.Data.Product;
import jhu.edu.WebStore.Data.ShoppingCart;
import jhu.edu.WebStore.WebStoreUI;


/**
 * Created by andri on 11/5/2016.
 */
public class CartWindow extends Window {

    WebStoreUI parentUI;
    String productToRemove;
    ShoppingCart cart;
    Table table;

    IndexedContainer cartItemsContainer;

    public CartWindow(WebStoreUI ui){
        parentUI = ui;

        productToRemove = "";
        cart = null;
        table = null;


        this.addFocusListener(new FieldEvents.FocusListener() {
            @Override
            public void focus(FieldEvents.FocusEvent focusEvent) {
                buildCartWindow();
            }
        });
    }

    private void buildCartWindow() {
        VerticalLayout cartWindowLayout = new VerticalLayout();
        cartWindowLayout.setWidth("100%");
        cartWindowLayout.setSpacing(true);
        cartWindowLayout.setMargin(true);

        HorizontalLayout tableLayout = new HorizontalLayout();
        tableLayout.setWidth("100%");

        HorizontalLayout buttonLayout = new HorizontalLayout();
        Button continueButton = new Button("Confirm Checkout");
        Button returnButton = new Button("Continue Shopping");
        Button removeItems = new Button("Remove Selected Items");
        buttonLayout.setWidth("100%");

        buttonLayout.addComponent(continueButton);

        buttonLayout.addComponent(returnButton);

        buttonLayout.addComponent(removeItems);
        removeItems.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                removeProduct();
                //updateTable();
            }
        });


        //create table to display products in cart
        table = new Table("Products");
        table.setSelectable(true);
        table.addValueChangeListener(new Property.ValueChangeListener(){
            public void valueChange(Property.ValueChangeEvent event) {
                productToRemove = event.getProperty().getValue().toString();  //get product ID

                System.out.println("Product ID to remove: " + productToRemove);    //debug...
            }
        });


        //get all products in the cart
        cart = (ShoppingCart) parentUI.getSession().getAttribute("ShoppingCart");

        //get cart items as an indexed container and bind to UI
        cartItemsContainer = cart.getCartContainer();
        table.setContainerDataSource(cartItemsContainer);


        table.setWidth("100%");
        table.setHeight("550px");
        tableLayout.addComponent(table);
        cartWindowLayout.addComponent(tableLayout);
        //cartWindowLayout.setComponentAlignment(table, Alignment.MIDDLE_CENTER);

        //cartWindowLayout.addComponent(table,1,1,4,4);
        cartWindowLayout.addComponent(buttonLayout);
        //cartWindowLayout.setComponentAlignment(buttonLayout, Alignment.MIDDLE_CENTER);

        table.setImmediate(true);
        setContent(cartWindowLayout);
    }


    //from cart and update UI table
    private void removeProduct() {
        if(cart != null){
            cart.removeProduct(productToRemove);    //-actual ID of the product, removes it from the list, not container

            cartItemsContainer = cart.getCartContainer();
            table.refreshRowCache();
        }


    }
}
