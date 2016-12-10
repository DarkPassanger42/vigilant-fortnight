package jhu.edu.WebStore.WindowsAndControl;

import com.vaadin.ui.*;
import jhu.edu.WebStore.Data.Product;
import jhu.edu.WebStore.Data.ShoppingCart;

/**
 * Created by andri on 12/10/2016.
 */
public class QuantityWindow extends Window {

    Product myProduct;

    public QuantityWindow(Product product){

        myProduct = product;

        VerticalLayout quantityLayout = new VerticalLayout();

        TextField quantityTextField = new TextField();
        quantityTextField.setCaption("Quantity");
        quantityTextField.setWidth("50px");

        Button submitButton = new Button("Update");

        quantityLayout.addComponent(quantityTextField);
        quantityLayout.addComponent(submitButton);

        quantityLayout.setMargin(true);
        quantityLayout.setSpacing(true);

        submitButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                if (quantityTextField.getValue() != null){
                    myProduct.setQuantity(Integer.valueOf(quantityTextField.getValue()));
                }
                close();
            }
        });

        setContent(quantityLayout);
    }
}
