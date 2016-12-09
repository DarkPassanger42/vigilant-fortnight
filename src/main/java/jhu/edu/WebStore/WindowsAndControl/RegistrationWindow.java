package jhu.edu.WebStore.WindowsAndControl;


import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Reindeer;
import java.util.Collection;
import jhu.edu.WebStore.Data.LogInCredentials;
import jhu.edu.WebStore.Data.SiteUser;
import jhu.edu.WebStore.WebStoreUI;


public class RegistrationWindow extends Window {

    WebStoreUI parentUI;
    private final TextField user;
    private final TextField fname;
    private final TextField lname;
    private final PasswordField password;
    private final Button submit;

    public RegistrationWindow(WebStoreUI ui){
        super("REGISTRATION");
        parentUI = ui;

        //Create the user input field
        user = new TextField("User:");
        user.setWidth("300px");
        user.setRequired(true);
        user.setInputPrompt("Your username (eg. joe@email.com)");
        user.addValidator(new EmailValidator(
                "Username must be an email address"));
        user.setInvalidAllowed(false);
        
        //Create the fname input field
        fname = new TextField("First Name:");
        fname.setWidth("300px");
        fname.setRequired(true);
        fname.addValidator(new StringLengthValidator(
                "First name must be atleast 3 characters", 3, Integer.MAX_VALUE, false));
        fname.setInvalidAllowed(false);
        
        //Create the lname input field
        lname = new TextField("Last Name:");
        lname.setWidth("300px");
        lname.setRequired(true);
        lname.addValidator(new StringLengthValidator(
                "Last name must be atleast 3 characters", 3, Integer.MAX_VALUE, false));
        lname.setInvalidAllowed(false);

        // Create the password input field
        password = new PasswordField("Password:");
        password.setWidth("300px");
        password.addValidator(new PasswordValidator());
        password.setRequired(true);
        password.setValue("");
        password.setNullRepresentation("");

        submit = new Button("SUBMIT",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        RegisterUser();
                    }
                });
        
        // Add both to a panel
        VerticalLayout fields = new VerticalLayout(user, fname, lname, password, submit);
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
    
    private void RegisterUser() {

        // Validate the fields using the navigator. By using validors for the
        // fields we reduce the amount of queries we have to use to the database
        // for wrongly entered passwords
        //
        if (!user.isValid() || !fname.isValid() || 
                !lname.isValid() || !password.isValid()) {
            return;
        }

        String username = user.getValue().toLowerCase();
        String firstname = fname.getValue();
        String lastname = lname.getValue();
        String password = this.password.getValue();

        /*
         * Make sure username is not already used
         */
        if(parentUI.mySQLAccess.usernameAlreadyUsed(username) == true) {
            user.clear();
            Notification.show("Username is already taken.",
                        "",
                        Notification.Type.ERROR_MESSAGE);
            return;
        }

        /*
         * Insert user Information into DB
         */
        parentUI.mySQLAccess.addUserInfo(username, firstname, lastname, password);
        getSession().setAttribute("SiteUser", parentUI.mySQLAccess.getUserInfo(username));
        
        /*
         * Log user in and update view
         */
        LogInCredentials logInCredentials = new LogInCredentials(username, password);
        logInCredentials.areValid(true);
        
        // Store the current user in the service session
        getSession().setAttribute("LogInInfo", logInCredentials);
        getUI().getNavigator().getCurrentView().enter(null);
        this.close();
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


