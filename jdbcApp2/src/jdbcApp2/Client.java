package jdbcApp2;

import java.sql.SQLException;
import java.util.List;

public class Client {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DatabaseDao d=new DatabaseDao();
         int res=d.save(new Product(1,"madhu",677.65));
        int res1=d.save(new Product(2,"kumar",566.67));
        int res4=d.save(new Product(2,"kumar",566.67));
        int res5=d.save(new Product(2,"kumar",566.67));
        /* System.out.println("inseerted successfulley"+res+" "+res1);
        Employee e= d.findbyId(2);
        System.out.println(e+"retrieved data");
        int res2=d.deletebyId(2);
        if(res2!=0)
        	System.out.println(res2+"delete by id");*/
        List<Product> emps=d.findAll();
        emps.forEach(System.out::println);
       int res6= d.updatebySalary(5000,20000);
       System.out.println(res6);
        
        /*int res3=d.deletebySal(100.00);
        if(res3!=0)System.out.println(res3);*/
	}

}
