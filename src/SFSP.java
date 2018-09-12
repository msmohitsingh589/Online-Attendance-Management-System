import java.sql.*;
import java.util.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SFSP
 */
@WebServlet("/SFSP")
public class SFSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SFSP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		 Connection con=null;
	        PreparedStatement ps=null;
	        ResultSet rs=null;
	        response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String Id = request.getParameter("id");
	        try {
	        	 out.println("<html>");
	        	 out.println("<TITLE>");
	        	 out.println("FEEDBACK");
	        	 out.println("</TITLE>");
	        	 out.println("<head>");
	        	 out.println("<h3>"+"FEEDBACK"+"</h3>");
	        	 out.println("</head>");
	        	 out.println("<body>");
	        	 out.println("<hr>");
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            con=DriverManager.
	                    getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "manu");
	          Statement  stmt=con.createStatement();
	                rs=stmt.executeQuery("SELECT * FROM studentfeedback");
	                while(rs.next()) {
	                	if(Id.equals(rs.getString("id"))) {
	                out.println(rs.getString("id")+":- "+rs.getString("feedback")+"  ");}
	                }
	                out.println("</body>");
               	    out.println("</html>");
	        } catch (Exception e) {
	            out.print("Server Error:-Go Back");
	            e.printStackTrace();
	        }
	}

}
