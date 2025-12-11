import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Password {

    private String service;
    private String username;
    private String salt;
    private int iterations;
    private String iv;
    private String ciphertext;

    public String getService(){
        return service;
    }
    public String getUsername(){
        return username;
    }
    public String getSalt(){
        return salt;
    }
    public int getIterations(){
        return iterations;
    }
    public String getIv(){
        return iv;
    }
    public String getCiphertext(){
        return ciphertext;
    }

    public Password(String service, String username, String salt, int iterations, String iv, String ciphertext) {

        this.service = service;
        this.username = username;
        this.salt = salt;
        this.iterations = iterations;
        this.iv = iv;
        this.ciphertext = ciphertext;
    }

    public void prepareInsertStatement(PreparedStatement ps) throws SQLException {
        ps.setString(1, service);
        ps.setString(2, username);
        ps.setString(3, salt);
        ps.setInt(4, iterations);
        ps.setString(5, iv);
        ps.setString(6, ciphertext);
    }


}
