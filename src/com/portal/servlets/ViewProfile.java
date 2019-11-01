package com.portal.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.jrockit.jfr.RequestDelegate;
import com.portal.daos.CustomerDao;
import com.portal.daosimpl.CustomerDaoImpl;
import com.portal.models.Customer;


@WebServlet("/viewProfile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		Customer c=(Customer)session.getAttribute("custObj");
		
		out.println("<div align='right'>");
		out.println("Welcome : "+c.getCustomerName()+"</div><hr/>");
		out.println("<div align='center'>");
		out.println("<table>");
		out.println("<tr><td>Customer Name : </td><td>"+c.getCustomerName()+"</td></tr>");
		out.println("<tr><td>Customer Gender : </td><td>"+c.getGender()+"</td></tr>");
		out.println("<tr><td>Customer Email : </td><td>"+c.getEmail()+"</td></tr>");
		out.println("<tr><td>Customer City : </td><td>"+c.getCity()+"</td></tr>");
		out.println("</table>");
		out.println("</div>");
		
		
	}

}
