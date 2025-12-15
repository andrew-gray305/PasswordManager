import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class PasswordModel {

    private static Connection connection;


    static {
        try {
            connection = DatabaseConnection.getConnection();
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public static void createTableIfNotExist(){

        String cmdCreate = """
                CREATE TABLE IF NOT EXISTS passwords(
                   id INTEGER PRIMARY KEY AUTOINCREMENT,
                   service TEXT NOT NULL,
                   username TEXT NOT NULL,
                   salt TEXT NOT NULL,
                   iterations INTEGER NOT NULL,
                   iv TEXT NOT NULL,
                   ciphertext TEXT NOT NULL,
                   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
              
                )
                """;


        try(Statement statement = connection.createStatement()) {


            statement.executeUpdate(cmdCreate);

            System.out.println("Table created or already existed");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } ;

    }

    public static void insertPassword(Password p){


        String cmdInsert = "INSERT INTO passwords (service, username, salt, iterations, iv, ciphertext, created_at) VALUES(?,?,?,?,?,?,CURRENT_TIMESTAMP)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(cmdInsert)) {

            p.prepareInsertStatement(preparedStatement);

            preparedStatement.executeUpdate();

            System.out.println("inserted password");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Password> getAllPasswords(){
        ArrayList<Password> passwords = new ArrayList<>();

        String cmdSelect = "SELECT * FROM passwords";

        try(Statement statement = connection.createStatement()){

            ResultSet rs = statement.executeQuery(cmdSelect);

            while(rs.next()){

                Password p = new Password(
                        rs.getInt("id"),
                        rs.getString("service"),
                        rs.getString("username"),
                        rs.getString("salt"),
                        rs.getInt("iterations"),
                        rs.getString("iv"),
                        rs.getString("ciphertext")
                );
                passwords.add(p);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return passwords;
    }

    public int getRowCount() {
        String cmdNum = "SELECT COUNT(*) FROM passwords";

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(cmdNum)) {

            return rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}