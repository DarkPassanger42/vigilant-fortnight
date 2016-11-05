package WebStore;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;


public class ComputersView extends BaseView {

    public ComputersView(WebStoreUI ui){
        super(ui);

        //placeholder layout for the moment...

        Panel computersPanel = new Panel();
        HorizontalLayout computersLayout = new HorizontalLayout();
        computersLayout.setWidthUndefined();
        computersLayout.setSpacing(true);

        //-----------will be from DB----------
        for (int i = 0; i < 10; i++){
            Panel panel = new Panel("PCs");
            FormLayout form = new FormLayout();
            form.setMargin(true);
            form.addComponent(new Label("PC"));
            panel.setContent(form);
            computersLayout.addComponent(panel);
        }
        //---------------------------------------

        computersPanel.setContent(computersLayout);
        computersPanel.setWidth("100%");
        computersPanel.setHeight("200px");
        addComponent(computersPanel);


        Panel componentsPanel = new Panel();
        HorizontalLayout componentsLayout = new HorizontalLayout();
        componentsLayout.setWidthUndefined();
        componentsLayout.setSpacing(true);

        //-----------will be from DB----------
        for (int i = 0; i < 10; i++){
            Panel panel = new Panel("PCs");
            FormLayout form = new FormLayout();
            form.setMargin(true);
            form.addComponent(new Label("PC"));
            panel.setContent(form);
            componentsLayout.addComponent(panel);
        }
        //---------------------------------------

        componentsPanel.setContent(componentsLayout);
        componentsPanel.setWidth("100%");
        componentsPanel.setHeight("200px");
        addComponent(componentsPanel);

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
