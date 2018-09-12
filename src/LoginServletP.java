
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServletP")
public class LoginServletP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServletP() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int c=0;
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.
                    getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "manu");
            Statement  stmt=con.createStatement();
            rs=stmt.executeQuery("SELECT * FROM parentpassword");
            while(rs.next()) {
                if(password.equals(rs.getString("password"))&&id.equals(rs.getString("id"))) {
                	out.print("Welcome "+rs.getString("guardian"));
                	request.getRequestDispatcher("page6.html").include(request, response);	
               c++;
                }
		       }
             if(c!=1) {
			out.println("ID: "+id+" or Password: "+password+ " Is Incorrect or Student Is Not Registered");
            request.getRequestDispatcher("Lp.html").include(request, response);}}
		catch (Exception e) {
            out.println("Server Error");
            e.printStackTrace();
        }
        out.close();
	}
}
