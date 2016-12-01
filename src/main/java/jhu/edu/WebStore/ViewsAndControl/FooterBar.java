package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import jhu.edu.WebStore.WebStoreUI;


public class FooterBar extends VerticalLayout {

    private WebStoreUI parentUI;

    public FooterBar(WebStoreUI parentUI){
        this.parentUI = parentUI;

        GridLayout footerContainer = new GridLayout(5,1);
        footerContainer.setWidth("100%");
        footerContainer.setMargin(true);

        Label footerLabel = new Label("Copyright JAS 2016");
        footerContainer.addComponent(footerLabel,2,0);
        
        Link link = new Link("Contact Us", new ExternalResource("http://vaadin.com/"));
        footerContainer.addComponent(link, 3, 0);


        addComponent(footerContainer);
    }
}
