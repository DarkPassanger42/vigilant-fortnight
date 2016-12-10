package jhu.edu.WebStore.WindowsAndControl;


import com.vaadin.server.AbstractErrorMessage;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import jhu.edu.WebStore.Data.LogInCredentials;
import jhu.edu.WebStore.Data.Product;
import jhu.edu.WebStore.Data.ShoppingCart;
import jhu.edu.WebStore.Data.SiteUser;


public class ProductDetailsWindow extends Window {


    public ProductDetailsWindow(Product product){
        super(product.getName());
        center();
        this.setModal(true);


        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setWidth("100%");

        // Some basic content for the window
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setWidthUndefined();

        VerticalLayout content = new VerticalLayout();
        content.setWidthUndefined();
        content.addComponent(new Label("$" + product.getPrice()));
        content.addComponent(new Label(
                formatDescription(product.getDescription()), ContentMode.HTML));

        final ExternalResource er = new ExternalResource(product.getImage());
        Image image = new Image(null, er);
        image.setHeight("350px");
        image.setWidth("350px");

        content.addComponent(image);

        content.setMargin(true);
        content.setWidthUndefined();

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
                    SiteUser currentUser = (SiteUser)getSession().getAttribute("SiteUser");
                    ShoppingCart currentShoppingCart = currentUser.getShoppingCart();
                    product.setQuantity(1);
                    currentShoppingCart.addProduct(product);
                    
                    // Save shopping cart for current user
                    currentUser.setShoppingCart(currentShoppingCart);
                    getSession().setAttribute("SiteUser", currentUser);
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


        //content.addComponent(buttonLayout);
        mainLayout.addComponent(content);
        mainLayout.setComponentAlignment(content, Alignment.MIDDLE_CENTER);

        Label spaceLabel = new Label();
        spaceLabel.setWidth("100%");
        spaceLabel.setHeight("10px");
        mainLayout.addComponent(spaceLabel);

        mainLayout.addComponent(buttonLayout);
        mainLayout.setComponentAlignment(buttonLayout, Alignment.MIDDLE_CENTER);

        Label spaceLabel2 = new Label();
        spaceLabel2.setWidth("100%");
        spaceLabel2.setHeight("10px");
        mainLayout.addComponent(spaceLabel2);

        setContent(mainLayout);
    }

    protected String formatDescription(String description) {
        String[] descParts = description.split(",");
        String fullDescription = "<ul>";
        for(String part : descParts) { 
            fullDescription += "<li>"+ part + "</li>";
        }
        
        return fullDescription + "</ul>";
    }
}
