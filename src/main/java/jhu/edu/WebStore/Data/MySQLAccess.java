package jhu.edu.WebStore.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MySQLAccess {

    //TODO currently db connection is not actually closed anywhere....

    private Connection connect = null;
    private Statement statement = null;

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/webstoredb?user=root&password=");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query

        } catch (Exception e) {
            throw e;
        }
    }
    

    public ArrayList<Product> getProducts() {
        ResultSet resultSet = null;
        ArrayList<Product> products = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("select * from products");
            while (resultSet.next()) {
                productDataExtractor(resultSet, products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            close();
//        }
        return products;
    }


    public ArrayList<Product> getCompPCProducts() {
        ResultSet resultSet = null;
        ArrayList<Product> products = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("select * from products where Category = 'COMP' && Subcategory = 'Desktop'");
            while (resultSet.next()) {
                productDataExtractor(resultSet, products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            close();
//        }
        return products;
    }

    public ArrayList<Product> getCompLaptopProducts() {
        ResultSet resultSet = null;
        ArrayList<Product> products = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("select * from products where Category = 'COMP' && Subcategory = 'Laptop'");
            while (resultSet.next()) {
                productDataExtractor(resultSet, products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            close();
//        }
        return products;
    }

    public ArrayList<Product> getCompTabletProducts() {
        ResultSet resultSet = null;
        ArrayList<Product> products = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("select * from products where Category = 'COMP' && Subcategory = 'Tablet'");
            while (resultSet.next()) {
                productDataExtractor(resultSet, products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            close();
//        }
        return products;
    }
    
    public ArrayList<Product> getGamingConsoleProducts() {
        ResultSet resultSet = null;
        ArrayList<Product> products = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("select * from products where Category = 'GAMING' && Subcategory = 'Console'");
            while (resultSet.next()) {
                productDataExtractor(resultSet, products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            close();
//        }
        return products;
    }
    
    public ArrayList<Product> getGamingPCProducts() {
        ResultSet resultSet = null;
        ArrayList<Product> products = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("select * from products where Category = 'GAMING' && Subcategory = 'PC'");
            while (resultSet.next()) {
                productDataExtractor(resultSet, products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            close();
//        }
        return products;
    }

    public ArrayList<Product> getETAudioProducts() {
        ResultSet resultSet = null;
        ArrayList<Product> products = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("select * from products where Category = 'ELECTRONICS' && Subcategory = 'Audio'");
            while (resultSet.next()) {
                productDataExtractor(resultSet, products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            close();
//        }
        return products;
    }
    
    public ArrayList<Product> getETTVVideoProducts() {
        ResultSet resultSet = null;
        ArrayList<Product> products = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("select * from products where Category = 'ELECTRONICS' && Subcategory = 'TV/Video'");
            while (resultSet.next()) {
                productDataExtractor(resultSet, products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            close();
//        }
        return products;
    }
    
    public Product getProductById(String productId) {
        ResultSet resultSet = null;
        Product product = null;
        try {
            resultSet = statement.executeQuery("select * from products where ID = '"+productId+"'");
            if(resultSet.next()) {
                String id = resultSet.getString("ID");
                String category = resultSet.getString("Category");
                String subcategory = resultSet.getString("Subcategory");
                String name = resultSet.getString("Name");
                String description = resultSet.getString("Description");
                String price = resultSet.getString("Price");
                String imageLocation = resultSet.getString("ImageLocation");
                //could probably add quantity...
                product = new Product(id, category, subcategory, name, description, price, imageLocation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            close();
//        }
        return product;
    }

    private void productDataExtractor(ResultSet resultSet, ArrayList<Product> products) throws SQLException {
        String id = resultSet.getString("ID");
        String category = resultSet.getString("Category");
        String subcategory = resultSet.getString("Subcategory");
        String name = resultSet.getString("Name");
        String description = resultSet.getString("Description");
        String price = resultSet.getString("Price");
        String imageLocation = resultSet.getString("ImageLocation");
        //could probably add quantity...
        Product product = new Product(id, category, subcategory, name, description, price, imageLocation);
        products.add(product);
    }

    public boolean usernameAlreadyUsed(String username) {
        ResultSet resultSet = null;
        String uname = "";
        try {
            resultSet = statement.executeQuery("SELECT * FROM siteuser where username='"+username+"'");
            if(resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            String message = e.getLocalizedMessage();
            System.out.println(message);
            return true;
        }
        // Username not already in use
        return false;
    }
    
    public void validateUser(LogInCredentials login) {
        ResultSet resultSet = null;
        String uname = "";
        String pword = "";

        try {
            resultSet = statement.executeQuery(
                    "SELECT username, password FROM siteuser where username='"
                    + login.getName() + "';");
            
            resultSet.next();
            uname = resultSet.getString("username");
            pword = resultSet.getString("password");
            
            if(uname.equals(login.getName()) && pword.equals(login.getPassword())) {
                login.areValid(true);
            } else {
                login.areValid(false);
            }
        } catch (SQLException e) {
            return;
        }
    }
    
    public void addUserInfo(String uname, String fname, String lname, String pword) {
        String insert = "insert into siteUser (username, password, firstname, lastname, purchasedItems)"
                + " values (?, ?, ?, ?, ?)";
        
        // Create the mysql inser prepared statement
        try {
            PreparedStatement preparedStmt = connect.prepareStatement(insert);
            preparedStmt.setString(1, uname);
            preparedStmt.setString(2, pword);
            preparedStmt.setString(3, fname);
            preparedStmt.setString(4, lname);
            preparedStmt.setString(5, "");
            preparedStmt.execute();
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public SiteUser getUserInfo(String uname){

        ResultSet resultSet = null;
        SiteUser siteUser = null;

        try {
            resultSet = statement.executeQuery("select * from siteUser where username = '"+uname+"'");
            if(resultSet.next()) {
                int id = resultSet.getInt("ID");
                String password = resultSet.getString("password");
                String username = resultSet.getString("username");
                String fname = resultSet.getString("firstname");
                String lname = resultSet.getString("lastname");
                //String address = resultSet.getString("address");
                //String creditCardInfo = resultSet.getString("creditCardInfo");

                String purchasedItems = resultSet.getString("purchasedItems");

                    
                ShoppingCart cart = new ShoppingCart();
                if(purchasedItems != null) {
                    if(!purchasedItems.isEmpty()) {
                        String purchasedItemsQty = resultSet.getString("purchasedItemsQuantities");
                        String[] purchasedItemsQtyArray = purchasedItemsQty.split(",");
                        int count = 0;
                        for (String productID : purchasedItems.split(",")) {
                            Product product = getProductById(productID.trim());
                            if(product != null)
                            {
                                product.setQuantity(Integer.valueOf(purchasedItemsQtyArray[count].trim()));
                                cart.addProduct(product);
                                count++;
                            }
                        }
                    }
                }

                //user should have login and password
                //this probably needs some work
                LogInCredentials logIn = new LogInCredentials(username, password);
                logIn.areValid(true);


                siteUser = new SiteUser(id, username, fname, lname, cart, logIn);
            } else {
                siteUser = new SiteUser();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return siteUser;
    }

    public void saveCart (SiteUser user){
        System.out.println("save to cart...");
        ShoppingCart cart = user.getShoppingCart();
        String savedCart = "";
        String updateCart = "update siteUser set purchasedItems = ? where username = ?";

        String savedCartQty = "";
        String updateCartQty = "update siteUser set purchasedItemsQuantities = ? where username = ?";
        
        for(Product item: cart.getItems()) {
            savedCart += item.getID() + ",";
            savedCartQty += item.getQuantity() + ",";
        }
        
        try {
            PreparedStatement preparedStmt = connect.prepareStatement(updateCart);
            preparedStmt.setString(1, savedCart);
            preparedStmt.setString(2, user.getUserName());
            preparedStmt.execute();

            preparedStmt = connect.prepareStatement(updateCartQty);
            preparedStmt.setString(1, savedCartQty);
            preparedStmt.setString(2, user.getUserName());
            preparedStmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> SearchInventory (String productSearch){

        ResultSet resultSet = null;
        ArrayList<Product> products = new ArrayList<>();

        try {
            resultSet = statement.executeQuery("select * from products where Description LIKE upper('% "+productSearch+" %')OR Name LIKE upper('%"+productSearch+"%')");
            while (resultSet.next()) {
                productDataExtractor(resultSet, products);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            close();
//        }
        return products;

    }



    private void close() {
        try {

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
