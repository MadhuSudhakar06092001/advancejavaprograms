package com.Sathya.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("proid"));
		ProductDao productDao=new ProductDao();
		int val=0;
		try {
			 val=productDao.deleteById(id);
		} catch (ClassNotFoundException |SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		
		if(val==1) {
			request.setAttribute("val", val);
			RequestDispatcher dispatcher=request.getRequestDispatcher("ProductList.jsp");
			dispatcher.forward(request, response);
			
		}
		

	

}
}
