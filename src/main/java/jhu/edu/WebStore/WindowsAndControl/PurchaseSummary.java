package jhu.edu.WebStore.WindowsAndControl;

import com.vaadin.server.ExternalResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import jhu.edu.WebStore.Data.LogInCredentials;
import jhu.edu.WebStore.Data.Product;
import jhu.edu.WebStore.Data.ShoppingCart;
import jhu.edu.WebStore.Data.SiteUser;
import jhu.edu.WebStore.WebStoreUI;


public class PurchaseSummary extends Window {

    WebStoreUI parentUI;

    public PurchaseSummary(WebStoreUI ui, String address){
        super("Purchase Summary");
        parentUI = ui;
        center();
        this.setModal(true);

        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setWidth("100%");
        
        SiteUser currentUser = (SiteUser)parentUI.getSession().getAttribute("SiteUser");
        String name = currentUser.getFirstName() + " " + currentUser.getLastName();

        VerticalLayout content = new VerticalLayout();
        content.setMargin(true);
        content.setWidthUndefined();

        // Disable the close button
        setClosable(false);
        
        // Some basic content for the window
        Label thankyou = new Label(formatMessage(name, address), ContentMode.HTML);
        content.addComponent(thankyou);

        Button ok = new Button("OK");
        ok.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                close(); // Close the sub-window
            }
        });

        content.addComponent(ok);
        mainLayout.addComponent(content);
        mainLayout.setComponentAlignment(content,Alignment.MIDDLE_CENTER);


        setContent(mainLayout);
    }

    protected String formatMessage(String name, String address) {
        String fullDescription = "<ul>";
        String thankyou = "<h1>Thank You "+name+"!</h1>";
        String shipping = "Your order will be shipped to:<br>" +
                "<bold>"+address+"</bold><br>";
        
        return thankyou + shipping;
    }
}
