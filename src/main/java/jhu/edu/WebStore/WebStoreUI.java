package jhu.edu.WebStore;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;
import jhu.edu.WebStore.Data.LogInCredentials;
import jhu.edu.WebStore.Data.MySQLAccess;
import jhu.edu.WebStore.Data.ShoppingCart;
import jhu.edu.WebStore.Data.SiteUser;
import jhu.edu.WebStore.ViewsAndControl.ComputersView;
import jhu.edu.WebStore.ViewsAndControl.GamingView;
import jhu.edu.WebStore.ViewsAndControl.ElectronicsView;
import jhu.edu.WebStore.ViewsAndControl.ConfirmationView;
import jhu.edu.WebStore.ViewsAndControl.HomeView;

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

    public Navigator nav;
    protected View myHomeView;
    protected View computersView;
    protected View gamingView;
    protected View electronicsView;
    protected View confirmationView;

    //normally these probably should probably be private with get/set
    public MySQLAccess mySQLAccess;
    public VaadinSession session;

    final public static String VIEW_STORE_HOME = "";
    final public static String VIEW_COMPUTERS = "computers";
    final public static String VIEW_GAMING = "gaming";
    final public static String VIEW_ELECTRONICS = "electronics";
    final public static String VIEW_CONFIRMATION = "confirmation";

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        this.vaadinRequest = vaadinRequest;

        //TODO currently connection is opened, but never closed, need to close it somewhere
        mySQLAccess = new MySQLAccess();
        try {
            mySQLAccess.readDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //initially no password
        session = this.getSession();
        session.setAttribute("LogInInfo",new LogInCredentials("",""));
        session.setAttribute("SiteUser", new SiteUser());

        nav = new Navigator(this, this);

        myHomeView = new HomeView(this);
        nav.addView("",myHomeView);

        computersView = new ComputersView(this);
        nav.addView(VIEW_COMPUTERS,computersView);
        
        gamingView = new GamingView(this);
        nav.addView(VIEW_GAMING, gamingView);
        
        electronicsView = new ElectronicsView(this);
        nav.addView(VIEW_ELECTRONICS, electronicsView);

        confirmationView = new ConfirmationView(this);
        nav.addView(VIEW_CONFIRMATION,confirmationView);

        //TODO add other views here

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = WebStoreUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }


}
