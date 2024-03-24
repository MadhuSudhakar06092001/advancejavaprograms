package com.Sathya.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proId=request.getParameter("proid");
		
		ProductDao dao=new ProductDao();
		Product Existingproduct=null;
		try {
			 Existingproduct=dao.findById(proId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("product", Existingproduct);
	RequestDispatcher dispatcher=request.getRequestDispatcher("Edit.jsp");
	dispatcher.forward(request, response);
//		response.setContentType("text/plain");
//		PrintWriter writer=response.getWriter();
//		writer.println(Existingproduct.getProid());
//		writer.println(Existingproduct.getProBrand());
//		writer.println(Existingproduct.getProName());
		
		
		
	}

	

}
