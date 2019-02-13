package utils;

import java.util.Base64;

/**
 * Base64 utils.
 *
 * @author Tiago Pinho
 */
public class Base64Utils {

    private static final Base64.Decoder DECODER = Base64.getDecoder();

    private static final Base64.Encoder ENCODER = Base64.getEncoder();

    /**
     * Decodes a base64 string.
     *
     * @param string - base64 string.
     * @return byte[] - decoded base64 string.
     */
    public static byte[] fromBase64(String string) {
        return DECODER.decode(string);
    }

    /**
     * Encodes bytes to base64 string.
     *
     * @param bytes - byte array.
     * @return String - encoded bytes as bas64 string.
     */
    public static String toBase64(byte[] bytes) {
        return ENCODER.encodeToString(bytes);
    }

}
