package com.sathya.Callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Collabeeexample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","madhu","sudhakar");
		CallableStatement statement=connection.prepareCall("{Call getSalary(?,?,?,?) }");
		statement.setInt(1, 1);
		statement.registerOutParameter(2, Types.INTEGER);
		statement.registerOutParameter(3, Types.VARCHAR);
		statement.registerOutParameter(4, Types.FLOAT);
		statement.executeUpdate();
		System.out.println(statement.getInt(2));
		System.out.println(statement.getDouble(4));
		System.out.println(statement.getString(3));
		
		
		
	}

}
