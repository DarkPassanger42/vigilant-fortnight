package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import javax.swing.GroupLayout;
import jhu.edu.WebStore.Data.Product;
import jhu.edu.WebStore.Data.ShoppingCart;
import jhu.edu.WebStore.Data.SiteUser;
import jhu.edu.WebStore.Helpers.CreditCard;
import jhu.edu.WebStore.WebStoreUI;
import jhu.edu.WebStore.WindowsAndControl.PurchaseSummary;
import jhu.edu.WebStore.WindowsAndControl.RegistrationWindow;


public class ConfirmationView extends BaseView {

    WebStoreUI parentUI;
    
    private Table table;
    private CreditCardForm creditCardForm;
    private CreditCard creditCard;
    private Button cancelButton;
    private Button submitButton;
    private VerticalLayout checkOutLayout = null;

    public ConfirmationView(WebStoreUI ui){
        super(ui);
        parentUI = ui;
        
        initializeLayouts();
        creditCardForm.getCard().focus();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        super.enter(event);
        RefreshLogInOutComponent();
        
        //get all products in the cart from the session
        SiteUser currentUser = (SiteUser)parentUI.getSession().getAttribute("SiteUser");
        ShoppingCart cart = currentUser.getShoppingCart();
        
        //get cart items as an indexed container and bind to UI
        IndexedContainer cartItemsContainer = cart.getCartContainer();
        
        table.setContainerDataSource(cartItemsContainer);
        table.setPageLength(cartItemsContainer.size());
        table.setColumnFooter("Price", "$" + cart.getTotal());
        
        // Auto Fill in first and last name;
        creditCardForm.setfName(currentUser.getFirstName());
        creditCardForm.setlName(currentUser.getLastName());
    }

    /**
     * Initializes the layout that are used in this view.
     */
    private void initializeLayouts() {
        
        checkOutLayout = new VerticalLayout();
        checkOutLayout.setWidth("100%");
        checkOutLayout.setSpacing(true);
        checkOutLayout.setMargin(true);
        
        HorizontalLayout summaryLayout = new HorizontalLayout();
        summaryLayout.setWidth("100%");

        table = new Table("Products");
        table.setSelectable(false);
        table.setFooterVisible(true);
        table.setColumnFooter("Product", "Total Price");
        table.setColumnFooter("Price", "");
        
        summaryLayout.addComponent(table);
        summaryLayout.setComponentAlignment(table, Alignment.TOP_LEFT);
        
        creditCardForm = new CreditCardForm();
        creditCardForm.setAvailableCreditCards();
        creditCardForm.setAvailableCountries();
        
        summaryLayout.addComponent(creditCardForm);
        summaryLayout.setComponentAlignment(creditCardForm, Alignment.TOP_RIGHT);
        checkOutLayout.addComponent(summaryLayout);
        
        cancelButton = new Button("CANCEL",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        parentUI.nav.navigateTo("");
                    }
                });
        
        submitButton = new Button("SUBMIT",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        if(creditCardForm.checkFields() == true) {
                            //Open Summary Window
                            String address = creditCardForm.getStreetAsString() + ", " 
                                    + creditCardForm.getCityAsString() + ", " 
                                    + creditCardForm.getStateAsString() + " "
                                    + creditCardForm.getZipAsString();
                            
                            PurchaseSummary summaryWindow = new PurchaseSummary(parentUI, address);
                            summaryWindow.setHeight("75%");
                            summaryWindow.setWidth("50%");
                            summaryWindow.center();
                            getUI().addWindow(summaryWindow);
                            
                            SiteUser currentUser = (SiteUser)parentUI.getSession().getAttribute("SiteUser");
                            ShoppingCart cart = currentUser.getShoppingCart();
                            cart.removeAllProducts();
                            parentUI.mySQLAccess.saveCart(currentUser);
                            parentUI.getSession().setAttribute("SiteUser", currentUser);
        
                            //navigate to home page
                            parentUI.nav.navigateTo("");
                        }
                    }
                });
        
        HorizontalLayout buttons = new HorizontalLayout(cancelButton, submitButton);
        buttons.setSpacing(true);
        
        checkOutLayout.addComponent(buttons);
        checkOutLayout.setComponentAlignment(buttons, Alignment.BOTTOM_CENTER);
        addComponent(checkOutLayout);
    }
}
