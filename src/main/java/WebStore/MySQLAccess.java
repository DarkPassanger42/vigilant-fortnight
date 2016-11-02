package WebStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


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
            String id = resultSet.getString("ID");
            String category = resultSet.getString("Category");
            String subcategory = resultSet.getString("Subcategory");
            String name = resultSet.getString("Name");
            String description = resultSet.getString("Description");
            String price = resultSet.getString("Price");
            //could probably add quantity...
            Product product = new Product(id, category, subcategory, name, description, price);
            products.add(product);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            close();
        }
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
