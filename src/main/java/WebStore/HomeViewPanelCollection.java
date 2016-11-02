package WebStore;

import com.vaadin.event.MouseEvents;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.Random;


public class HomeViewPanelCollection extends CustomComponent implements MouseEvents.ClickListener {

    ArrayList<Product> productList = new ArrayList<>();

    public HomeViewPanelCollection(ArrayList<Product> productList){

        this.productList = productList;

        GridLayout homeViewProducts = new GridLayout(6,6);
        homeViewProducts.setMargin(true);
        homeViewProducts.setSizeFull();

        //generate a random list of 8 products...
        //should be "special deals"
        int min = 0;
        int max = 9;
        for (int i = 1; i < 9; i++){

            //get a random product
            Random rand = new Random();
            int randomProd = rand.nextInt((max - min) + 1) + min;
            Product product = productList.get(randomProd);


            Panel panel = new Panel(product.getDescription());
            panel.addClickListener(this);
            panel.setId(product.getID());

            FormLayout form = new FormLayout();
            form.setMargin(true);
            form.addComponent(new Label("This is the actual products: " + i));

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
}
