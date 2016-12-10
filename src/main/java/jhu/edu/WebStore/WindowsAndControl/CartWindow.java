package jhu.edu.WebStore.WindowsAndControl;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.*;
import jhu.edu.WebStore.Data.Product;
import jhu.edu.WebStore.Data.ShoppingCart;
import jhu.edu.WebStore.Data.SiteUser;
import jhu.edu.WebStore.WebStoreUI;


/**
 * Created by andri on 11/5/2016.
 */
public class CartWindow extends Window {

    WebStoreUI parentUI;
    String selectedProduct;
    SiteUser currentUser;
    ShoppingCart cart;
    Table table;

    IndexedContainer cartItemsContainer;

    public CartWindow(WebStoreUI ui){
        parentUI = ui;

        selectedProduct = "";
        cart = null;
        table = null;

        this.setModal(true);

        this.addFocusListener(new FieldEvents.FocusListener() {
            @Override
            public void focus(FieldEvents.FocusEvent focusEvent) {
                System.out.println("Focus...");

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
        //Button returnButton = new Button("Continue Shopping");
        Button removeItems = new Button("Remove Selected");
        Button chnageQuantity = new Button("Change Selected Quantity");
        //buttonLayout.setWidth("100%");
        buttonLayout.setSpacing(true);
        buttonLayout.setMargin(false);
        buttonLayout.setWidthUndefined();

        continueButton.setWidth("160px");
        removeItems.setWidth("160px");
        chnageQuantity.setWidth("220px");

        buttonLayout.addComponent(continueButton);
        buttonLayout.addComponent(chnageQuantity);
        buttonLayout.addComponent(removeItems);


        continueButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                parentUI.nav.navigateTo(parentUI.VIEW_CONFIRMATION);
                close();
            }
        });

//        buttonLayout.addComponent(returnButton);    //continue shopping
//        returnButton.addClickListener(new Button.ClickListener() {
//            @Override
//            public void buttonClick(Button.ClickEvent clickEvent) {
//
//                //update session variable for cart, just in case...
//                currentUser.setShoppingCart(cart);
//                parentUI.getSession().setAttribute("SiteUser", currentUser);
//
//                //and exit...
//                close();
//            }
//        });

        chnageQuantity.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                if (!selectedProduct.equals("")){
                    Product myProduct = cart.getProduct(selectedProduct);
                    QuantityWindow quantityWindow = new QuantityWindow(myProduct);
                    quantityWindow.setWidth("150px");
                    quantityWindow.setHeight("150px");
                    quantityWindow.center();
                    quantityWindow.setModal(true);
                    UI.getCurrent().addWindow(quantityWindow);

                    quantityWindow.addCloseListener(new CloseListener() {
                        @Override
                        public void windowClose(CloseEvent closeEvent) {
                            System.out.println("Quantity closed...");

                            //update session variable for cart
                            currentUser.setShoppingCart(cart);
                            parentUI.getSession().setAttribute("SiteUser", currentUser);

                            //remove all items
                            cartItemsContainer.removeAllItems();

                            //re-add... no other way to refresh??!?
                            for (Product product : cart.getItems()) {
                                Item item = cartItemsContainer.addItem(product.getID());  //use product ID as an id in the container
                                item.getItemProperty("Product").setValue(product.getName());
                                item.getItemProperty("Price").setValue("$"+product.getPrice());
                                item.getItemProperty("Quantity").setValue(String.valueOf(product.getQuantity()));
                            }

                            table.refreshRowCache();
                        }
                    });
                }
            }
        });

        this.addListener(new Window.CloseListener(){
            @Override
            public void windowClose(CloseEvent closeEvent) {
                System.out.println("Cart Window closed");

                //update session variable for cart, just in case...
                currentUser.setShoppingCart(cart);
                parentUI.getSession().setAttribute("SiteUser", currentUser);
            }
        });


        removeItems.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                removeProduct();
            }
        });


        //create table to display products in cart
        table = new Table("Products");
        table.setSelectable(true);
        table.addValueChangeListener(new Property.ValueChangeListener(){
            public void valueChange(Property.ValueChangeEvent event) {
                selectedProduct = event.getProperty().getValue().toString();  //get product ID

                System.out.println("Product ID to remove: " + selectedProduct);    //debug...
            }
        });


        //get all products in the cart
        currentUser = (SiteUser)parentUI.getSession().getAttribute("SiteUser");
        cart = currentUser.getShoppingCart();

        //get cart items as an indexed container and bind to UI
        cartItemsContainer = cart.getCartContainer();
        table.setContainerDataSource(cartItemsContainer);



        table.setWidth("100%");
        table.setHeight("550px");
        tableLayout.addComponent(table);
        cartWindowLayout.addComponent(tableLayout);

        cartWindowLayout.addComponent(buttonLayout);
        cartWindowLayout.setComponentAlignment(buttonLayout, Alignment.MIDDLE_CENTER);

        table.setImmediate(true);
        table.setEnabled(true);
        setContent(cartWindowLayout);
    }


    //from cart and update UI table
    private void removeProduct() {
        if(cart != null){

            //cannot find a better way to do this...

            cart.removeProduct(selectedProduct);    //-actual ID of the product, removes it from the list, not container

            //update session variable for cart
            currentUser.setShoppingCart(cart);
            parentUI.getSession().setAttribute("SiteUser", currentUser);

            cartItemsContainer.removeItem(selectedProduct); //-actual ID of the product, removes it from the container

            table.refreshRowCache();
        }


    }
}
