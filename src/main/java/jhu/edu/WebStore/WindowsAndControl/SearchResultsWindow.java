package jhu.edu.WebStore.WindowsAndControl;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.MouseEvents;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import jhu.edu.WebStore.Data.Product;
import jhu.edu.WebStore.WebStoreUI;

import java.util.ArrayList;


public class SearchResultsWindow extends Window {

    private ArrayList<Product> searchResult;
    private WebStoreUI parentUI;


    public SearchResultsWindow(ArrayList<Product> searchResult, WebStoreUI parentUI){

        this.parentUI = parentUI;
        this.searchResult = searchResult;
        this.setModal(true);

        this.addFocusListener(new FieldEvents.FocusListener() {
            @Override
            public void focus(FieldEvents.FocusEvent focusEvent) {
                buildResultWindow();
            }

        });

    }

    private void buildResultWindow() {

        VerticalLayout searchResultLayout = new VerticalLayout();
        searchResultLayout.setWidth("100%");
        searchResultLayout.setMargin(true);
        searchResultLayout.setSpacing(true);

        //IndexedContainer indexedContainer = new IndexedContainer();
        //indexedContainer.addContainerProperty("Product",String.class,"");

        for (Product specificProduct : searchResult) {
            Panel panel = new Panel(specificProduct.getName());
            panel.setWidth("300px");
            panel.setHeight("250px");
            panel.setId(specificProduct.getID());
            panel.addClickListener(new MouseEvents.ClickListener() {
                @Override
                public void click(MouseEvents.ClickEvent clickEvent) {
                    DisplayDetails(specificProduct);
                }
            });

            HorizontalLayout form = new HorizontalLayout();
            form.setWidthUndefined();
            form.setHeightUndefined();
            final ExternalResource er = new ExternalResource(specificProduct.getImage());
            Image image = new Image(null, er);
            image.setHeight("150px");
            image.setWidth("200px");
            form.addComponent(image);
            form.setComponentAlignment(image, Alignment.MIDDLE_CENTER);
            form.setMargin(true);
            panel.setContent(form);

            searchResultLayout.addComponent(panel);
            searchResultLayout.setComponentAlignment(panel,Alignment.MIDDLE_CENTER);
        }

        setContent(searchResultLayout);

    }

    private void DisplayDetails(Product specificProduct) {

        ProductDetailsWindow productDetailsWindow = new ProductDetailsWindow(specificProduct);
        UI.getCurrent().addWindow(productDetailsWindow);

    }


}
