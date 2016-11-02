package WebStore;


import com.vaadin.ui.*;


public class ProductDetailsWindow extends Window {


    public ProductDetailsWindow(Product product){
        super(product.getDescription());
        center();

        // Some basic content for the window
        HorizontalLayout buttonLayout = new HorizontalLayout();
        VerticalLayout content = new VerticalLayout();
        content.addComponent(new Label(product.getDescription()));
        content.addComponent(new Label(product.getName()));
        content.setMargin(true);

        // Disable the close button
        setClosable(false);

        Button ok = new Button("CANCEL");
        ok.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                close(); // Close the sub-window
            }
        });
        buttonLayout.addComponent(ok);

        Button addToCart = new Button("ADD TO CART");
        ok.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                close(); // Close the sub-window
            }
        });
        buttonLayout.addComponent(addToCart);

        content.addComponent(buttonLayout);

        setContent(content);
    }
}
