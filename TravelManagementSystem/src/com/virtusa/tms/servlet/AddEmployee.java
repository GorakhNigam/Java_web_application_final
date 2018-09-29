package com.virtusa.tms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.tms.beans.Employee;
import com.virtusa.tms.dao.EmployeeDao;

/**
 * Servlet implementation class AddEmployee
 */
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");		
//		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String employeeName = request.getParameter("employeeName");
		String emailId = request.getParameter("emailId");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String travelPurpose = request.getParameter("travelPurpose");
		String travelMode = request.getParameter("travelMode");
		int duration = Integer.parseInt(request.getParameter("duration"));
//		Date dateFrom = request.getParameter("dateFrom");
//		String dateTo = request.getParameter("dateTo");
		String status = "Pending";

		Employee emp = new Employee(employeeName,emailId,source,destination,travelPurpose,travelMode,duration,status);
		EmployeeDao dao = new EmployeeDao();
		int row = dao.addEmployee(emp);
		Employee empl = new Employee(row,employeeName,emailId,source,destination,travelPurpose,travelMode,duration,status);
		System.out.println("int row = dao.addEmployee(emp)");
		if(row > 0)
			out.println("Inserted");
		else
			out.println("Not Inserted");
		request.setAttribute("empls", empl);
		RequestDispatcher rd = request.getRequestDispatcher("AdminView.jsp");		
		rd.forward(request, response);
		System.out.println("Admin View dispatched");
	}
}
