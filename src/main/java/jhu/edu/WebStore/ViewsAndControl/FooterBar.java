package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.ui.*;
import jhu.edu.WebStore.WebStoreUI;


public class FooterBar extends VerticalLayout {

    private WebStoreUI parentUI;

    public FooterBar(WebStoreUI parentUI){
        this.parentUI = parentUI;

        GridLayout footerContainer = new GridLayout(5,1);
        footerContainer.setWidth("100%");
        footerContainer.setMargin(true);

        Label footerLabel = new Label("Copy right JAS 2016");
        footerContainer.addComponent(footerLabel,2,0);


        addComponent(footerContainer);
    }
}
