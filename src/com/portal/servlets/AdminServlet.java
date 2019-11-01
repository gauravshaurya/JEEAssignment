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


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		Customer c=(Customer)session.getAttribute("custObj");
		
		out.println("<div align='right'>");
		out.println("Welcome : "+c.getCustomerName()+"</div><hr/>");
		out.println("<div align='center'>");
		out.println("Welcome Admin<br/>");
		out.println("<a href='viewAllCustomers'>View All Customers</a><br/>");
		out.println("<a href='viewProfile'>View Profile</a><br/>");
		out.println("<a href='#'>Change Password</a><br/>");
		out.println("</div>");
		
		
	}

}
