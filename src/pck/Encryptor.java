package pck;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Class responsible for encryption/decryption using AES-256.
 * @author Tiago Pinho
 */
public class Encryptor {
    
    private String keyLocker, salt;
    
    private IvParameterSpec initializationVector;
    
    private final SecretKeySpec key;
        
    private final String KEY_ALGORITHM = "AES",
                         ENCRYPTION_ALGORITHM = "AES/CBC/PKCS5Padding",
                         SECRET_KEY_FACTORY_ALGORITHM = "PBKDF2WithHmacSHA512";
    
    private final int ITERATIONS = 10000, KEY_SIZE = 128;    
    
    public Encryptor(){
        load();
        this.key = generateKey();
    }
    
    /**
     * Encrypts a string using AES-256.
     * @param string String to encrypt.
     * @return String
     */
    public String encrypt(String string){
        try{
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedString = cipher.doFinal(string.getBytes());
            return Base64.getEncoder().encodeToString(encryptedString);
        }catch(InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException ex){
            System.out.println(ex.toString());
        }
        return null;
    }
    
    /**
     * Decrypts an AES-256 encrypted string.
     * @param encryptedString Encrypted string to decrypt.
     * @return String
     */
    public String decrypt(String encryptedString){
        try{
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key, initializationVector);
            byte[] decryptedString = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
            return Base64.getEncoder().encodeToString(decryptedString);
        }catch(InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException ex){
            System.out.println(ex.toString());
        }
        return null;
    }
    
    /**
     * Generates the SecretKeySpec based on key locker and salt.
     * @return SecretKeySpec
     */
    private SecretKeySpec generateKey(){
        try{
            SecretKeyFactory skf = SecretKeyFactory.getInstance(SECRET_KEY_FACTORY_ALGORITHM);
            PBEKeySpec spec = new PBEKeySpec(keyLocker.toCharArray(), salt.getBytes(),
                                             ITERATIONS, KEY_SIZE);
            SecretKey secretKey = skf.generateSecret(spec);
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
        }catch(NoSuchAlgorithmException | InvalidKeySpecException ex){
            System.out.println(ex.toString());
        }
        return null;
    }
    
    /**
     * Loads the data neeeded for encryption/decryption.
     */
    private void load(){
        Connection connection = DatabaseHandler.getConnection();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Locker");
            resultSet.next();
            this.keyLocker = resultSet.getString("locker");
            this.salt = resultSet.getString("salt");
            this.initializationVector = new IvParameterSpec(Base64.getDecoder().decode(resultSet.getString("iv")));
            resultSet.close();
            statement.close();
            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
