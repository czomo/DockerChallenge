import java.sql.*;
import java.util.Scanner;

public class JavaDemo{
 
public static void main(String[] args)
    {
        Connection conn = null;
         try {
             conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaDemo?" +
                                        "user=tomasz&password=dul");
         } catch (SQLException ex) {
            System.out.println("Error connection");
        }
        System.out.println("Wpisz dod aby dodać do bazy lub dis aby wyświetlić");
        Scanner in = new Scanner(System.in);
        String com = in.nextLine();
            switch(com){
            case "dis":
                getRecords();
                break;
            case "dod":
               try{
                    PreparedStatement preparedStatement = conn.prepareStatement();
                    System.out.print("Tytul: ");
                    String tytul = in.nextLine();
                    System.out.print("Tresc: ");
                    String tresc = in.nextLine();
                    System.out.print("Autor: ");
                    String autor = in.nextLine();
                    String query2 = "INSERT INTO table VALUES('"+tytul+"', '"+tresc+"', '"+autor+"');";
                    preparedStatement.executeUpdate(query2);
               }catch (SQLException ex){
                    System.out.println("Error insert");
               }
               break;
    }
}
    public static void getRecords() throws SQLException {
        String query1 = "SELECT * FROM table;";
        PreparedStatement preparedStatement = conn.prepareStatement(query1);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            System.out.println(
                "Tytul:" + result.getString("tytul") + 
                "Tresc:" + result.getString("tresc") + 
                "Autor:" + result.getString("autor")
            );
        }
    }
}
