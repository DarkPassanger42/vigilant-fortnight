package WebStore;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;


public class ComputersView extends BaseView {

    public ComputersView(WebStoreUI ui){
        super(ui);

        //placeholder layout for the moment...

        HorizontalLayout computersLayout = new HorizontalLayout();
        computersLayout.setWidth("100%");
        computersLayout.setHeight("200");
        computersLayout.addComponent(new Label("PC1"));
        computersLayout.setSpacing(true);
        addComponent(computersLayout);

        HorizontalLayout componentsLayout = new HorizontalLayout();
        componentsLayout.setWidth("100%");
        componentsLayout.setHeight("200");
        componentsLayout.addComponent(new Label("component1"));
        componentsLayout.setSpacing(true);
        addComponent(componentsLayout);

        HorizontalLayout electronicsLayout = new HorizontalLayout();
        electronicsLayout.setWidth("100%");
        electronicsLayout.setHeight("200");
        electronicsLayout.addComponent(new Label("electronic1"));
        electronicsLayout.setSpacing(true);
        addComponent(electronicsLayout);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        super.enter(event);
        RefreshLogInOutComponent();
    }
}
