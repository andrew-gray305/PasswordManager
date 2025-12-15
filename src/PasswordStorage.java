import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class PasswordStorage {

    public void storeUserPassword(String service, String username, String plaintextPassword, char[] masterPassword) {

        PasswordModel model = new PasswordModel();

        byte[] salt = KeyDerivationFunction.generateSalt();

        int iterations;


        String saltb64 = Base64.getEncoder().encodeToString(salt);
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
                    saltb64,
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

        byte[] salt = Base64.getDecoder().decode(p.getSalt());;
        int iterations = p.getIterations();

        byte[] key = KeyDerivationFunction.deriveKey(masterPassword, salt, iterations);

        try {
            return EncryptDecrypt.decrypt(key, p.getIv() + ":" + p.getCiphertext());

        } catch (Exception e) {

            throw new RuntimeException("Invalid master password or corrupted data", e);
        }
    }

    public ArrayList<DecryptedPassword> decryptAll(char[] masterPassword, String search) {
        ArrayList<Password> encrypted;
        if(search != null){
            encrypted = PasswordModel.getAllPasswordsSearch(search);

        }else{
            encrypted = PasswordModel.getAllPasswords();

        }
        ArrayList<DecryptedPassword> decrypted = new ArrayList<>();

        for (Password p : encrypted) {
            try {

                String password = decryptStoredPassword(p, masterPassword);
                decrypted.add(new DecryptedPassword(p.getService(), p.getUsername(), password));

            } catch (RuntimeException e) {

                decrypted.add(new DecryptedPassword("[DECRYPT FAILED: wrong master or corrupted row]",
                        "[DECRYPT FAILED: wrong master or corrupted row]",
                        "[DECRYPT FAILED: wrong master or corrupted row]"
                ));

            }
        }


        return decrypted;
    }

    public record DecryptedPassword(String service, String username, String password) {

        @Override
        public String toString() {

            return "Service:" + service + "\nUsername: " + username + "\nPassword: " + password + "\n------------------------\n";

        }
    }


}
