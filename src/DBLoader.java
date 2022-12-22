import java.sql.*;

public class DBLoader {
    static Connection con;
    static ResultSet rs;
    static PreparedStatement ststement;
    
    public static ResultSet executeStatement(String sqlquery) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded successfully");
        if(con == null){
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrhelpdesk", "root", "Root@1234#");
            System.out.println("connection built");
        }
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        System.out.println("statement created");
        
        ResultSet rs = stmt.executeQuery(sqlquery);
        System.out.println("ResultSet created");
        
        return rs;
        
    }
}
