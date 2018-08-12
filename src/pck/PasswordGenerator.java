package pck;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * Class responsible for generating random secure passwords according to the user needs.
 * @author Tiago Pinho
 */
public class PasswordGenerator {
    
    //Characters
    private final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                         LOWERCASE = "abcdefghijklmnopqrstuvwxyz",
                         NUMBERS = "0123456789",
                         SPECIAL_CHARACTERS = "#$%&/!=.,[]{}-+*";
    
    //Settings
    private int length;
    private boolean uppercase, lowercase, numbers, specialCharacters;
    
    public PasswordGenerator() {
        loadSettings();
    }
    
    /**
     * Loads all the settings from database needed to generate a random secure password.
     */
    private void loadSettings(){
        Connection connection = DatabaseHandler.getConnection();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT passwordLength, passwordUppercase,"
                                                    + " passwordLowercase, passwordNumbers, "
                                                    + " passwordSpecialCharacters FROM SETTINGS");
            resultSet.next();
            this.length = resultSet.getInt("passwordLength");
            this.uppercase = resultSet.getBoolean("passwordUppercase");
            this.lowercase = resultSet.getBoolean("passwordLowercase");
            this.numbers = resultSet.getBoolean("passwordNumbers");
            this.specialCharacters = resultSet.getBoolean("passwordSpecialCharacters");
            resultSet.close();
            statement.close();
            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    /**
     * Generates a random secure password.
     * @return String
     */
    public String generateRandomSecurePassword(){
        String characters = getPasswordCharacters(uppercase, lowercase, numbers, specialCharacters);
        StringBuilder generatedPassword = new StringBuilder();
        Random rnd = new Random();
        while(generatedPassword.toString().length() < length){
            int next = rnd.nextInt(characters.length());
            generatedPassword.append(String.valueOf(characters.charAt(next)));
        }
        return generatedPassword.toString();
    }
    
    /**
     * Returns the password characters set based on settings.
     * @param upper Boolean (uppercase)
     * @param lower Boolean (lowercase)
     * @param numbers Boolean (numbers)
     * @param special Boolean (special characters)
     * @return String
     */
    private String getPasswordCharacters(boolean upper, boolean lower, boolean numbers, boolean special){
        StringBuilder sb = new StringBuilder();
        
        if(upper)
            sb.append(UPPERCASE);
        if(lower)
            sb.append(LOWERCASE);
        if(numbers)
            sb.append(NUMBERS);
        if(special)
            sb.append(SPECIAL_CHARACTERS);
        
        return sb.toString();
    }
}
