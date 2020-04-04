package Experiment1;

import java.sql.*;
/**
 * Insert
 */
public class Insert {

    private static String sql = null;
    private static PreparedStatement pstmt;
    //private static ResultSet rs;

    public static void personInfo(int id, String name, boolean member, int board) throws SQLException {
        sql = "insert into customer(id, name, member, board) values(?,?,?,?);";
        pstmt = Main.conn.prepareStatement(sql);
        
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setBoolean(3, member);
        pstmt.setInt(4, board);
        int judge = pstmt.executeUpdate();
        if (judge > 0) {
            Main.conn.commit();
        }
        else{
            Main.conn.rollback();
        }
        //Select.customerInfo();
    }

    public static void order(int seq, Date date, int board) throws SQLException {
        sql = "insert into ord(seq, date, board) values(?,?,?);";
        pstmt = Main.conn.prepareStatement(sql);

        pstmt.setInt(1, seq);
        pstmt.setDate(2, date);
        pstmt.setInt(3, board);

        int judge = pstmt.executeUpdate();
        if (judge > 0) {
            Main.conn.commit();
        }
        else{
            Main.conn.rollback();
        }
    }

    public static void menu(int seq, String course) throws SQLException {
        sql = "insert into menu(order_seq, courses) values(?,?);";
        pstmt = Main.conn.prepareStatement(sql);

        pstmt.setInt(1, seq);
        pstmt.setString(2, course);

        int judge = pstmt.executeUpdate();
        if (judge > 0) {
            Main.conn.commit();
        }
        else{
            Main.conn.rollback();
        }
    }
}