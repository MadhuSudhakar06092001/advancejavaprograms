package com.sathya.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ProductDao {
		public int CreateTable() {
			
	    	
	    	int val = 0;
			try(Connection connection = Dbconnectio.createConnection();
					Statement preparedstatement=connection.createStatement()) {
				val=preparedstatement.executeUpdate("create table Product (id number,name varchar2(15),price number(7,2))");
	    		 
	    	 }
	    	 catch(ClassNotFoundException | SQLException e) {
	    		 e.printStackTrace();
	    	 }
			return val;
		}
		
	
	  public int save(Product product) {
	    	Connection connection=null;
	    	PreparedStatement preparedstatement=null;
	    	int val = 0;
			try {
				connection = Dbconnectio.createConnection();
			
	    	 preparedstatement=connection.prepareStatement("insert into Product values(?,?,?)");
	    	
	    	preparedstatement.setInt(1, product.getId());
	    	preparedstatement.setString(2, product.getName());
	    	preparedstatement.setDouble(3, product.getPrice());
	        val=preparedstatement.executeUpdate();  
	        
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return val;
	    }
	    //select query 
	   public Product findbyId(int id) {
	    	
	    	Product e=null;
	    	int val = 0;
			try(Connection connection = Dbconnectio.createConnection();
					PreparedStatement preparedstatement=connection.prepareStatement("select * from product where id=?")) {
				
	    	
	    	preparedstatement.setInt(1, id);
	    	
	       ResultSet set=preparedstatement.executeQuery();
	       
			
				if(set.next()) {
					e =new Product();
					   e.setId(set.getInt(1));
					   e.setName( set.getString(2));
					   e.setPrice(set.getDouble(3));
					   
				   }
			
		
	    	   
	        
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    
	    return e;
	    }
	    //delete by id 
	   public int deletebyId(int i) {
	    	int count=0;
	    	try(Connection connection = Dbconnectio.createConnection();
					PreparedStatement preparedstatement=connection.prepareStatement("delete from Product where id=?")){
	    		preparedstatement.setInt(1, i);
	    		count=preparedstatement.executeUpdate();
	    		
	    		
	    	}
	    	catch(Exception e3) {
	    		e3.printStackTrace();
	    	}
	    	return count;
	    }
	    //delete by salary
	    public int deletebyPrice(double d) {
	    	int count=0;
	    	try(Connection connection = Dbconnectio.createConnection();
					PreparedStatement preparedstatement=connection.prepareStatement("delete from employe where price>?")){
	    		preparedstatement.setDouble(1, d);
	    		count=preparedstatement.executeUpdate();
	    		
	    		
	    	}
	    	catch(Exception e3) {
	    		e3.printStackTrace();
	    	}
	    	return count;
	    
	    }
		public List<Product> findAll() throws ClassNotFoundException {
			// TODO Auto-generated method stub
			List<Product> l=new ArrayList<Product>();
			try(Connection connection = Dbconnectio.createConnection();
					Statement statement=connection.createStatement())
			{
				 ResultSet r = statement.executeQuery("select * from Product");
				 while(r.next()) {
					 Product e1=new Product();
					 e1.setId(r.getInt(1));
					 e1.setName(r.getString(2));
					 e1.setPrice(r.getDouble(3));
					 l.add(e1);
				 }
				 
				 
			}
			catch(SQLException e5) {
				e5.printStackTrace();
			}
			return l;
		}
		public int updatebyPrice(double current,double incsalary) {
	    	int count=0;
	    	try(Connection connection = Dbconnectio.createConnection();
					PreparedStatement preparedstatement=connection.prepareStatement("update Product set price=price-? where price>?")){
	    		preparedstatement.setDouble(1, incsalary);
	    		preparedstatement.setDouble(2, current);
	    		count=preparedstatement.executeUpdate();
	    	}
	    	catch(Exception e3) {
	    		e3.printStackTrace();
	    	}
	    	return count;
		}
	

}
