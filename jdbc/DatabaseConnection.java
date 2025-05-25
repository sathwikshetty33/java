import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
 private static final String URL = "jdbc:sqlite:example.db";
 public static Connection getConnection() throws SQLException {
 return DriverManager.getConnection(URL);
 }
}

// javac -cp sqlite-jdbc-3.49.1.0.jar DatabaseConnection.java DatabaseGUI.java 
// java -cp .:sqlite-jdbc-3.49.1.0.jar DatabaseGUI