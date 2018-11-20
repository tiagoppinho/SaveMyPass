package crypto;

import handlers.DatabaseHandler;
import sun.awt.image.GifImageDecoder;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
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
 * Class responsible for encryption/decryption using AES-128.
 *
 * @author Tiago Pinho
 */
public class Encryptor {

    private String locker, salt;

    private final SecretKeySpec key;

    private final String KEY_ALGORITHM = "AES", ENCRYPTION_ALGORITHM = "AES/CBC/PKCS5Padding", SECRET_KEY_FACTORY_ALGORITHM =
            "PBKDF2WithHmacSHA256";

    private final int ITERATIONS = 10000, KEY_SIZE = 128;

    public Encryptor() {
        load();
        this.key = generateKey();
    }

    /**
     * Encrypts a string using AES-128.
     *
     * @param string String to encrypt.
     * @return String - encrypted string.
     */
    public String encrypt(String string) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] iv = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV(), encryptedString =
                    cipher.doFinal(string.getBytes());

            outputStream.write(iv);
            outputStream.write(encryptedString);

            return Base64.getEncoder().encodeToString(outputStream.toByteArray());
        } catch (IOException | InvalidKeyException | InvalidParameterSpecException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    /**
     * Decrypts an AES-128 encrypted string.
     *
     * @param encryptedString Encrypted string to decrypt.
     * @return String - decrypted string.
     */
    public String decrypt(String encryptedString) {
        try {
            byte[] decodedString = Base64.getDecoder().decode(encryptedString), iv = Arrays.copyOfRange(decodedString, 0, 16),
                    encrypted = Arrays.copyOfRange(decodedString, 16, decodedString.length);

            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));

            return new String(cipher.doFinal(encrypted));
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    /**
     * Generates the SecretKeySpec based on locker and salt.
     *
     * @return SecretKeySpec - Generated key.
     */
    private SecretKeySpec generateKey() {
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(SECRET_KEY_FACTORY_ALGORITHM);
            PBEKeySpec keySpec = new PBEKeySpec(locker.toCharArray(), salt.getBytes(), ITERATIONS, KEY_SIZE);
            SecretKey secretKey = keyFactory.generateSecret(keySpec);
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    /**
     * Loads the data neeeded for encryption/decryption.
     */
    private void load() {
        Connection connection = DatabaseHandler.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Locker");
            resultSet.next();
            this.locker = resultSet.getString("locker");
            this.salt = resultSet.getString("salt");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
