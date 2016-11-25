package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.navigator.ViewChangeListener;
import jhu.edu.WebStore.WebStoreUI;

/**
 * Created by andri on 11/25/2016.
 */
public class ConfirmationView extends BaseView {

    WebStoreUI parentUI;

    public ConfirmationView(WebStoreUI ui){
        super(ui);
        parentUI = ui;

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        super.enter(event);
        RefreshLogInOutComponent();



    }

}
