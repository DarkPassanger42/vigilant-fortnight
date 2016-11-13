package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.navigator.ViewChangeListener;
import jhu.edu.WebStore.WebStoreUI;


public class ComputersView extends BaseView {

    WebStoreUI parentUI;


    public ComputersView(WebStoreUI ui){
        super(ui);
        parentUI = ui;


        PCPanelCollection pCPanelCollection = new PCPanelCollection(parentUI);
        addComponent(pCPanelCollection);

        LaptopPanelCollection laptopPanelCollection = new LaptopPanelCollection(parentUI);
        addComponent(laptopPanelCollection);

        TabletPanelCollection tabletPanelCollection = new TabletPanelCollection(parentUI);
        addComponent(tabletPanelCollection);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        super.enter(event);
        RefreshLogInOutComponent();

    }

}
