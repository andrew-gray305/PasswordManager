import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptDecrypt {

    private static final int ivSize = 12; // size of init vector
    private static final int tagBits = 128; // Auth tag size

    public static String encrypt(byte[] key, String password) throws Exception {
        // generate random IV to prevent duplicate ciphertext
        byte[] iv = new byte[ivSize];
        new SecureRandom().nextBytes(iv);

        //convert key into an AES object
        SecretKey aesKey = new SecretKeySpec(key, "AES");

        //get AES cipher instance
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

        //tell cipher to encrypt, use the aesKey, and use the iv and a 128 bit auth tag
        cipher.init(Cipher.ENCRYPT_MODE, aesKey, new GCMParameterSpec(tagBits, iv));

        //encrypt the password
        byte[] ciphertext = cipher.doFinal(password.getBytes("UTF-8"));

        // convert iv and ciper text to string, append together and return
        return Base64.getEncoder().encodeToString(iv) + ":" + Base64.getEncoder().encodeToString(ciphertext);

    }

    public static String decrypt(byte[] key, String data) throws Exception {
        //splits the iv and ciphertext on :
        String[] parts = data.split(":");

        //separates iv and ciphertext, decodes them back to raw bytes
        byte[] iv = Base64.getDecoder().decode(parts[0]);
        byte[] ciphertext = Base64.getDecoder().decode(parts[1]);

        SecretKey aesKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

        //decrypt mode
        cipher.init(Cipher.DECRYPT_MODE, aesKey, new GCMParameterSpec(tagBits, iv));

        //decrypt ciphertext
        byte[] password = cipher.doFinal(ciphertext);

        //return password
        return new String(password, "UTF-8");
    }
}
