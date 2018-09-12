
import java.sql.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * Servlet implementation class changepasswordparentServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class changepasswordparent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepasswordparent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String password = request.getParameter("phone");
		String newpassword = request.getParameter("newpassword");
		 try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            con=DriverManager.
	                    getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "manu");
	            Statement  stmt=con.createStatement();
	            rs=stmt.executeQuery("SELECT * FROM parentpassword");
	            int count = 0;
	            while(rs.next()) {
	                if(id.equals(rs.getString("id"))&&password.equals(rs.getString("password"))) {
	                	String str="Delete from parentpassword  where id=?";
		                ps=con.prepareStatement(str);
		                ps.setString(1, id);
		                ps.executeUpdate();
		                String str1="Insert into parentpassword values(?,?)";
		                ps=con.prepareStatement(str1);
		                ps.setString(1, id);
		                ps.setString(2, newpassword);
		                ps.executeUpdate();
		                count++;
		            out.print("Password Changed");
		            request.getRequestDispatcher("page9.html").include(request, response);}
	            }
	            if(count==0) {
	            	out.println("ID: "+id+" or Password: "+password+ " Is Incorrect or Student Is Not Registered");	
	            request.getRequestDispatcher("page9.html").include(request, response);
	            } }
	            catch (Exception e) {
		            out.print("Server Error");
		            e.printStackTrace();
		        }
		
	}

}
