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

@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String proid=request.getParameter("productId");
		String proName=request.getParameter("productName");
		double proPrice=Double.parseDouble(request.getParameter("productPrice"));
		String proBrand=request.getParameter("productBrand");
		String proMadeIn=request.getParameter("productMadeIn");
		Date Mfgdate=Date.valueOf(request.getParameter("productMfgDate"));
		Date Expdate=Date.valueOf(request.getParameter("productExpDate"));
		Part part=request.getPart("productImage");
		InputStream inputStream=part.getInputStream();
		
		
		byte[] proimage=IOUtils.toByteArray(inputStream);
		
		Product p=new Product();
		int a = 0;
		p.setProid(proid);
		p.setProName(proName);
		p.setProPrice(proPrice);
		p.setProBrand(proBrand);
		p.setProMadeIn(proMadeIn);
		p.setProMfgDate(Mfgdate);
		p.setProExpDate(Expdate);
		p.setProductImage(proimage);
		ProductDao dao=new ProductDao();
		try {
			a=dao.save(p);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writer=response.getWriter(); 
	
		if(a==1) {
			request.setAttribute("result", a);
			RequestDispatcher dispatcher=request.getRequestDispatcher("ProductList.jsp");
			dispatcher.forward(request, response);
		}
		
		else {
			writer.println("data is not inserted check once");
			response.setContentType("text/html");
			RequestDispatcher dispatcher=request.getRequestDispatcher("AddProduct.html");
			dispatcher.include(request, response);
		}
		
	}

}
