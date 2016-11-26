package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.navigator.ViewChangeListener;
import jhu.edu.WebStore.WebStoreUI;


public class SearchResultsWindow extends BaseView {

    WebStoreUI parentUI;

    public SearchResultsWindow(WebStoreUI ui){
        super(ui);
        parentUI = ui;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        super.enter(event);
        RefreshLogInOutComponent();
    }

}
