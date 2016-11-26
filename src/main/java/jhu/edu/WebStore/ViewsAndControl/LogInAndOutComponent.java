package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.ui.*;
import jhu.edu.WebStore.Data.LogInCredentials;
import jhu.edu.WebStore.WindowsAndControl.LogInWindow;
import jhu.edu.WebStore.WebStoreUI;
import jhu.edu.WebStore.WindowsAndControl.CartWindow;

public class LogInAndOutComponent extends CustomComponent implements Button.ClickListener{

    protected Button logInAndOutButton;
    protected Button cart;

    protected Label infoLabel;
    protected WebStoreUI parentUI;

    protected TextField searchTextInput;
    protected Label searchText;

    public LogInAndOutComponent(WebStoreUI ui){
        parentUI = ui;

        HorizontalLayout components = new HorizontalLayout();
        logInAndOutButton = new Button("Log In",this);
        cart = new Button("CART", this);
        infoLabel = new Label();
        searchTextInput = new TextField();
        searchText = new Label("Search");

        components.addComponent(infoLabel);
        components.addComponent(new Label(" "));    //space
        components.addComponent(searchText);
        components.addComponent(searchTextInput);
        components.addComponent(new Label(" "));    //space
        components.addComponent(logInAndOutButton);
        components.addComponent(cart);
        components.setWidthUndefined();
        components.setSpacing(true);
        components.setMargin(true);

        HorizontalLayout componentContainer = new HorizontalLayout();
        componentContainer.setWidth("100%");
        componentContainer.addComponent(components);
        componentContainer.setComponentAlignment(components,Alignment.MIDDLE_RIGHT);


        setCompositionRoot(componentContainer);

    }


    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {

        if (clickEvent.getComponent().getCaption().equals("LOG OUT")){

            //erase session data
            getSession().setAttribute("LogInInfo",new LogInCredentials("",""));
            getUI().getNavigator().getCurrentView().enter(null);
        }
        else if (clickEvent.getComponent().getCaption().equals("LOG IN")){
            LogInWindow logInWindow = new LogInWindow();
            logInWindow.setHeight("50%");
            logInWindow.setWidth("50%");
            logInWindow.center();
            UI.getCurrent().addWindow(logInWindow);
        }
        else if(clickEvent.getComponent().getCaption().equals("CART")){
            Object logInInfo = getSession().getAttribute("LogInInfo");
            LogInCredentials lc = (LogInCredentials)logInInfo;
            if (lc.areValid()){
                //parentUI.nav.navigateTo(parentUI.VIEW_CART);
                CartWindow cartWindow = new CartWindow(parentUI);
                cartWindow.setHeight("650px");
                cartWindow.setWidth("650px");
                cartWindow.center();
                UI.getCurrent().addWindow(cartWindow);
                cartWindow.focus();
            }
            else{
                Notification.show("Must be logged to view cart",
                        "",
                        Notification.Type.WARNING_MESSAGE);
            }

        }
        else{
            //do nothing
        }
    }

    public void changeLogInButtonText(String newText){
        logInAndOutButton.setCaption(newText);
    }

    public void changeWelcomeText(String newText){
        infoLabel.setCaption(newText);
    }

}
