package com.virtusa.tms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.tms.beans.Employee;
import com.virtusa.tms.dao.EmployeeDao;

/**
 * Servlet implementation class ViewEmployee
 */
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		EmployeeDao dao = new EmployeeDao();
		String emailId = request.getParameter("emailId");

		List<Employee> empList = dao.getAllEmpls(emailId);
		RequestDispatcher rd = request.getRequestDispatcher("ViewEmployee.jsp");
		request.setAttribute("empls", empList);
		rd.forward(request, response);
	}

}
