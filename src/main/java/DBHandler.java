import java.sql.*;
public class DBHandler{
    public static final String DB_NAME = "broker";
    public static final String TABLE_NAME = "users";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/";
    public static final String DB_USER_NAME = "root";
    public static final String DB_PASS_WORD = "";

    public static boolean checkUser(String userName, String passWord){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL+DB_NAME, DB_USER_NAME, DB_PASS_WORD);
            Statement st = con.createStatement();

            String query = "SELECT * FROM "+TABLE_NAME+" WHERE username='"+userName+"' AND password='"+passWord+"';";
            ResultSet rs = st.executeQuery(query);
            try{
                rs.next();
                rs.getString(1);
                return true;
            }
            catch(SQLException se){
                System.out.println("No match found");
            }
        }
        catch(Exception e){
            System.out.println("DB Problem");
            e.printStackTrace();
        }
        return false;
    }
}