package pck;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

/**
 * Class responsible for hashing, uses PBKDF2 for passwords and SHA-256 for security answers.
 * @author Tiago Pinho
 */
public class Hasher {
    
    private static final String PASSWORD_ALGORITHM = "PBKDF2WithHmacSHA512",
                                STRING_ALGORITHM = "SHA-256";
    private static final int ITERATIONS = 10000,
                             KEY_LENGTH = 512;
    
    /**
     * Salts and hashes a master pin with PBKDF2 (PBKDF2WithHmacSHA512).
     * @param pin Pin to be hashed.
     * @param salt 32 bytes salt to be used on the hashing process.
     * @return String
     */
    public static String hashPin(String pin, String salt){
        char[] passwordChars = pin.toCharArray();
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(PASSWORD_ALGORITHM);
            PBEKeySpec keySpec = new PBEKeySpec(passwordChars, salt.getBytes(), ITERATIONS, KEY_LENGTH);
            SecretKey key = secretKeyFactory.generateSecret(keySpec);
            byte[] hashedPassword = key.getEncoded();
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    /**
     * Hashes a security answer.
     * @param securityAnswer Security answer to be hashed.
     * @return String
     */
    public static String hashSecurityAnswer(String securityAnswer){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(STRING_ALGORITHM);
            messageDigest.update(securityAnswer.getBytes());
            return Base64.getEncoder().encodeToString(messageDigest.digest());
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }   
    
    /**
     * Generates a random salt with 32 bytes.
     * @return String
     */
    public static String generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }
}
