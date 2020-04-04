package Experiment1;

import java.sql.*;
import java.util.Scanner;

import static Experiment1.Operation.mainfunction;

/**
 * Main
 */
public class Main {

    public static Connection conn = null;
    public static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) throws SQLException{
        conn = ConnectDatabase.getConnection(conn);
        conn.setAutoCommit(false);  //自动提交设置为false
        mainfunction();
    }
}