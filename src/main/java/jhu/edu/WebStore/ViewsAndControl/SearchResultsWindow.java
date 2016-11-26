package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.FieldEvents;
import com.vaadin.navigator.ViewChangeListener;
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


        IndexedContainer indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("Product",String.class,"");


        for (Product product:searchResult) {
            Item item = indexedContainer.addItem(product.getName());  //use product ID as an id in the container
            //item.getItemProperty("Product").setValue(product.getName());
        }

        ListSelect resultList = new ListSelect();
        resultList.setContainerDataSource(indexedContainer);
        resultList.setWidthUndefined();
        resultList.setHeight("550px");

        searchResultLayout.addComponent(resultList);


        setContent(searchResultLayout);

    }



}
