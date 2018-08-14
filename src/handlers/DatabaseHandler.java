package handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
