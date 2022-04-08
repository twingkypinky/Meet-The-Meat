import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectToDatabase {
    public static Connection AdminConnection(){
    Connection conn = null;
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp","root","password");
        if(conn!=null){
            System.out.println("successfull connect");
        }
    } catch (Exception e) {
        //TODO: handle exception
        System.out.println("not connected");
    }
    return conn;
}
}