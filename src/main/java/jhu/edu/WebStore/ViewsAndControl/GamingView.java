package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.navigator.ViewChangeListener;
import jhu.edu.WebStore.WebStoreUI;


public class GamingView extends BaseView {

    WebStoreUI parentUI;


    public GamingView(WebStoreUI ui){
        super(ui);
        parentUI = ui;


        GMConsolePanelCollection gmConsolePanelCollection = new GMConsolePanelCollection(parentUI);
        addComponent(gmConsolePanelCollection);

        GMPCPanelCollection gmPCPanelCollection = new GMPCPanelCollection(parentUI);
        addComponent(gmPCPanelCollection);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        super.enter(event);
        RefreshLogInOutComponent();

    }

}
