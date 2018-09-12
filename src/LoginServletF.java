
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServletF")
public class LoginServletF extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServletF() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if (password.equals("1")&&name.equals("Faculty")) {
			request.getRequestDispatcher("page3.html").include(request, response);
		}
		else {
			out.println("Username: "+name+" or Password: "+password+ " Is Incorrect or Faculty Is Not Registered");
			request.getRequestDispatcher("Lf.html").include(request, response);
		}
        out.close();
	}
}
