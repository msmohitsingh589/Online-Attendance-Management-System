
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
 * Servlet implementation class SDRS
 */
@WebServlet("/SDRS")
public class SDRS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SDRS() {
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
		String id = request.getParameter("id");
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.
                    getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
                    "System", "manu");
            Statement  stmt=con.createStatement();
            rs=stmt.executeQuery("SELECT * FROM studentdata");
            int a=0;
            while(rs.next()) {
            	if(id.equals(rs.getString("id"))) {
            String str="Delete from studentdata  where id=?";
            ps=con.prepareStatement(str);
            ps.setString(1, id);
            ps.executeUpdate();
            out.print("RECORDS Deleted....");
            String str1="Delete from studentnotices  where id=?";
            ps=con.prepareStatement(str1);
            ps.setString(1, id);
            ps.executeUpdate();
            out.print("NOTICES Deleted....");
            String str2="Delete from studentfeedback  where id=?";
            ps=con.prepareStatement(str2);
            ps.setString(1, id);
            ps.executeUpdate();
            out.print("FEEDBACKS Deleted....");
            String str3="Delete from studentattendance  where id=?";
            ps=con.prepareStatement(str3);
            ps.setString(1, id);
            a=ps.executeUpdate();
            out.print("ATTENDANCE Deleted...");
            String str4="Delete from studentpassword  where id=?";
            ps=con.prepareStatement(str4);
            ps.setString(1, id);
            a=ps.executeUpdate();
            out.print("LOGIN CREDENTIALS Deleted");
            
            	}}
            if(a==0)
            	 out.print("Records Already Deleted");   
            request.getRequestDispatcher("page7.html").include(request, response);
		}
		catch (Exception e) {
            out.print("Sorry, Error To Remove The Member");
            e.printStackTrace();
        }
	}

}
