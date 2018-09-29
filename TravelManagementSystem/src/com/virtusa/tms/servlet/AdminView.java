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
 * Servlet implementation class AdminView
 */
public class AdminView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		int serialNo = Integer.parseInt(request.getParameter("serialNo"));
		String emailId = request.getParameter("emailId");
		String status = request.getParameter("status");
		String employeeName = request.getParameter("employeeName");

		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String travelPurpose = request.getParameter("travelPurpose");
		String travelMode = request.getParameter("travelMode");
		int duration = Integer.parseInt(request.getParameter("duration"));
//		String dateFrom = request.getParameter("dateFrom");
//		String dateTo = request.getParameter("dateTo");

		Employee emp = new Employee(serialNo,employeeName,emailId,source,destination,travelPurpose,travelMode,duration,status);
		EmployeeDao dao = new EmployeeDao();
		dao.updateStatus(status, serialNo);
		if(status.equals("Approved")) {
			RequestDispatcher rd = request.getRequestDispatcher("Logistics.jsp");
			request.setAttribute("empls", emp);
			rd.forward(request, response);
		}
		else {
			out.println("Status not Approved");
		}
	}

}
