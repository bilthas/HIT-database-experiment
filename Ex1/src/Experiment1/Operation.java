package Experiment1;

import java.sql.*;

/**
 * Operation
 */
public class Operation {

    public static void mainfunction() throws SQLException {
        boolean flag = true;
        while (flag) {
            Info.mainfunction();
            int ch = Main.scanner.nextInt();
            Main.scanner.nextLine();
            try {
                switch (ch) {
                    case 1:
                        Select.boardInfo();
                        break;
                    case 2:
                        System.out.println("请依次输入您的ID,名字,会员情况,桌号");
                        System.out.print("ID:");
                        int id = Main.scanner.nextInt();
                        Main.scanner.nextLine();
                        System.out.print("姓名：");
                        String name = Main.scanner.nextLine();
                        System.out.print("是否为会员true/false:");
                        boolean member = Main.scanner.nextBoolean();
                        Main.scanner.nextLine();
                        System.out.print("桌号:");
                        int board = Main.scanner.nextInt();
                        Main.scanner.nextLine();

                        Insert.personInfo(id,name,member,board);
                        Main.conn.commit();
                        break;
                    case 3:
                        Operation.order();
                        break;
                    case 4:
                        Operation.hotel();
                        break;
                    case 0:
                        System.out.println("欢迎下次光临");
                        flag = false;
                        break;
                }
            } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                System.err.println("ERROR:主键/外键约束");
            }
        }
    }

    public static void order() throws SQLException {
        boolean flag = true;
        while (flag) {
            Info.order();
            int ch = Main.scanner.nextInt();
            Main.scanner.nextLine();
            switch (ch) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    selectCourses();
                    break;
                case 3:
                    selectCook();
                    break;
                case 4:
                    addMenu();
                    break;
                case 5:
                    System.out.println("输入您需要撤销的点单信息");
                    System.out.print("单号：");
                    int seq = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    System.out.print("需要撤掉的菜：");
                    String course = Main.scanner.nextLine();

                    Drop.dropMenu(seq, course);
                    Main.conn.commit();
                    break;
                case 6:
                    generateBill();
                    break;
                case 7:
                    System.out.print("请输入您要删除的订单号:");
                    int order = Main.scanner.nextInt();
                    Main.scanner.nextLine();

                    Drop.dropOrder(order);
                    Main.conn.commit();
                    break;
                case 0:
                    flag = false;
                    System.out.println("返回成功");
                    break;
            }
        }
    }

    public static void hotel() throws SQLException {
        boolean flag = true;
        while (flag) {
            Info.hotel();
            int ch = Main.scanner.nextInt();
            Main.scanner.nextLine();
            switch (ch) {
                case 1:
                    Select.hotelManager();
                    break;
                case 2:
                    Select.hotelSupplier();
                    break;
                case 3:
                    Select.staff();
                    break;
                case 4:
                    Select.hotelAvgSalary();
                    break;
                case 0:
                    flag = false;
                    System.out.println("返回成功");
                    break;
            }
        }
    }


    public static void addOrder() throws SQLException {
        System.out.println("新建订单号：单号，日期，桌号");
        System.out.print("单号：");
        int seq = Main.scanner.nextInt();
        Main.scanner.nextLine();
        System.out.print("日期：");
        String date = Main.scanner.nextLine();
        System.out.print("桌号：");
        int board_id = Main.scanner.nextInt();
        Main.scanner.nextLine();
        Insert.order(seq, Date.valueOf(date), board_id);
        Main.conn.commit();
    }

    public static void addMenu() throws SQLException {
        System.out.println("点单");
        System.out.print("您的单号：");
        int seq = Main.scanner.nextInt();
        Main.scanner.nextLine();
        System.out.print("选则的菜：");
        String course = Main.scanner.nextLine();
        if (course.equals("")) {
            System.out.println("WARNING:存在空值");
            return;
        }

        Insert.menu(seq, course);
        Main.conn.commit();
    }

    public static void selectCourses() throws SQLException {
        int low = 0;
        int high = 1000;
        System.out.println("选择价格区间(也可以不填)");
        System.out.print("最低价格：");
        String l = Main.scanner.nextLine();
        System.out.print("最高价格：");
        String h = Main.scanner.nextLine();
        if (!l.equals(""))
            low = Integer.valueOf(l).intValue();
        if (!h.equals(""))
            high = Integer.valueOf(h).intValue();
        Select.courses(low, high);
    }

    //嵌套查询
    public static void selectCook() throws SQLException {
        System.out.print("你想查询哪道菜的厨师：");
        String course = Main.scanner.nextLine();
        if (course==null) {
            System.out.println("Warning:存在空值");
        }
        Select.cook(course);
    }

    //连接查询
    public static void generateBill() throws SQLException {
        System.out.print("输入您的订单号：");
        int seq = Main.scanner.nextInt();
        Main.scanner.nextLine();
        Select.bill(seq);
    }
}