package jhu.edu.WebStore.ViewsAndControl;

import jhu.edu.WebStore.ViewsAndControl.BasePanelCollection;
import jhu.edu.WebStore.WebStoreUI;


public class PCPanelCollection extends BasePanelCollection {

    WebStoreUI parentUI;

    public PCPanelCollection(WebStoreUI ui) {
        super(ui);
        this.parentUI = ui;

        specificProducts = parentUI.mySQLAccess.getCompPCProducts();
        buildPanelCollection();
    }
}
