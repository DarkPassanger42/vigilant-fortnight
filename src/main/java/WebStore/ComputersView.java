package WebStore;

import com.vaadin.event.MouseEvents;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.ArrayList;


public class ComputersView extends BaseView {

    WebStoreUI parentUI;


    public ComputersView(WebStoreUI ui){
        super(ui);
        parentUI = ui;


        PCPanelCollection pCPanelCollection = new PCPanelCollection(parentUI);
        addComponent(pCPanelCollection);

        LaptopPanelCollection laptopPanelCollection = new LaptopPanelCollection(parentUI);
        addComponent(laptopPanelCollection);

        TabletPanelColletion tabletPanelColletion = new TabletPanelColletion(parentUI);
        addComponent(tabletPanelColletion);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        super.enter(event);
        RefreshLogInOutComponent();

    }

}
