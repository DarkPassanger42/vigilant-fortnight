package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.event.MouseEvents;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import jhu.edu.WebStore.Data.Product;
import jhu.edu.WebStore.WindowsAndControl.ProductDetailsWindow;

import java.util.ArrayList;
import java.util.Random;


public class HomeViewPanelCollection extends CustomComponent implements MouseEvents.ClickListener {

    ArrayList<Product> productList = new ArrayList<>();

    public HomeViewPanelCollection(ArrayList<Product> productList){

        this.productList = productList;

        GridLayout homeViewProducts = new GridLayout(6,6);
        homeViewProducts.setMargin(true);
        homeViewProducts.setSpacing(true);
        homeViewProducts.setSizeFull();

        //generate a random list of 8 products...
        //should be "special deals"
        int min = 1;
        int max = 93;       //all components
        for (int i = 1; i < 9; i++){

            //get a random product
            Random rand = new Random();
            int randomProd = rand.nextInt((max - min) + 1) + min;
            Product product = productList.get(randomProd);


            Panel panel = new Panel(trimTitle(product.getName()));
            panel.addClickListener(this);
            panel.setId(product.getID());
            panel.setWidth("300px");
            panel.setHeight("300px");


            final ExternalResource er = new ExternalResource(product.getImage());
            Image image = new Image(null, er);
            image.setHeight("170px");
            image.setWidth("170px");


            FormLayout form = new FormLayout();
            form.setMargin(true);
            form.addComponent(image);

            panel.setContent(form);


            if (i < 5){
                homeViewProducts.addComponent(panel,i,0);
            }
            else{
                homeViewProducts.addComponent(panel,i-4,1);
            }

            setCompositionRoot(homeViewProducts);
        }

    }


    @Override
    public void click(MouseEvents.ClickEvent clickEvent) {

        String clickedId = clickEvent.getComponent().getId();

        //now find the corresponding product from the list
        Product selectedProduct = new Product();
        for (Product product : productList){
            if (product.getID().equals(clickedId)){
                selectedProduct = product;
                break;
            }
        }

        ProductDetailsWindow detailsWindow = new ProductDetailsWindow(selectedProduct);
        UI.getCurrent().addWindow(detailsWindow);
    }

    private String trimTitle(String title){

        String tmpStr = "";

        if (title.length() < 30){
            tmpStr = title;
        }
        else{
            tmpStr = title.substring(0,30) + "...";
        }

        return tmpStr;
    }
}
