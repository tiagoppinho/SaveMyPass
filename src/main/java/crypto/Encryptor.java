package crypto;

import handlers.DatabaseHandler;
import utils.Base64Utils;

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
import java.util.Objects;
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

    private String encryptedKeyString;
    private String salt;

    private final SecretKeySpec key;

    private final String KEY_ALGORITHM = "AES",
                         ENCRYPTION_ALGORITHM = "AES/CBC/PKCS5Padding",
                         SECRET_KEY_FACTORY_ALGORITHM = "PBKDF2WithHmacSHA256";

    private final int ITERATIONS = 10000, KEY_SIZE = 128;

    public Encryptor(String locker){
        load();
        this.key = generateKey(locker);
    }

    /**
     * Encrypts a string using AES-128.
     * @param string String to encrypt.
     * @return String - encrypted String.
     */
    public String encrypt(String string) {
        return this.encrypt(string, this.key);
    }

    /**
     * Decrypts an AES-128 encrypted string.
     *
     * @param encryptedString Encrypted string to decrypt.
     * @return String - decrypted string.
     */
    public String decrypt(String encryptedString){
        return this.decrypt(encryptedString, this.key);
    }

    /**
     * Encrypts a string using AES-128 using a custom key.
     *
     * @param string String to encrypt.
     * @param key Custom key.
     * @return String - encrypted string.
     */
    private String encrypt(String string, SecretKeySpec key) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] iv = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV(),
                    encryptedString = cipher.doFinal(string.getBytes());

            outputStream.write(iv);
            outputStream.write(encryptedString);

            return Base64Utils.toBase64(outputStream.toByteArray());
        } catch (IOException | InvalidKeyException | InvalidParameterSpecException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    /**
     * Decrypts an AES-128 encrypted string using a custom key.
     *
     * @param encryptedString Encrypted string to decrypt.
     * @param key Custom key.
     * @return String - decrypted string.
     */
    private String decrypt(String encryptedString, SecretKeySpec key){
        try{
            byte[] decodedString = Base64Utils.fromBase64(encryptedString),
                    iv = Arrays.copyOfRange(decodedString, 0, 16),
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
     * Custom encryption to use only on first time and when re-encrypting the uKey using a new locker.
     * This only happens on the {@link app.Setup} and {@link app.NewPin} classes.
     * <br>
     * <strong>Otherwise</strong>, this method should <strong>NOT</strong> be used.
     * Instead, always use an instance of {@link Encryptor} with the methods available.
     *
     * @param string string to encrypt.
     * @param key custom key.
     * @return Encrypted string as base64.
     */
    public static String customEncrypt(String string, SecretKeySpec key) {
        return new Encryptor("").encrypt(string, key);
    }

    /**
     * Custom key generation to use only on first time and when re-encrypting the uKey using a new locker.
     * This only happens on the {@link app.Setup} and {@link app.NewPin} classes.
     * <br>
     * <strong>Otherwise</strong>, this method should <strong>NOT</strong> be used.
     * Instead, always use an instance of {@link Encryptor} with the methods available.
     *
     * @param locker key locker.
     * @param salt key locker salt.
     * @return SecretKeySpec - Generated Key.
     */
    public static SecretKeySpec generateCustomKey(String locker, String salt) {
        return new Encryptor("").generateKey(locker, salt);
    }

    /**
     * Generates the encryption/decryption secret key.
     *
     * @param locker - key locker.
     * @return SecretKeySpec - Generated key.
     */
    private SecretKeySpec generateKey(String locker) {
        SecretKeySpec uKeyLockerKey = this.generateKey(locker, this.salt);
        String decryptedKeyString = decrypt(encryptedKeyString, uKeyLockerKey);

        return generateKeyFromString(decryptedKeyString);
    }

    /**
     * Generates a SecretKeySpec based on locker (pin) and uKeySalt.
     *
     * @return SecretKeySpec - Generated key.
     */
    private SecretKeySpec generateKey(String locker, String salt) {
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
     * Generates a SecretKeySpec from a base64 key string.
     *
     * @param keyString Base64 key string.
     * @return SecretKeySpec - Generated key.
     */
    private SecretKeySpec generateKeyFromString(String keyString) {
        return new SecretKeySpec(Base64Utils.fromBase64(Objects.requireNonNull(keyString)), KEY_ALGORITHM);
    }

    /**
     * Loads the encryptedKeyString and salt from database.
     * This is needed to generate the key.
     */
    private void load() {
        Connection connection = DatabaseHandler.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT uKey, uKeySalt FROM User");

            resultSet.next();
            this.encryptedKeyString = resultSet.getString("uKey");
            this.salt = resultSet.getString("uKeySalt");

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
