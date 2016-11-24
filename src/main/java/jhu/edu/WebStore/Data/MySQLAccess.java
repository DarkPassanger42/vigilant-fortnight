package jhu.edu.WebStore.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MySQLAccess {

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



    //getUser(String ID)

    //addUser()

    //authenticateUser(String userName, String password)


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

    public Product getProductById(String productId) {
        ResultSet resultSet = null;
        Product product = null;
        try {
            resultSet = statement.executeQuery("select * from products where ID = '"+productId+"'");

            String id = resultSet.getString("ID");
            String category = resultSet.getString("Category");
            String subcategory = resultSet.getString("Subcategory");
            String name = resultSet.getString("Name");
            String description = resultSet.getString("Description");
            String price = resultSet.getString("Price");
            String imageLocation = resultSet.getString("ImageLocation");
            //could probably add quantity...
            product = new Product(id, category, subcategory, name, description, price, imageLocation);

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

    private SiteUser getUserInfo(String userID){

        ResultSet resultSet = null;
        SiteUser siteUser = null;

        try {
            resultSet = statement.executeQuery("select * from siteUser where ID = '"+userID+"'");

            String id = resultSet.getString("ID");
            String password = resultSet.getString("Password");

            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String creditCardInfo = resultSet.getString("creditCardInfo");

            String purchasedItems = resultSet.getString("purchasedItems");

            //alternatively (a better way) is to do a table here
            //rather than a csv product list
            ShoppingCart cart = new ShoppingCart();
            for (String productID : purchasedItems.split(",")) {
                cart.addProduct(getProductById(productID.trim()));
            }

            //user should have login and password
            //this probably needs some work
            LogInCredentials logIn = new LogInCredentials(id, password);
            logIn.areValid(true);


            siteUser = new SiteUser(id, name, address, creditCardInfo, cart, logIn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            close();
//        }
        return siteUser;
    }

    private ShoppingCart getCart (String userID){
        //TODO implement....
        return null;
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
