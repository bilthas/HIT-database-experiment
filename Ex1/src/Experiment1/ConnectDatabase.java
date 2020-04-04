package Experiment1;
import java.sql.*;
/**
 * ConnectDatabase
 */
public class ConnectDatabase {

    public static Connection getConnection(Connection conn){

        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost:3306/experiment1?useSSL=false&serverTimezone=UTC";

        String USER = "root";
        String PASS = "zdm20160318ZDM";

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("|-Connected-|");
        return conn;
    }
}