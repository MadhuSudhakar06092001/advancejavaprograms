package jdbcApp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
  public static Connection createConnection() throws ClassNotFoundException, SQLException {
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","sudhakar");
	  return connection;
  }
}
