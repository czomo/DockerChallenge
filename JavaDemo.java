import java.sql.*;
import java.util.Scanner;

public class JavaDemo{
 
public static void main(String[] args)
    {
        Connection conn = null;
        Statement statement;
         try {
             Class.forName("com.mysql.jdbc.Driver");
             conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?" +
                                        "user=tomasz&password=dul");
        String st = "CREATE TABLE IF NOT EXISTS table (tytul VARCHAR(30), tresc VARCHAR(100), autor VARCHAR(30));";
        statement = conn.createStatement();
        statement.executeUpdate(st);
         } catch (SQLException e) {
            System.out.println("Error connection");
        }
        Scanner in = new Scanner(System.in);
        while(true){
        System.out.println("Wpisz dod aby dodać do bazy lub dis aby wyświetlić");
        String com = in.nextLine();
            switch(com){
            case "dis":
                try{
                    statement = conn.createStatement();
                    String query1 = "SELECT * FROM table;";
                    ResultSet result = statement.executeQuery(query1);
                    while (result.next()) {
                        System.out.println(
                            "Tytul:" + result.getString("tytul") + 
                            "Tresc:" + result.getString("tresc") + 
                            "Autor:" + result.getString("autor")
                        );
                    }
               }catch (SQLException ex){
                    System.out.println("Error insert");
               }                break;
            case "dod":
               try{
                    statement = conn.createStatement();
                    System.out.print("Tytul: ");
                    String tytul = in.nextLine();
                    System.out.print("Tresc: ");
                    String tresc = in.nextLine();
                    System.out.print("Autor: ");
                    String autor = in.nextLine();
                    String query2 = "INSERT INTO table VALUES('"+tytul+"', '"+tresc+"', '"+autor+"');";
                    statement.executeUpdate(query2);
               }catch (SQLException ex){
                    System.out.println("Error insert");
               }
               break;
    }
        }
}
}
