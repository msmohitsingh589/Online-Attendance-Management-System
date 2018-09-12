
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
 * Servlet implementation class SFS
 */
@WebServlet("/SFS")
public class SFS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SFS() {
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
		String Feedback = request.getParameter("feedback");
		 try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            con=DriverManager.
	                    getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "manu");
	            Statement  stmt=con.createStatement();
	            rs=stmt.executeQuery("SELECT * FROM studentdata");
	            while(rs.next()) {
	                if(Id.equals(rs.getString("id"))) {
	                String str="Delete from studentfeedback  where id=?";
	                ps=con.prepareStatement(str);
	                ps.setString(1, Id);
	                ps.executeUpdate();
	                
	                String str1="Insert into studentfeedback values(?,?)";
	                ps=con.prepareStatement(str1);
	                ps.setString(1, Id);
	                ps.setString(2, Feedback);
	                
	                ps.executeUpdate();
	                out.print("Feedback Sent");
	                }}
	            
	            
	            request.getRequestDispatcher("page15.html").include(request, response);}
                 catch (Exception e) {
	            out.print("Server Error:-Go Back");
	            e.printStackTrace();
	        }
	}

}
