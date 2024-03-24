package jdbcApp2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDao {
    public int save(Product emp) {
    	Connection connection=null;
    	PreparedStatement preparedstatement=null;
    	int val = 0;
		try {
			connection = Dbconnection.createConnection();
		
    	 preparedstatement=connection.prepareStatement("insert into Employe values(?,?,?)");
    	
    	preparedstatement.setInt(1, emp.getId());
    	preparedstatement.setString(2, emp.getName());
    	preparedstatement.setDouble(3, emp.getSalary());
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
		try(Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedstatement=connection.prepareStatement("select * from employe where id=?")) {
			
    	
    	preparedstatement.setInt(1, id);
    	
       ResultSet set=preparedstatement.executeQuery();
       
		
			if(set.next()) {
				e =new Product();
				   e.setId(set.getInt(1));
				   e.setName( set.getString(2));
				   e.setSalary(set.getDouble(3));
				   
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
    	try(Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedstatement=connection.prepareStatement("delete from employe where id=?")){
    		preparedstatement.setInt(1, i);
    		count=preparedstatement.executeUpdate();
    		
    		
    	}
    	catch(Exception e3) {
    		e3.printStackTrace();
    	}
    	return count;
    }
    //delete by salary
    public int deletebySal(double d) {
    	int count=0;
    	try(Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedstatement=connection.prepareStatement("delete from employe where salary>?")){
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
		try(Connection connection = Dbconnection.createConnection();
				Statement statement=connection.createStatement())
		{
			 ResultSet r = statement.executeQuery("select * from employe");
			 while(r.next()) {
				 Product e1=new Product();
				 e1.setId(r.getInt(1));
				 e1.setName(r.getString(2));
				 e1.setSalary(r.getDouble(3));
				 l.add(e1);
			 }
			 
			 
		}
		catch(SQLException e5) {
			e5.printStackTrace();
		}
		return l;
	}
	public int updatebySalary(double current,double incsalary) {
    	int count=0;
    	try(Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedstatement=connection.prepareStatement("update employe set salary=salary+? where salary<?")){
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
