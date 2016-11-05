package WebStore;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;


public abstract class BaseView extends VerticalLayout implements View {

    protected VerticalLayout viewContent = new VerticalLayout();
    protected WebStoreUI parentUI;

    WebStore.LogInAndOutComponent LogInAndOutComponent;

    public BaseView(WebStoreUI ui){
        this.parentUI = ui;

        LogInAndOutComponent = new LogInAndOutComponent(parentUI);

        viewContent.setSpacing(true);
        super.addComponent(LogInAndOutComponent);
        super.addComponent(new HeaderBar(ui));
        super.addComponent(viewContent);
        super.addComponent(new FooterBar(ui));
    }

    @Override
    public void addComponent(Component c){
        viewContent.addComponent(c);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){
    }

    public void RefreshLogInOutComponent(){
        Object logIngInfo = parentUI.session.getAttribute("LogInInfo");
        LogInCredentials lc = (LogInCredentials)logIngInfo;



        if (lc.areValid()){
            //means we're already logged in
            LogInAndOutComponent.changeLogInButtonText("LOG OUT");
            LogInAndOutComponent.changeWelcomeText("Welcome " + lc.getName());
        }
        else{
            LogInAndOutComponent.changeLogInButtonText("LOG IN");
            LogInAndOutComponent.changeWelcomeText("Welcome Guest");
        }
    }

}
