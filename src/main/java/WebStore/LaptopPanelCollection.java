package WebStore;

import com.vaadin.event.MouseEvents;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;

import java.util.ArrayList;

/**
 * Created by andri on 11/9/2016.
 */
public class LaptopPanelCollection extends CustomComponent implements MouseEvents.ClickListener {

    WebStoreUI parentUI;

    ArrayList<Product> allComputerProducts;

    public LaptopPanelCollection(WebStoreUI ui){

        parentUI = ui;

        allComputerProducts = parentUI.mySQLAccess.getProducts();

        Panel computersPanel = new Panel();
        HorizontalLayout laptopsLayout = new HorizontalLayout();
        laptopsLayout.setWidthUndefined();
        laptopsLayout.setSpacing(true);
        laptopsLayout.setMargin(true);

        ArrayList<Product> laptops = parentUI.mySQLAccess.getCompLaptopProducts();

        for (Product laptop : laptops){
            Panel panel = new Panel(laptop.getName());
            panel.setWidth("250px");
            panel.setHeight("250px");
            panel.setId(laptop.getID());
            panel.addClickListener(this);

            FormLayout form = new FormLayout();
            final ExternalResource er = new ExternalResource(laptop.getImage());
            Image image = new Image(null, er);
            image.setHeight("100px");
            image.setWidth("100px");
            form.addComponent(image);
            form.setMargin(true);
            panel.setContent(form);
            laptopsLayout.addComponent(panel);

            //debug
            System.out.println("adding computers... id:"+ laptop.getID() + " name: " + laptop.getName());
        }

        computersPanel.setContent(laptopsLayout);
        computersPanel.setWidth("100%");
        computersPanel.setHeight("300px");


        setCompositionRoot(computersPanel);
    }

    @Override
    public void click(MouseEvents.ClickEvent clickEvent) {

        String clickedId = clickEvent.getComponent().getId();

        //now find the corresponding product from the list
        Product selectedProduct = new Product();
        for (Product product : allComputerProducts){
            if (product.getID().equals(clickedId)){
                selectedProduct = product;
                break;
            }
        }

        ProductDetailsWindow detailsWindow = new ProductDetailsWindow(selectedProduct);
        UI.getCurrent().addWindow(detailsWindow);

    }
}

