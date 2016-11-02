package WebStore;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@PreserveOnRefresh
public class WebStoreUI extends UI {

    public VaadinRequest vaadinRequest;

    protected Navigator nav;
    protected View myHomeView;
    protected View computersView;
    protected View logInView;

    protected MySQLAccess mySQLAccess;
    VaadinSession session;

    final public static String VIEW_STORE_HOME = "";
    final public static String VIEW_COMPUTERS = "computers";

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        this.vaadinRequest = vaadinRequest;

        mySQLAccess = new MySQLAccess();
        try {
            mySQLAccess.readDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //initially no password
        session = this.getSession();
        session.setAttribute("LogInInfo","");

        nav = new Navigator(this, this);

        myHomeView = new HomeView(this);
        nav.addView("",myHomeView);

        computersView = new ComputersView(this);
        nav.addView(VIEW_COMPUTERS,computersView);


    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = WebStoreUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

}
