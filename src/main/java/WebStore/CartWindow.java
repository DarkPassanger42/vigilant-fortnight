package WebStore;

import com.vaadin.data.Item;
import com.vaadin.event.FieldEvents;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;


/**
 * Created by andri on 11/5/2016.
 */
public class CartWindow extends Window {

    WebStoreUI parentUI;

    public CartWindow(WebStoreUI ui){
        parentUI = ui;

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
        buttonLayout.addComponent(continueButton);
        buttonLayout.addComponent(returnButton);
        buttonLayout.addComponent(removeItems);
        buttonLayout.setWidth("100%");


        //create table to display products in cart
        Table table = new Table("Products");

        //define columns
        table.addContainerProperty("Product", String.class, null);
        table.addContainerProperty("Price", String.class, null);
        table.addContainerProperty("Quantity", String.class, null);

        //get all products in the cart
        ShoppingCart cart = (ShoppingCart) parentUI.getSession().getAttribute("ShoppingCart");

        for(Product product : cart.getItems()){

            Object newItemId = table.addItem();
            Item row = table.getItem(newItemId);
            row.getItemProperty("Product").setValue(product.getName());
            row.getItemProperty("Price").setValue(product.getPrice());
            row.getItemProperty("Quantity").setValue("TBD");

        }

        table.setWidth("100%");
        table.setHeight("550px");
        tableLayout.addComponent(table);
        cartWindowLayout.addComponent(tableLayout);
        //cartWindowLayout.setComponentAlignment(table, Alignment.MIDDLE_CENTER);

        //cartWindowLayout.addComponent(table,1,1,4,4);
        cartWindowLayout.addComponent(buttonLayout);
        //cartWindowLayout.setComponentAlignment(buttonLayout, Alignment.MIDDLE_CENTER);


        setContent(cartWindowLayout);
    }
}
