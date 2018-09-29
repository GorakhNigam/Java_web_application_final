package com.virtusa.tms.appls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.tms.dao.EmployeeLoginDao;

/**
 * Servlet implementation class EmpLoginAppl
 */
@WebServlet("/EmpLoginAppl")
public class EmpLoginAppl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("EmployeeLogin");
		EmployeeLoginDao dao = new EmployeeLoginDao();
		
		String pass = dao.getPass(username);
		if(pass.equals(password)) {
//			request.setAttribute("empls", empl);
			RequestDispatcher rd = request.getRequestDispatcher("EmpPage.jsp");		
			rd.forward(request, response);
		}
		else {
			out.println("Username or Password Incorrect");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");		
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
