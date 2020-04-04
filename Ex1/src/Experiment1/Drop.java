package Experiment1;

import java.sql.*;

/**
 * Drop
 */
public class Drop {

    private static String sql = null;
    private static PreparedStatement pstmt;

    public static void dropOrder(int seq) throws SQLException {
        sql = "delete from menu where order_seq=?;";
        pstmt = Main.conn.prepareStatement(sql);
        pstmt.setInt(1, seq);
        int judge = pstmt.executeUpdate();
        if (judge > 0) {
            Main.conn.commit();
        } else {
            Main.conn.rollback();
        }
        sql = "delete from ord where seq=?;";
        pstmt = Main.conn.prepareStatement(sql);
        pstmt.setInt(1, seq);
        judge = pstmt.executeUpdate();
        if (judge > 0) {
            Main.conn.commit();
        } else {
            Main.conn.rollback();
        }
    }

    public static void dropMenu(int seq, String courseName) throws SQLException {
        sql = "delete from menu where order_seq=? and courses=?;";
        pstmt = Main.conn.prepareStatement(sql);
        pstmt.setInt(1, seq);
        pstmt.setString(2, courseName);
        int judge = pstmt.executeUpdate();
        if (judge > 0) {
            Main.conn.commit();
        } else {
            Main.conn.rollback();
        }
    }
}