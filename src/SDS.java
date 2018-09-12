
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
 * Servlet implementation class SDS
 */
@WebServlet("/SDS")
public class SDS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SDS() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String guardian = request.getParameter("guardian");
		String phone = request.getParameter("phone");
		String section = request.getParameter("section");
		String branch = request.getParameter("branch");
		String address = request.getParameter("address");
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.
                    getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
                    "System", "manu");
            
            String str="Insert into studentdata values(?,?,?,?,?,?,?)";
            ps=con.prepareStatement(str);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, guardian);
            ps.setString(4, phone);
            ps.setString(5, section);
            ps.setString(6, branch);
            ps.setString(7, address);
            ps.executeUpdate();
          
            
            String str1="Insert into studentattendance values(?,?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(str1);
            ps.setString(1, section);
            ps.setString(2, id);
            ps.setString(3, id);
            ps.setString(4, id);
            ps.setString(5, id);
            ps.setString(6, id);
            ps.setString(7, id);
            ps.setString(8, id);
            ps.setString(9, id);
            ps.setString(10, id);
            ps.executeUpdate();
            
            String str2="Insert into studentpassword values(?,?)";
            ps=con.prepareStatement(str2);
            ps.setString(1, id);
            ps.setString(2, phone);
            ps.executeUpdate();
          
           
        } catch (Exception e) {
            out.print("Sorry, Same Id Try Different Id");
            request.getRequestDispatcher("page8.html").include(request, response);
            e.printStackTrace();
        }
	}

}
