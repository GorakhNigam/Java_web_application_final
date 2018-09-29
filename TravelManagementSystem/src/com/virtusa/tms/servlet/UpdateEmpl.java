package com.virtusa.tms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.tms.beans.Employee;
import com.virtusa.tms.dao.EmployeeDao;

/**
 * Servlet implementation class UpdateEmpl
 */
public class UpdateEmpl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		EmployeeDao dao = new EmployeeDao();
		Employee emp = new Employee();
		String emailId = request.getParameter("emailId");
		emp = dao.getEmpl(emailId);
		request.setAttribute("empls", emp);
		RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		String dateFrom = request.getParameter("dateFrom");
//		String dateTo = request.getParameter("dateTo");
//		String status = request.getParameter("status");
		int duration = Integer.parseInt(request.getParameter("duration"));
		String status = request.getParameter("status");
		
		Employee emp = new Employee(employeeName,emailId,source,destination,travelPurpose,travelMode,duration,status);
		EmployeeDao dao = new EmployeeDao();
		dao.updateAll(emp);
		
		out.println("update servlet executed");
	}

}
