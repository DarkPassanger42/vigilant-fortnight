package jhu.edu.WebStore.ViewsAndControl;

import com.vaadin.ui.*;
import jhu.edu.WebStore.Data.Product;
import jhu.edu.WebStore.Helpers.OnEnterKeyHandler;
import jhu.edu.WebStore.WebStoreUI;
import jhu.edu.WebStore.WindowsAndControl.SearchResultsWindow;


import java.util.ArrayList;


public class HeaderBar extends VerticalLayout {

    private MenuBar mainMenu = new MenuBar();
    private MenuBar accountMenuBar = new MenuBar();
    private MenuBar.MenuItem LogIn;


    private WebStoreUI parentUI;

    public HeaderBar(WebStoreUI parentUI){
        super();
        this.parentUI = parentUI;


        //add main menu
        HorizontalLayout menuBarLayout = new HorizontalLayout();

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

        mainMenu.setWidthUndefined();

        //--------Search Menu------------
        Label searchLabel = new Label("    Search");
        searchLabel.setWidthUndefined();
        TextField searchTextInput = new TextField();
        searchTextInput.setWidthUndefined();
        searchTextInput.setImmediate(true);

        OnEnterKeyHandler onEnterHandler=new OnEnterKeyHandler(){
            @Override
            public void onEnterKeyPressed() {
                SearchProducts(searchTextInput.getValue());
            }
        };
        onEnterHandler.installOn(searchTextInput);
        //-------------------------------

        menuBarLayout.addComponent(mainMenu);
        menuBarLayout.setComponentAlignment(mainMenu,Alignment.MIDDLE_LEFT);

        menuBarLayout.addComponent(searchLabel);
        menuBarLayout.setComponentAlignment(searchLabel,Alignment.MIDDLE_LEFT);

        menuBarLayout.addComponent(searchTextInput);
        menuBarLayout.setComponentAlignment(searchTextInput,Alignment.MIDDLE_LEFT);


        menuBarLayout.setWidthUndefined();
        menuBarLayout.setSpacing(true);
        menuBarLayout.setMargin(true);

        addComponent(menuBarLayout);
    }

    //--------Search Menu------------
    //ideally should probably move this out...
    private void SearchProducts(String value) {

        if (value.equals("")){
            Notification.show("Enter search terms...",
                    "",
                    Notification.Type.HUMANIZED_MESSAGE);
            return;
        }

        ArrayList<Product> products = parentUI.mySQLAccess.SearchInventory(value);
        if (products.size() == 0){
            Notification.show("Nothing Found...",
                    "",
                    Notification.Type.HUMANIZED_MESSAGE);
        }
        else{
            SearchResultsWindow searchResultsWindow = new SearchResultsWindow(products,parentUI);
            searchResultsWindow.setHeight("650px");
            searchResultsWindow.setWidth("500px");
            searchResultsWindow.center();
            UI.getCurrent().addWindow(searchResultsWindow);
            searchResultsWindow.focus();
        }

    }
    //-------------------------------

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
