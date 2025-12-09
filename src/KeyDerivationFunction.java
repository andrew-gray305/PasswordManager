import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

public class KeyDerivationFunction {

    // generate random salt
    public static byte[] generateSalt(){
        byte[] salt = new  byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }


    public static byte[] deriveKey(char [] masterPassword, byte[] salt, int iterations){
        try{
            // creates a password based encryption spec
            KeySpec spec = new PBEKeySpec(masterPassword, salt, iterations, 256);

            //fetches cryptography engine that can perform PBKDF2 (Password based key derivation function 2)
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            //Returns the generated key, which is in raw bytes
            return factory.generateSecret(spec).getEncoded();

        } catch (Exception e) {
            throw new RuntimeException("Key derivation failed", e);
        }

    }
}
