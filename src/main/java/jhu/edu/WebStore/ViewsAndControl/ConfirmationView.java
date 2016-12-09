package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import javax.swing.GroupLayout;
import jhu.edu.WebStore.Data.Product;
import jhu.edu.WebStore.Data.ShoppingCart;
import jhu.edu.WebStore.Data.SiteUser;
import jhu.edu.WebStore.Helpers.CreditCard;
import jhu.edu.WebStore.WebStoreUI;
import jhu.edu.WebStore.WindowsAndControl.RegistrationWindow;


public class ConfirmationView extends BaseView {

    WebStoreUI parentUI;
    
    private CreditCardForm creditCardForm;
    private CreditCard creditCard;
    private Button cancelButton;
    private Button submitButton;
    private VerticalLayout checkOutLayout = null;

    public ConfirmationView(WebStoreUI ui){
        super(ui);
        parentUI = ui;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        super.enter(event);
        if(checkOutLayout != null) {
            removeComponent(checkOutLayout);
        }
        
        RefreshLogInOutComponent();
        initializeLayouts();
        creditCardForm.getCard().focus();
    }

    /**
     * Initializes the layout that are used in this view.
     */
    private void initializeLayouts() {
        
        checkOutLayout = new VerticalLayout();
        checkOutLayout.setWidth("100%");
        checkOutLayout.setSpacing(true);
        checkOutLayout.setMargin(true);

        //get all products in the cart from the session
        SiteUser currentUser = (SiteUser)parentUI.getSession().getAttribute("SiteUser");
        ShoppingCart cart = currentUser.getShoppingCart();

        //get cart items as an indexed container and bind to UI
        IndexedContainer cartItemsContainer = cart.getCartContainer();
        
        HorizontalLayout tableLayout = new HorizontalLayout();
        //tableLayout.setWidth("75%");

        Table table = new Table("Products");
        table.setSelectable(false);
        table.setContainerDataSource(cartItemsContainer);
        //table.setWidth("100%");
        table.setPageLength(cartItemsContainer.size());
        
        tableLayout.addComponent(table);
        //tableLayout.setComponentAlignment(table, Alignment.TOP_CENTER);

        checkOutLayout.addComponent(tableLayout);
        checkOutLayout.setComponentAlignment(tableLayout, Alignment.TOP_CENTER);
        
        creditCardForm = new CreditCardForm();
        creditCardForm.setAvailableCreditCards();
        
        // Auto Fill in first and last name
        // EXample:
        // City City = reservation.getShow().getTheater().getCity();
        /*
        creditCardForm.setCityOrPostalOffice(city.getName());
        creditCardForm.setAvailableCountries(backEnd.getCountryContainer());
        creditCardForm.setSelectedCountry(city.getCountry());
        */
        
        checkOutLayout.addComponent(creditCardForm);
        checkOutLayout.setComponentAlignment(creditCardForm, Alignment.MIDDLE_CENTER);
        
        cancelButton = new Button("CANCEL",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                    }
                });
        
        submitButton = new Button("SUBMIT",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                    }
                });
        
        HorizontalLayout buttons = new HorizontalLayout(cancelButton, submitButton);
        buttons.setSpacing(true);
        
        checkOutLayout.addComponent(buttons);
        checkOutLayout.setComponentAlignment(buttons, Alignment.BOTTOM_CENTER);
        addComponent(checkOutLayout);
    }
}
