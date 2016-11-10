package WebStore;

import com.vaadin.event.MouseEvents;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;

import java.util.ArrayList;

/**
 * Created by andri on 11/9/2016.
 */
public class TabletPanelColletion extends CustomComponent implements MouseEvents.ClickListener{

    WebStoreUI parentUI;

    ArrayList<Product> allComputerProducts;

    public TabletPanelColletion(WebStoreUI ui){

        parentUI = ui;

        allComputerProducts = parentUI.mySQLAccess.getProducts();

        Panel computersPanel = new Panel();
        HorizontalLayout tabletsLayout = new HorizontalLayout();
        tabletsLayout.setWidthUndefined();
        tabletsLayout.setSpacing(true);
        tabletsLayout.setMargin(true);

        ArrayList<Product> tablets = parentUI.mySQLAccess.getCompTabletProducts();

        for (Product tablet : tablets){
            Panel panel = new Panel(tablet.getName());
            panel.setWidth("250px");
            panel.setHeight("250px");
            panel.setId(tablet.getID());
            panel.addClickListener(this);

            FormLayout form = new FormLayout();
            final ExternalResource er = new ExternalResource(tablet.getImage());
            Image image = new Image(null, er);
            image.setHeight("100px");
            image.setWidth("100px");
            form.addComponent(image);
            form.setMargin(true);
            panel.setContent(form);
            tabletsLayout.addComponent(panel);

            //debug
            System.out.println("adding computers... id:"+ tablet.getID() + " name: " + tablet.getName());
        }

        computersPanel.setContent(tabletsLayout);
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
