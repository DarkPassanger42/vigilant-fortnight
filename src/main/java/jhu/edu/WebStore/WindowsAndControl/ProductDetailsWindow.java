package jhu.edu.WebStore.WindowsAndControl;


import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import jhu.edu.WebStore.Data.LogInCredentials;
import jhu.edu.WebStore.Data.Product;
import jhu.edu.WebStore.Data.ShoppingCart;


public class ProductDetailsWindow extends Window {


    public ProductDetailsWindow(Product product){
        super(product.getDescription());
        center();

        // Some basic content for the window
        HorizontalLayout buttonLayout = new HorizontalLayout();

        VerticalLayout content = new VerticalLayout();
        content.addComponent(new Label(product.getDescription()));
        content.addComponent(new Label(product.getName()));

        final ExternalResource er = new ExternalResource(product.getImage());
        Image image = new Image(null, er);
        image.setHeight("500px");
        image.setWidth("500px");

        content.addComponent(image);

        content.setMargin(true);

        // Disable the close button
        setClosable(false);

        Button ok = new Button("CANCEL");
        ok.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                close(); // Close the sub-window
            }
        });
        buttonLayout.addComponent(ok);

        Button addToCart = new Button("ADD TO CART");
        addToCart.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {

                //first make sure user is logged in
                Object loginInfo = getSession().getAttribute("LogInInfo");
                LogInCredentials lc = (LogInCredentials)loginInfo;
                if(lc.areValid()){
                    //get current list of products in the cart
                    ShoppingCart currentShoppingCart = (ShoppingCart)getSession().getAttribute("ShoppingCart");
                    currentShoppingCart.addProduct(product);
                    getSession().setAttribute("ShoppingCart", currentShoppingCart);
                    close(); // Close the sub-window
                    Notification.show("Item has been added to cart",
                            "",
                            Notification.Type.HUMANIZED_MESSAGE);
                }
                else{
                    close(); // Close the sub-window
                    Notification.show("Must be logged in to add to cart",
                            "",
                            Notification.Type.WARNING_MESSAGE);
                }

            }
        });
        buttonLayout.addComponent(addToCart);

        content.addComponent(buttonLayout);

        setContent(content);
    }


}
