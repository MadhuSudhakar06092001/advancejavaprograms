package com.sathya.table;

import java.util.List;

public class Productclient {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		ProductDao dao=new ProductDao();
		//System.out.println("number of tables created"+	dao.CreateTable());
		//int a=dao.save(new Product(1,"fridge",2354.54));
		//System.out.println("no of rows inserted"+" "+a);
		//int b=dao.save(new Product(2,"tv",500.54));
		//System.out.println("no of rows inserted"+" "+b);
		//int c=dao.save(new Product(3,"washing mach",233.54));
		//System.out.println("no of rows inserted"+" "+c);
		//Product d=dao.findbyId(2);
		//System.out.print(d);
		//int d=dao.deletebyId(1);
		//System.out.println(d);
		//List<Product> e=dao.findAll();
		//e.forEach(System.out::println);
		//System.out.println(e);
		int f=dao.updatebyPrice(100.00,100.00);
		System.out.println(f);
		
		
		
	}

}
