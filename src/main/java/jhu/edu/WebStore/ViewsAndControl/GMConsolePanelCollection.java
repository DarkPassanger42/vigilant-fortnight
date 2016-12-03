package jhu.edu.WebStore.ViewsAndControl;

import jhu.edu.WebStore.ViewsAndControl.BasePanelCollection;
import jhu.edu.WebStore.WebStoreUI;


public class GMConsolePanelCollection extends BasePanelCollection {

    WebStoreUI parentUI;

    public GMConsolePanelCollection(WebStoreUI ui) {
        super(ui);
        this.parentUI = ui;

        specificProducts = parentUI.mySQLAccess.getGamingConsoleProducts();
        buildPanelCollection();
    }
}
