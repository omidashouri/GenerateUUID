package ir.omidashouri;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class GenerateUUID {

    public static final String Digest_SHA_256 = "SHA-256";
    public static final char[] hexArray = "0123456789ABCDEFGHIJKLMOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        System.out.println(generateUniquePublicId());
    }

    public static String generateUniquePublicId() {
        String uniquePublicUserId = null;
        try {
            uniquePublicUserId = generateUniqueKeysWithUUIDAndMessageDigest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return uniquePublicUserId;
    }

    public static String generateUniqueKeysWithUUIDAndMessageDigest() throws NoSuchAlgorithmException {
        MessageDigest salt = MessageDigest.getInstance(Digest_SHA_256);
        salt.update(UUID.randomUUID()
                .toString()
                .getBytes(StandardCharsets.UTF_8));
        return bytesToHex(salt.digest());
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
