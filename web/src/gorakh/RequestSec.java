package gorakh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestSec
 */
@WebServlet("/RequestSec")
public class RequestSec extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String id = request.getParameter("id");
		long mobile = Long.parseLong("mobile");
		String address = request.getParameter("Adress");
		String skills[] = request.getParameterValues("skills");
		out.println("Name : "+firstname+" "+lastname);
	}

}
