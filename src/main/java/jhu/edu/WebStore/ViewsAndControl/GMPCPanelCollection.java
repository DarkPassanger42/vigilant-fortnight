package jhu.edu.WebStore.ViewsAndControl;

import jhu.edu.WebStore.ViewsAndControl.BasePanelCollection;
import jhu.edu.WebStore.WebStoreUI;


public class GMPCPanelCollection extends BasePanelCollection {

    WebStoreUI parentUI;

    public GMPCPanelCollection(WebStoreUI ui) {
        super(ui);
        this.parentUI = ui;

        specificProducts = parentUI.mySQLAccess.getGamingPCProducts();
        buildPanelCollection();
    }
}
