package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.event.MouseEvents;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import jhu.edu.WebStore.Data.Product;
import jhu.edu.WebStore.WindowsAndControl.ProductDetailsWindow;
import jhu.edu.WebStore.WebStoreUI;

import java.util.ArrayList;

public abstract class BasePanelCollection extends CustomComponent implements MouseEvents.ClickListener {

    WebStoreUI parentUI;

    private ArrayList<Product> allComputerProducts;
    protected ArrayList<Product> specificProducts;

    public BasePanelCollection(WebStoreUI ui){
        parentUI = ui;
    }

    public void buildPanelCollection(){

        allComputerProducts = parentUI.mySQLAccess.getProducts();

        Panel computersPanel = new Panel();
        HorizontalLayout tabletsLayout = new HorizontalLayout();
        tabletsLayout.setWidthUndefined();
        tabletsLayout.setSpacing(true);
        tabletsLayout.setMargin(true);


        for (Product specificProduct : specificProducts){
            Panel panel = new Panel(trimTitle(specificProduct.getName()));
            panel.setWidth("250px");
            panel.setHeight("250px");
            panel.setId(specificProduct.getID());
            panel.addClickListener(this);

            FormLayout form = new FormLayout();
            final ExternalResource er = new ExternalResource(specificProduct.getImage());
            Image image = new Image(null, er);
            image.setHeight("100px");
            image.setWidth("100px");
            form.addComponent(image);
            form.setMargin(true);
            panel.setContent(form);
            tabletsLayout.addComponent(panel);

            //debug
            System.out.println("adding computers... id:"+ specificProduct.getID() + " name: " + specificProduct.getName());
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
        detailsWindow.setHeight("50%");
        detailsWindow.setWidth("50%");
        UI.getCurrent().addWindow(detailsWindow);
    }

    private String trimTitle(String title){

        String tmpStr = "";

        if (title.length() < 25){
            tmpStr = title;
        }
        else{
            tmpStr = title.substring(0,25) + "...";
        }

        return tmpStr;
    }
}
