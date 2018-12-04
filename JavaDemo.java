import java.io.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.Calendar;
public class JavaDemo{
 
public static void main(String[] args)
    {
        System.out.println("Wpisz dod aby dodać do bazy lub dis aby wyświetlić");
        String com = in.nextLine();
            switch(com){
            case "dis":
                getAllRecords();
                break;
            case "dod":
                InsertSql(com2);
                break;
    }
}
 
 
 
    public static Connection getMySqlConnection() throw SQLException{
            Connection conn = null;
            try {
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaDemo?" +
                                            "user=tomasz&password=dul");
            } catch (SQLException ex) {
            }
    }
    public static void getAllRecords() throws SQLException {
        Connection conn = getMySqlConnection();
        String query1 = "SELECT * FROM table;";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.println(
                "Tytul:" + rs.getString("tytul") + 
                "Tresc:" + rs.getString("tresc") + 
                "Autor:" + rs.getString("autor")
            );
        }
    }
    public static void executeInsertSql(String[] parts) throws SQLException {
        Connection conn = getMySqlConnection();
        PreparedStatement preparedStatement = conn.prepareStatement();
        System.out.print("Tytul: ");
        String tytul = in.nextLine();
        System.out.print("Tresc: ");
        String tresc = in.nextLine();
        System.out.print("Autor: ");
        String autor = in.nextLine();
        String query2 = "INSERT INTO table VALUES('"+tytul+"', '"+tresc+"', '"+autor+"');";
        preparedStatement.executeUpdate(query);
    }
}
