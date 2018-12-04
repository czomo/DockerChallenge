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
                getRecords();
                break;
            case "dod":
                InsertSql(com2);
                break;
    }
}
 
 
 
    public static Connection getMySqlConnection() throws SQLException{
            Connection conn = null;
            try {
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaDemo?" +
                                            "user=tomasz&password=dul");
            } catch (SQLException ex) {
                System.out.println("Error connection");
            }
    }
    public static void getRecords() throws SQLException {
        Connection conn = getMySqlConnection();
        String query1 = "SELECT * FROM table;";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            System.out.println(
                "Tytul:" + result.getString("tytul") + 
                "Tresc:" + result.getString("tresc") + 
                "Autor:" + result.getString("autor")
            );
        }
    }
    public static void insertSql(String[] parts) throws SQLException {
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
