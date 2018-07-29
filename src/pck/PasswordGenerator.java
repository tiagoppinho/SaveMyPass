package pck;

import java.util.Random;

/**
 * Class responsible for generating random secure passwords according to the user needs.
 * @author Tiago Pinho
 */
public class PasswordGenerator {
    
    private final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private final String NUMBERS = "0123456789";
    private final String SPECIAL_CHARACTERS = "#$%&/!=.,";
    
    private boolean hasUppercase = false;
    private boolean hasLowerCase = false;
    private boolean hasNumbers = false;
    private boolean hasSpecialCharacters = false;

    public PasswordGenerator() {
        resetBooleans();
    }
    
    /**
     * Generates a random secure password.
     * @param size Password size.
     * @return String
     */
    public String generateRandomPassword(int size/*, boolean[] check*/){
        String fullChars = UPPERCASE + LOWERCASE + NUMBERS + SPECIAL_CHARACTERS;
        String generatedPassword = "";
        Random rnd = new Random();
        while(!hasUppercase || !hasLowerCase || !hasNumbers || !hasSpecialCharacters){
            generatedPassword = "";
            resetBooleans();
            for(int i = 0; i < size; i++){
                int next = rnd.nextInt(fullChars.length());
                //uppercase
                if(next < 26)
                    hasUppercase = true;
                //lowercase
                else if(next < 52)
                    hasLowerCase = true;
                //numbers
                else if(next < 62)
                    hasNumbers = true;
                //special characters
                else
                    hasSpecialCharacters = true;
                
                generatedPassword += String.valueOf(fullChars.charAt(next));
            }
        }
        return generatedPassword;
    }
    
    private void resetBooleans(){
        hasUppercase = false;
        hasLowerCase = false;
        hasNumbers = false;
        hasSpecialCharacters = false;
    }
}
