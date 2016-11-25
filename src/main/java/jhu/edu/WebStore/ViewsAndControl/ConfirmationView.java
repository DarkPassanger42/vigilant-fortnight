package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import jhu.edu.WebStore.Data.Product;
import jhu.edu.WebStore.Data.ShoppingCart;
import jhu.edu.WebStore.WebStoreUI;


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

        //this needs to still be done...
        //not sure what approach to take


        //get all products in the cart from the session
        ShoppingCart cart = (ShoppingCart) parentUI.getSession().getAttribute("ShoppingCart");

        HorizontalLayout checkOutLayout = new HorizontalLayout();

        StringBuilder sb = new StringBuilder();

        for (Product product : cart.getItems()) {
            sb.append(product.getName());
            sb.append(product.getDescription());
            sb.append("\n");
        }

        Label label = new Label(sb.toString());

        checkOutLayout.addComponent(label);

        addComponent(checkOutLayout);
    }

}
