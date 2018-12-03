import java.io.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.Calendar;
public class JavaDemo{
 
        public static void main(String[] args)
        {
        Scanner sc = new Scanner(System.in);
        String com1 = sc.next()charAt(0);
        String com2 = sc.next()chatAt(0);
        getMySqlConnection();
         switch(com1){
          case: "list":
                getAllRecords();
                break;
          case: "insert"
                InsertSql(com2);
                break;
        }
        }
 
 
 
public static Connection getMySqlConnection() throw SQLException{
 
        Connection conn = null;
        try {
        conn =
               DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaDemo?" +
                                           "user=tomasz&password=dul");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
}
public static void InsertSql{
        Connection conn = null;
        Statement statement = null;
        try {
        conn =
               DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaDemo?" +
                                           "user=tomasz&password=dul");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
 //Calendar calendar = Calendar.getInstance();
 //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime();
//String query = "insert into indo";
statement.conn.createStatement();
String sql = "CREATE DATABASE mysql";
statement.execute(sql);
}
}