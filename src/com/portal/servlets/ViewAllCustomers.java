package com.portal.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portal.daos.CustomerDao;
import com.portal.daosimpl.CustomerDaoImpl;
import com.portal.models.Customer;


@WebServlet("/viewAllCustomers")
public class ViewAllCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		CustomerDao custDao=new CustomerDaoImpl();
		List<Customer> cList=custDao.getAllCustomers();
			
		
		HttpSession session=request.getSession();
		Customer c=(Customer)session.getAttribute("custObj");
		
		out.println("<div align='right'>");
		out.println("Welcome : "+c.getCustomerName()+"</div><hr/>");
		out.println("<div align='center'>");
		
		out.println("<table border='1'>");
		out.println("<tr><th>Customer Name : </th><th>Gender</th><th>Email</th><th>City</th></tr>");
		
		for(Customer cObj:cList) {
			out.println("<tr><td>"+cObj.getCustomerName()+" </td><td>"+cObj.getGender()+"</td><td>"+cObj.getEmail()+"</td><td>"+cObj.getCity()+"</td></tr>");
		}
		
		out.println("</table>");
		out.println("</div>");
		
		
	}

}
