package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import jhu.edu.WebStore.WebStoreUI;


public class HomeView extends BaseView {

    WebStoreUI parentUI;

    public HomeView(WebStoreUI ui){
        super(ui);
        parentUI = ui;

        AbsoluteLayout introStuff = new AbsoluteLayout();

        //-----for spacing-------
        introStuff.setHeight("40");
        introStuff.setWidth("100%");
        //-----------------------

        //add some intro stuff here????

        //like "specials" or something of that nature

//        Label homeViewText2 = new Label("add some intro stuff here");
//        introStuff.addComponent(homeViewText2, "left: 30%; right: 20% top: 20%; bottom: 20%;");

        addComponent(introStuff);

        HomeViewPanelCollection homeViewProducts = new HomeViewPanelCollection(parentUI.mySQLAccess.getProducts());

        addComponent(homeViewProducts);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        super.enter(event);
        RefreshLogInOutComponent();
    }
}
