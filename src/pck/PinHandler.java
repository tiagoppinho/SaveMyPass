package pck;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class responsible for handling data from database related to the master pin.
 * @author Tiago Pinho
 */
public class PinHandler {
    
    private String currentPin = null;
    private String salt = null;
    
    public PinHandler(){
        init();
    }
    
    private void init(){
        Connection connection = DatabaseHandler.getConnection();
        try{
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT pin, salt FROM User");
            resultSet.next();
            this.currentPin = resultSet.getString("pin");
            this.salt = resultSet.getString("salt");
            resultSet.close();
            statement.close();
            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public String getCurrentPin() {
        return currentPin;
    }

    public String getSalt() {
        return salt;
    }
    
}
