package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.navigator.ViewChangeListener;
import jhu.edu.WebStore.WebStoreUI;


public class ElectronicsView extends BaseView {

    WebStoreUI parentUI;


    public ElectronicsView(WebStoreUI ui){
        super(ui);
        parentUI = ui;

        ETTVVideoPanelCollection etTVVideoPanelCollection = new ETTVVideoPanelCollection(parentUI);
        addComponent(etTVVideoPanelCollection);

        ETAudioPanelCollection etAudioPanelCollection = new ETAudioPanelCollection(parentUI);
        addComponent(etAudioPanelCollection);
        
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        super.enter(event);
        RefreshLogInOutComponent();

    }

}
