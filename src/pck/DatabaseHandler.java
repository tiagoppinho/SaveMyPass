package pck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tiago Pinho
 */
public class DatabaseHandler {
    
    private static final String CONNECTION_PATH = "jdbc:sqlite:db/passwordmanager.sqlite";
    
    /**
     * Gets the database connection and returns it.
     * @return Connection
     */
    public static Connection getConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(CONNECTION_PATH);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    /**
     * Gets the master pin on database and returns it as a string.
     * @return String
     */
    public static String getDatabaseCurrentPin(){
        Connection connection = getConnection();
        String databaseCurrentPin = "";
        try{
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT pin FROM User");
            resultSet.next();
            databaseCurrentPin = resultSet.getString("pin");
            resultSet.close();
            statement.close();
            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return databaseCurrentPin;
    }
    
    /**
     * Updates the master pin and salt on database.
     * @param pin New master pin.
     * @param salt New salt.
     */
    public static void updatePinOnDatabase(String pin, String salt){
        Connection connection = DatabaseHandler.getConnection();
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE User SET pin = " + pin + ", salt = " + salt);
            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
