import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class PasswordStorage {

    public void storeUserPassword(String service, String username, String plaintextPassword, char[] masterPassword) {

        PasswordModel model = new PasswordModel();

        byte[] salt;
        int iterations;

        salt = KeyDerivationFunction.generateSalt();
        iterations = 150_000;


        byte[] key = KeyDerivationFunction.deriveKey(masterPassword, salt, iterations);

        try {
            // encrypt password
            String encrypted = EncryptDecrypt.encrypt(key, plaintextPassword);
            String[] parts = encrypted.split(":");

            String iv = parts[0];
            String ciphertext = parts[1];

            // store in DB
            Password p = new Password(
                    service,
                    username,
                    salt,
                    iterations,
                    iv,
                    ciphertext
            );

            PasswordModel.insertPassword(p);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String decryptStoredPassword(Password p, char[] masterPassword) {

        byte[] salt = p.getSalt();
        int iterations = p.getIterations();

        byte[] key = KeyDerivationFunction.deriveKey(masterPassword, salt, iterations);

        try {
            return EncryptDecrypt.decrypt(key, p.getIv() + ":" + p.getCiphertext());

        } catch (Exception e) {

            throw new RuntimeException("Invalid master password or corrupted data", e);
        }
    }

    public ArrayList<DecryptedPassword> decryptAll(char[] masterPassword) {
        ArrayList<Password> encrypted = PasswordModel.getAllPasswords();
        ArrayList<DecryptedPassword> decrypted = new ArrayList<>();

        for (Password p : encrypted) {
            String password = decryptStoredPassword(p, masterPassword);

            decrypted.add(new DecryptedPassword(
                    p.getService(),
                    p.getUsername(),
                    password
            ));
        }

        return decrypted;
    }

    public record DecryptedPassword(String service, String username, String password) {}


}
