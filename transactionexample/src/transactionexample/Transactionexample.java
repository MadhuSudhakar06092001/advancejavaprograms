package transactionexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transactionexample {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","sudhakar");
		Statement statement=connection.createStatement();
		connection.setAutoCommit(false);
		statement.executeUpdate("delete from product where id=1");
		statement.executeUpdate("insert intoo product values(1,'fridge',455.00)");
		connection.commit();
		System.out.println("success");
		}
		catch(ClassNotFoundException |SQLException e) {
			System.out.println("fail");
			e.printStackTrace();
		}
	}

}
