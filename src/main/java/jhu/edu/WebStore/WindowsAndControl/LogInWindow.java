package jhu.edu.WebStore.WindowsAndControl;


import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Reindeer;
import java.util.Collection;
import jhu.edu.WebStore.Data.LogInCredentials;
import jhu.edu.WebStore.WebStoreUI;


public class LogInWindow extends Window {

    WebStoreUI parentUI;
    private final TextField user;
    private final PasswordField password;
    private final Button loginButton;
    private final Button registerButton;

    public LogInWindow(WebStoreUI ui){
        super("LOG IN");
        parentUI = ui;

        //Create the user input field
        user = new TextField("User:");
        user.setWidth("300px");
        user.setRequired(true);
        user.setInputPrompt("Your username (eg. joe@email.com)");
        user.addValidator(new EmailValidator(
                "Username must be an email address"));
        user.setInvalidAllowed(false);

        // Create the password input field
        password = new PasswordField("Password:");
        password.setWidth("300px");
        password.addValidator(new PasswordValidator());
        password.setRequired(true);
        password.setValue("");
        password.setNullRepresentation("");

        loginButton = new Button("LOG IN",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        AuthenticateUser();
                    }
                });
        
        registerButton = new Button("REGISTER",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        RegistrationWindow registerWindow = new RegistrationWindow(parentUI);
                        registerWindow.setHeight("75%");
                        registerWindow.setWidth("50%");
                        registerWindow.center();
                        getUI().addWindow(registerWindow);
                        close();
                    }
                });

        HorizontalLayout buttons = new HorizontalLayout(loginButton, registerButton);
        buttons.setSpacing(true);
        
        // Add both to a panel
        VerticalLayout fields = new VerticalLayout(user, password, buttons);
        fields.setCaption("Please login to access the application. (joe@test.com/123)");
        fields.setSpacing(true);
        fields.setMargin(new MarginInfo(true, true, true, false));
        fields.setSizeUndefined();

        // The view root layout
        VerticalLayout viewLayout = new VerticalLayout(fields);
        viewLayout.setSizeFull();
        viewLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
        viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
        setContent(viewLayout);
    }
    
    private void AuthenticateUser() {

        // Validate the fields using the navigator. By using validors for the
        // fields we reduce the amount of queries we have to use to the database
        // for wrongly entered passwords
        //
        if (!user.isValid() || !password.isValid()) {
            return;
        }

        String username = user.getValue().toLowerCase();
        String password = this.password.getValue();

        /*
         * Validate username and password with database here. For examples sake
         * I use a dummy username and password.
         */

        LogInCredentials logInCredentials = new LogInCredentials(username, password);
        parentUI.mySQLAccess.validateUser(logInCredentials);

        if (logInCredentials.areValid()) {

            // Store the current user in the service session
            getSession().setAttribute("LogInInfo", logInCredentials);
            getSession().setAttribute("SiteUser", parentUI.mySQLAccess.getUserInfo(username));
            getUI().getNavigator().getCurrentView().enter(null);
            this.close();

        } else {

            // Wrong password clear the password field and refocuses it
            this.password.setValue(null);
            this.password.focus();

        }

    }

    public static final class PasswordValidator extends
            AbstractValidator<String> {

        public PasswordValidator() {
            super("The password provided is not valid");
        }

        @Override
        protected boolean isValidValue(String value) {
            //
            // Password must be at least 8 characters long and contain at least
            // one number
            //
//            if (value != null
//                    && (value.length() < 8 || !value.matches(".*\\d.*"))) {
//                return false;
//            }

            //make always true for now... but can add any additional stuff later...
            return true;
        }

        @Override
        public Class<String> getType() {
            return String.class;
        }
    }

}


