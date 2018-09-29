package com.virtusa.tms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.tms.dao.EmployeeDao;

/**
 * Servlet implementation class Logistics
 */
public class Logistics extends HttpServlet {
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
		double travelExpense = Double.parseDouble(request.getParameter("travelExpense"));
		int serialNo = Integer.parseInt(request.getParameter("serialNo"));
		EmployeeDao dao = new EmployeeDao();
		System.out.println(travelExpense+" "+serialNo);
		dao.updateExpense(travelExpense, serialNo);
		out.println("Expense Updated");
	}

}
