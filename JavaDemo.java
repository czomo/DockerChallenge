import java.sql.*;

public class JavaDemo {
   public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://10.0.10.3:3306/mydb?autoReconnect=true&useSSL=false", "tdul", "dul");

            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS myTable" +
                    " (tytul VARCHAR(30)," +
                    " tresc VARCHAR(30)," +
                    " autor VARCHAR(30))";
            stmt.executeUpdate(sql);
        	System.out.println("podlaczono do bazy");
            if(args.length > 0) {
                if(args[0].equals("dis")) {
                  ResultSat();
                }
                else if(args[0].equals("dod")) {
                    PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO myTable VALUES (?,?,?)");
                    preparedStatement.setString(1, args[1]);
                    preparedStatement.setString(2, args[2]);
                    preparedStatement.setString(3, args[3]);
                    preparedStatement.executeUpdate();
                }
                else
                    System.out.println("brak danych ");
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally{
            try{
                if(stmt != null)
                    conn.close();
            } catch (SQLException e) { }
            try{
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
public static void ResultSat(){
                       PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM myTable");
                    ResultSet res = preparedStatement.executeQuery();
                    while(res.next()) {
                        System.out.println("" +
                                "\ntytul " + res.getString("tytul") +
                                "\n   tresc " + res.getString("tresc") +
                                "\n   autor " + res.getString("autor"));
                    }
}
}
