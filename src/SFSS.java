import java.sql.*;
import java.util.*;
public class SFSS {
    public static void main(String[] args) {
    	Scanner s=new Scanner(System.in);
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        System.out.print("Name");
        String student1=s.nextLine();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.
                    getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
                    "System", "manu");
            Statement  stmt=con.createStatement();
            stmt= con.createStatement();
            stmt.executeUpdate("CREATE TABLE student1 (dates varchar(10), LastName varchar(10))");
            System.out.println("Table is created Successfully");
            
            System.out.print("Record Inserted");
        } catch (Exception e) {
            System.out.println("Problem");
            e.printStackTrace();
        }
    }
}
