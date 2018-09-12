
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
 * Servlet implementation class attendance
 */
@WebServlet("/attendance")
public class attendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public attendance() {
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
		String section = request.getParameter("class");
        try {
        	 
        	 out.println("<html>");
        	 out.println("<TITLE>");
        	 out.println("STUDENTS DATA");
        	 out.println("</TITLE>");
        	 out.println("<head>");
        	 out.println("<h3>"+"STUDENTS DATA"+"</h3>");
        	 out.println("</head>");
        	 out.println("CLASS :-"+section);
        	 out.println("<body>");
        	 out.println("<hr>");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.
                    getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "manu");
                Statement  stmt=con.createStatement();
                rs=stmt.executeQuery("SELECT * FROM studentdata");
                     int SNO=0;
                while(rs.next()) {
                	if(section.equals(rs.getString("section"))) {
                	 SNO++;
                     out.println("<b>"+SNO+"--> "+"</b>"+"<b>"+"ID:- "+"</b>"+"</b>"+rs.getString("ID")+"<b>"+"// "+"NAME:- "+"</b>"+rs.getString("name")+"<b>"+"// "+"GUARDIAN:- "+"</b>"+rs.getString("guardian")+"<b>"+"// "+"CONTACT:- "+"</b>"+rs.getString("phone")+"<b>"+"// "+"BRANCH:- "+"</b>"+rs.getString("branch")+"<b>"+"// "+"ADDRESS:-"+"</b>"+rs.getString("address"));
                     out.println("<hr>");  }
                	 out.println("</body>");
                	 out.println("</html>");
                }
        } catch (Exception e) {
            out.print("Problem");
            e.printStackTrace();
        }
}

	}


