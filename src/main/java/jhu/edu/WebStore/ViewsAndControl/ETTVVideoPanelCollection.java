package jhu.edu.WebStore.ViewsAndControl;

import jhu.edu.WebStore.ViewsAndControl.BasePanelCollection;
import jhu.edu.WebStore.WebStoreUI;


public class ETTVVideoPanelCollection extends BasePanelCollection {

    WebStoreUI parentUI;

    public ETTVVideoPanelCollection(WebStoreUI ui) {
        super(ui);
        this.parentUI = ui;

        specificProducts = parentUI.mySQLAccess.getETTVVideoProducts();
        buildPanelCollection();
    }
}
