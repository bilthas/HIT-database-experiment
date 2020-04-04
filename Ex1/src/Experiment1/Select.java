package Experiment1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Select
 */
public class Select {

    private static String sql = null;
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    public static void boardInfo() throws SQLException {
        System.out.println("--------------------------");
        sql = "select * from board;";
        pstmt = Main.conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        //System.out.println("桌号\t位置\t容量(人)");
        while (rs.next()) {
            System.out.print(rs.getInt(1)+"\t");
            System.out.print(rs.getString(2)+"\t");
            System.out.println(rs.getInt(3));
        }
        System.out.println("--------------------------");
    }

    //普通查询
    public static void courses(int low, int high) throws SQLException {
        System.out.println("--------------------------");
        sql = "select * from courses where price>? and price<? order by price;";
        pstmt = Main.conn.prepareStatement(sql);

        pstmt.setInt(1, low);
        pstmt.setInt(2, high);
        rs = pstmt.executeQuery();
        //System.out.println("菜名\t价格\t类别");
        while (rs.next()) {
            System.out.print(rs.getString(1)+"\t");
            System.out.print(rs.getInt(2)+"\t");
            System.out.println(rs.getString(3));
        }
        System.out.println("--------------------------");
    }

    //嵌套查询
    public static void cook(String course) throws SQLException {
        System.out.println("--------------------------");
        sql = "select name\n" +
                "from staff\n" +
                "where id in(\n" +
                "\tselect staff\n" +
                "\tfrom cook\n" +
                "\twhere courses=?\n" +
                ");";
        pstmt = Main.conn.prepareStatement(sql);

        pstmt.setString(1, course);
        rs = pstmt.executeQuery();
        //System.out.print("掌勺厨师：");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1));
        }
        System.out.println("--------------------------");
    }

    //连接查询
    public static void bill(int seq) throws SQLException {
        System.out.println("-------------------------------------");
        sql = "select ord.*, courses.name, courses.price\n" +
                "from ord, courses, menu\n" +
                "where ord.seq=menu.order_seq and courses.name=menu.courses and ord.seq=?;";
        pstmt = Main.conn.prepareStatement(sql);
        pstmt.setInt(1, seq);
        rs = pstmt.executeQuery();
        //System.out.println("单号\t日期\t\t桌号\t点菜\t价格");
        while (rs.next()) {
            System.out.print(rs.getInt(1)+"\t");
            System.out.print(rs.getDate(2)+"\t");
            System.out.print(rs.getInt(3)+"\t");
            System.out.print(rs.getString(4)+"\t");
            System.out.println(rs.getInt(5));
        }
        System.out.println("-------------------------------------");
    }

    public static void hotelManager() throws SQLException {
        System.out.println("-------------------------------------");
        sql = "SELECT * FROM hotelandmanager;";
        pstmt = Main.conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        //System.out.println("酒店\t地址\t电话\t营业额\t经理");
        while (rs.next()) {
            System.out.print(rs.getInt(1)+"\t");
            System.out.print(rs.getString(2)+"\t");
            System.out.print(rs.getInt(3)+"\t");
            System.out.print(rs.getInt(4)+"\t");
            System.out.println(rs.getString(5));
        }
        System.out.println("-------------------------------------");
    }

    public static void hotelSupplier() throws SQLException {
        System.out.println("-------------------------------------");
        sql = "SELECT * FROM hotelandsupplier;";
        pstmt = Main.conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        //System.out.println("提供商\t\t酒店\t供给量\t地址\t营业额");
        while (rs.next()) {
            System.out.print(rs.getString(1)+"\t");
            System.out.print(rs.getInt(2)+"\t");
            System.out.print(rs.getInt(3)+"\t");
            System.out.print(rs.getString(4)+"\t");
            System.out.println(rs.getInt(5));
        }
        System.out.println("-------------------------------------");
    }
    
    public static void staff() throws SQLException {
        System.out.println("-------------------------------------");
        sql = "SELECT * FROM staffview;";
        pstmt = Main.conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        //System.out.println("编号\t姓名\t性别\t工资\t隶属\t经理");
        while (rs.next()) {
            System.out.print(rs.getInt(1)+"\t");
            System.out.print(rs.getString(2)+"\t");
            System.out.print(rs.getString(3)+"\t");
            System.out.print(rs.getInt(4)+"\t");
            System.out.print(rs.getInt(5)+"\t");
            System.out.println(rs.getInt(6));
        }
        System.out.println("-------------------------------------");
    }

    //分组查询：某酒店员工的平均工资
    public static void hotelAvgSalary() throws SQLException {
        System.out.println("--------------------------");
        sql = "select hotel, avg(salary)\n" + 
                "from staff\n" +
                "group by hotel having count(hotel)>1;";
        pstmt = Main.conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        //System.out.println("酒店\t平均工资");
        while (rs.next()) {
            System.out.print(rs.getInt(1)+"\t");
            System.out.println(rs.getDouble(2));
        }
        System.out.println("--------------------------");
    }
}