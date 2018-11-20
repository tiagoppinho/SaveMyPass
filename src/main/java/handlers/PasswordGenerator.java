package handlers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * Class responsible for generating random secure passwords according to the user settings.
 *
 * @author Tiago Pinho
 */
public class PasswordGenerator {

    //Characters
    private final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", LOWERCASE = "abcdefghijklmnopqrstuvwxyz", NUMBERS =
            "0123456789", SPECIAL_CHARACTERS = "#$%&/!=.,[]{}-+*;<>()@:_?^~\\\'\"";

    //Settings
    private int length;
    private boolean uppercase, lowercase, numbers, specialCharacters;

    public PasswordGenerator() {
        loadSettings();
    }

    /**
     * Generates a random secure password.
     *
     * @return String
     */
    public String generateRandomSecurePassword() {
        String characters = getPasswordCharacters();
        StringBuilder generatedPassword = new StringBuilder();
        Random rnd = new Random();
        while (generatedPassword.toString().length() < length) {
            int next = rnd.nextInt(characters.length());
            generatedPassword.append(String.valueOf(characters.charAt(next)));
        }
        return generatedPassword.toString();
    }

    /**
     * Returns the password characters set based on settings.
     *
     * @return String containing all characters.
     */
    private String getPasswordCharacters() {
        StringBuilder sb = new StringBuilder();

        if (uppercase)
            sb.append(UPPERCASE);
        if (lowercase)
            sb.append(LOWERCASE);
        if (numbers)
            sb.append(NUMBERS);
        if (specialCharacters)
            sb.append(SPECIAL_CHARACTERS);

        return sb.toString();
    }

    /**
     * Loads all the settings from database needed to generate a random secure password.
     */
    private void loadSettings() {
        Connection connection = DatabaseHandler.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT passwordLength, passwordUppercase," + " passwordLowercase, passwordNumbers, "
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
