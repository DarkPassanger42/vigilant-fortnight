package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.ui.*;
import jhu.edu.WebStore.WebStoreUI;


public class HeaderBar extends VerticalLayout {

    private MenuBar mainMenu = new MenuBar();
    private MenuBar accountMenuBar = new MenuBar();
    private MenuBar.MenuItem LogIn;


    private WebStoreUI parentUI;

    public HeaderBar(WebStoreUI parentUI){
        super();
        this.parentUI = parentUI;


        //add main menu
        VerticalLayout menuBarLayout = new VerticalLayout();
        menuBarLayout.setWidth("100%");

        MenuBar.MenuItem home = mainMenu.addItem("HOME",null ,goHome);

        MenuBar.MenuItem computers = mainMenu.addItem("Computers",null, goToPc);
//        computers.addItem("PC", null, goToPc);
//        computers.addItem("Laptop", null, null);
//        computers.addItem("Tablet", null, null);

        MenuBar.MenuItem components = mainMenu.addItem("Components",null, null);
//        components.addItem("Storage",null,null);
//        components.addItem("Memory", null, null);
//        components.addItem("Processors", null, null);

        MenuBar.MenuItem electronics = mainMenu.addItem("Electronics",null, null);
//        electronics.addItem("TV/Video",null,null);
//        electronics.addItem("Audio", null, null);

        menuBarLayout.addComponent(mainMenu);

        addComponent(menuBarLayout);

    }

    MenuBar.Command goToPc = new MenuBar.Command() {
        public void menuSelected(MenuBar.MenuItem selectedItem) {
            parentUI.nav.navigateTo(parentUI.VIEW_COMPUTERS);
        }
    };

    MenuBar.Command goHome = new MenuBar.Command() {
        public void menuSelected(MenuBar.MenuItem selectedItem) {
            parentUI.nav.navigateTo("");
        }
    };

}
