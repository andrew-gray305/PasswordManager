import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class PasswordModel {

    private static Connection connection;

    public PasswordModel() {
        try {
            this.connection = DatabaseConnection.getConnection();

            System.out.println("Connection Successful");

            createTableIfNotExist();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void createTableIfNotExist(){

        String cmdCreate = """
                CREATE TABLE IF NOT EXISTS password(
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

    public static void insertCustomer(Password p){


        String cmdInsert = "INSERT INTO password (service, username, salt, iterations, iv, ciphertext, created_at) VALUES(?,?,?,?,?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(cmdInsert)) {

            p.prepareInsertStatement(preparedStatement);

            preparedStatement.executeUpdate();

            System.out.println("inserted password");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}