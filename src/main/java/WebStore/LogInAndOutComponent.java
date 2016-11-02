package WebStore;

import com.vaadin.event.MouseEvents;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.*;

public class LogInAndOutComponent extends CustomComponent implements Button.ClickListener{

    protected Button logInAndOutButton;
    protected Button cart;

    protected Label infoLabel;

    public LogInAndOutComponent(){


        HorizontalLayout components = new HorizontalLayout();
        logInAndOutButton = new Button("Log In",this);
        cart = new Button("CART", this);
        infoLabel = new Label();
        components.addComponent(infoLabel);
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
            getSession().setAttribute("LogInInfo","");
            getUI().getNavigator().getCurrentView().enter(null);
        }
        else if (clickEvent.getComponent().getCaption().equals("LOG IN")){
            LogInWindow logInWindow = new LogInWindow();
            logInWindow.setHeight("50%");
            logInWindow.setWidth("50%");
            logInWindow.center();
            UI.getCurrent().addWindow(logInWindow);
        }
    }

    public void changeLogInButtonText(String newText){
        logInAndOutButton.setCaption(newText);
    }

    public void changeWelcomeText(String newText){
        infoLabel.setCaption(newText);
    }

}
