package com.Sathya.Servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductUtils {
	 public static Connection createConnection() throws ClassNotFoundException, SQLException {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","sudhakar");
		  return connection;
	  }
}
