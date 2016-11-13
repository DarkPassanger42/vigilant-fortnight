package jhu.edu.WebStore.ViewsAndControl;

import jhu.edu.WebStore.ViewsAndControl.BasePanelCollection;
import jhu.edu.WebStore.WebStoreUI;

/**
 * Created by andri on 11/9/2016.
 */
public class TabletPanelCollection extends BasePanelCollection {

    WebStoreUI parentUI;

    public TabletPanelCollection(WebStoreUI ui) {
        super(ui);
        this.parentUI = ui;

        specificProducts = parentUI.mySQLAccess.getCompTabletProducts();
        buildPanelCollection();
    }

}
