package handlers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class responsible for handling database connections and retrieve them.
 *
 * @author Tiago Pinho
 */
public class DatabaseHandler {

    private static final String CONNECTION_PATH_FORMAT = "jdbc:sqlite:%s";
    private static final String CONNECTION_PATH;

    static {
        Path homeDirPath = Paths.get(System.getProperty("user.home")).resolve(".passwordmanager-savemypass.sqlite");
        CONNECTION_PATH = String.format(CONNECTION_PATH_FORMAT, homeDirPath.toAbsolutePath().toString());
    }

    /**
     * Gets the database connection and returns it.
     *
     * @return Connection
     */
    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(CONNECTION_PATH);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Initializes database in case tables are missing.
     * This operation does NOT close the database connection.
     *
     * @return Integer Number of tables in database.
     */
    public static int getTablesCount() {
        Connection connection = DatabaseHandler.getConnection();
        int tableCount = 0;
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT count(*) FROM sqlite_master WHERE type = 'table' AND name != 'android_metadata' AND name != 'sqlite_sequence';");

            tableCount = resultSet.getInt(1);

            statement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tableCount;
    }
}
