package com.sathya.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcEx1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("driver is loaded");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","madhu","sudhakar");
        System.out.println("jdbc connected");
        String q="create table Employe(id number,name varchar2(34),salary number(7,3))";
        
        Statement statement= con.createStatement();
        int result=statement.executeUpdate(q);
        System.out.println(result);
        con.close();
        
        
	}


}
