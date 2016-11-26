package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import jhu.edu.WebStore.*;
import jhu.edu.WebStore.Data.LogInCredentials;


public abstract class BaseView extends VerticalLayout implements View {

    protected VerticalLayout viewContent = new VerticalLayout();
    protected HorizontalLayout menuLayout = new HorizontalLayout();
    protected WebStoreUI parentUI;

    jhu.edu.WebStore.ViewsAndControl.LogInAndOutComponent LogInAndOutComponent;

    public BaseView(WebStoreUI ui){
        this.parentUI = ui;

        LogInAndOutComponent = new LogInAndOutComponent(parentUI);

        menuLayout.addComponent(new HeaderBar(ui));
        menuLayout.addComponent(LogInAndOutComponent);
        menuLayout.setComponentAlignment(LogInAndOutComponent, Alignment.MIDDLE_RIGHT);
        menuLayout.setWidth("100%");

        viewContent.setSpacing(true);
//        super.addComponent(LogInAndOutComponent);
//        super.addComponent(new HeaderBar(ui));
        super.addComponent(menuLayout);
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
