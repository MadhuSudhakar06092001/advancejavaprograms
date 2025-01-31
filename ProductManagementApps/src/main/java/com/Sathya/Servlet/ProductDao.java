package com.Sathya.Servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductDao {
	public int save(Product p) throws ClassNotFoundException, SQLException {
		 Connection connection=ProductUtils.createConnection();
		 PreparedStatement preparestatement=connection.prepareStatement
				 ("insert into Products(pid,pname,pprice,pbrand,pmadein,pmfgdate,pexpdate,pimage) values(?,?,?,?,?,?,?,?)");
				 		
		preparestatement.setString(1, p.getProid());
		preparestatement.setString(2, p.getProName());
		preparestatement.setDouble(3, p.getProPrice());
		preparestatement.setString(4, p.getProBrand());
		preparestatement.setString(5, p.getProMadeIn());
		preparestatement.setDate(6, p.getProMfgDate());
		preparestatement.setDate(7, p.getProExpDate());
		preparestatement.setBytes(8, p.getProductImage());
		int val=preparestatement.executeUpdate();
		return val;
	}
	public List<Product> findAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Product> l=new ArrayList<Product>();
		 Connection connection=ProductUtils.createConnection();
		 Statement statement=connection.createStatement();
			 ResultSet r = statement.executeQuery("select * from Products");
			 while(r.next()) {
				 Product e1 = new Product();
				 e1.setProid(r.getString(1));
				 e1.setProName(r.getString(2));
				 e1.setProPrice(r.getDouble(3));
				 e1.setProBrand(r.getString(4));
				 e1.setProMadeIn(r.getString(5));
				 e1.setProMfgDate(r.getDate(6));
				 e1.setProExpDate(r.getDate(7));
				 e1.setProductImage(r.getBytes(8));
				 l.add(e1);
			 }
			 
			 return l; 
		}
	public int  deleteById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Connection connection=ProductUtils.createConnection();
		 PreparedStatement preparestatement=connection.prepareStatement
				 ("delete from Products where pid=?");
		 preparestatement.setInt(1, id);
		 int value=preparestatement.executeUpdate();
		 return value;
				 		
	}
	public Product findById(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ProductUtils.createConnection();
		 PreparedStatement preparestatement=connection.prepareStatement
				 ("select * from Products where pid=?");
		 preparestatement.setString(1, id);
		 Product p=null;
		ResultSet set= preparestatement.executeQuery();
		if(set.next()) {
			 p=new Product();
			p.setProid(set.getString(1));
			p.setProName(set.getString(2));
			p.setProPrice(set.getDouble(3));
			p.setProBrand(set.getString(4));
			p.setProMadeIn(set.getString(5));
			p.setProMfgDate(set.getDate(6));
			p.setProExpDate(set.getDate(7));
			p.setProductImage(set.getBytes(8));
			
			
		}
		return p;
	}
	public int updateById(Product p) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ProductUtils.createConnection();
		 PreparedStatement preparestatement=connection.prepareStatement
				 ("update Products set pname=?,pprice=?,pbrand=?,pmadein=?,pmfgdate=?,pexpdate=?,pimage=? where pid=?");
		preparestatement.setString(1, p.getProName());
		preparestatement.setDouble(2, p.getProPrice());
		preparestatement.setString(3, p.getProBrand());
		preparestatement.setString(4, p.getProMadeIn());
		preparestatement.setDate(5, p.getProMfgDate());
		preparestatement.setDate(6, p.getProExpDate());
		preparestatement.setBytes(7, p.getProductImage());
		preparestatement.setString(8, p.getProid());
		int val=preparestatement.executeUpdate();
		
		
		return val;
	}
		
		
	
}
