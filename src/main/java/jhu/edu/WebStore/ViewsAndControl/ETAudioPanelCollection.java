package jhu.edu.WebStore.ViewsAndControl;

import jhu.edu.WebStore.ViewsAndControl.BasePanelCollection;
import jhu.edu.WebStore.WebStoreUI;


public class ETAudioPanelCollection extends BasePanelCollection {

    WebStoreUI parentUI;

    public ETAudioPanelCollection(WebStoreUI ui) {
        super(ui);
        this.parentUI = ui;

        specificProducts = parentUI.mySQLAccess.getETAudioProducts();
        buildPanelCollection();
    }
}
