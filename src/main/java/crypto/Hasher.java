package crypto;

import utils.Base64Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Class responsible for hashing, uses PBKDF2 for pins and SHA-256 for security answers.
 *
 * @author Tiago Pinho
 */
public class Hasher {
    
    private static final String PIN_ALGORITHM = "PBKDF2WithHmacSHA512",
                                SECURITY_ANSWER_ALGORITHM = "SHA-256";
    
    private static final int ITERATIONS = 10000, KEY_LENGTH = 512;

    /**
     * Salts and hashes a master pin with PBKDF2 (PBKDF2WithHmacSHA512).
     *
     * @param pin  Pin to be hashed.
     * @param salt 32 bytes salt to be used on the hashing process.
     * @return String
     */
    public static String hashPin(String pin, String salt) {
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(PIN_ALGORITHM);
            PBEKeySpec keySpec = new PBEKeySpec(pin.toCharArray(), salt.getBytes(), ITERATIONS, KEY_LENGTH);
            SecretKey key = secretKeyFactory.generateSecret(keySpec);
            byte[] hashedPin = key.getEncoded();

            return Base64Utils.toBase64(hashedPin);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Hashes a security answer using SHA-256.
     *
     * @param securityAnswer Security answer to be hashed.
     * @return String
     */
    public static String hashSecurityAnswer(String securityAnswer) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SECURITY_ANSWER_ALGORITHM);
            messageDigest.update(securityAnswer.getBytes());

            return Base64Utils.toBase64(messageDigest.digest());
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Generates a random salt with 32 bytes.
     *
     * @return String
     */
    public static String generateSalt() {
        return Hasher.generateSecureRandom(32);
    }

    /**
     * Generates random secure (n) bytes.
     *
     * @param bytes Number of bytes.
     * @return String
     */
    public static String generateSecureRandom(int bytes) {
        SecureRandom random = new SecureRandom();
        byte[] secureBytes = new byte[bytes];
        random.nextBytes(secureBytes);

        return Base64Utils.toBase64(secureBytes);
    }

}
