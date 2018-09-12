
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
@WebServlet("/SNS")
public class SNS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SNS() {
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
        ResultSet rs1=null;
        int c=0;
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String Id = request.getParameter("Id");
		String Notices = request.getParameter("notices");
		 try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            con=DriverManager.
	                    getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "manu");
	            
	            Statement  stmt=con.createStatement();
	            rs=stmt.executeQuery("SELECT * FROM studentdata");
	            while(rs.next()) {
	                if(Id.equals(rs.getString("id"))) {
	                	    String str="Delete from studentnotices  where id=?";
			                ps=con.prepareStatement(str);
			                ps.setString(1, Id);
	                        ps.executeUpdate();
		            String str1="Insert into studentnotices values(?,?)";
	                ps=con.prepareStatement(str1);
	                ps.setString(1, Id);
	                ps.setString(2, Notices);
	                c= ps.executeUpdate();
	                out.print("Notice Sent");}
	               
	                
	                }

	         request.getRequestDispatcher("page16.html").include(request, response);
	        } catch (Exception e) {
	            out.print("Server Error:-Go Back");
	           
	            e.printStackTrace();
	        }
	}

}
