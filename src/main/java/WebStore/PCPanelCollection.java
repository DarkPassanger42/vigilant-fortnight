package WebStore;

import com.vaadin.event.MouseEvents;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;

import java.util.ArrayList;

/**
 * Created by andri on 11/9/2016.
 */
public class PCPanelCollection extends CustomComponent implements MouseEvents.ClickListener {

    WebStoreUI parentUI;

    ArrayList<Product> allComputerProducts;

   public PCPanelCollection(WebStoreUI ui){

       parentUI = ui;

       allComputerProducts = parentUI.mySQLAccess.getProducts();

       Panel computersPanel = new Panel();
       HorizontalLayout computersLayout = new HorizontalLayout();
       computersLayout.setWidthUndefined();
       computersLayout.setSpacing(true);
       computersLayout.setMargin(true);

       ArrayList<Product> computers = parentUI.mySQLAccess.getCompPCProducts();

       for (Product computer : computers){
           Panel panel = new Panel(computer.getName());
           panel.setWidth("250px");
           panel.setHeight("250px");
           panel.setId(computer.getID());
           panel.addClickListener(this);

           FormLayout form = new FormLayout();
           final ExternalResource er = new ExternalResource(computer.getImage());
           Image image = new Image(null, er);
           image.setHeight("100px");
           image.setWidth("100px");
           form.addComponent(image);
           form.setMargin(true);
           panel.setContent(form);
           computersLayout.addComponent(panel);

           //debug
           System.out.println("adding computers... id:"+ computer.getID() + " name: " + computer.getName());
       }

       computersPanel.setContent(computersLayout);
       computersPanel.setWidth("100%");
       computersPanel.setHeight("300px");


       setCompositionRoot(computersPanel);
   }

    @Override
    public void click(MouseEvents.ClickEvent clickEvent) {

        System.out.println("test event...");

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
