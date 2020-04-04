package Experiment1;

/**
 * Info
 */
public class Info {

    public static void mainfunction(){
        System.out.println("-------------------------------");
        System.out.println("|请选择服务：");
        System.out.println("|1.查询餐桌信息(普通查询)");   //普通查询
        System.out.println("|2.录入个人信息(插入数据)");   //插入操作：主键约束，外键约束
        System.out.println("|3.点单");
        System.out.println("|4.查看酒店相关信息");
        System.out.println("|0.退出");
        System.out.println("-------------------------------");
    }

    public static void order(){
        System.out.println("-------------------------------");
        System.out.println("点单：");
        System.out.println("1.新建点单号信息");              //插入操作
        System.out.println("2.查看菜品(条件查询)");                   //单表查询：构造动态sql，order by price
        System.out.println("3.查看有关菜品的厨师信息(嵌套查询)");      //嵌套查询
        System.out.println("4.点单(空值约束)");                      //插入操作：空值约束
        System.out.println("5.撤销点单(删除操作)");                  //删除操作
        System.out.println("6.生成账单(连接查询)");                  //连接查询
        System.out.println("7.删除点单号信息");
        System.out.println("0.返回");
        System.out.println("-------------------------------");
    }

    public static void hotel(){
        System.out.println("-------------------------------");
        System.out.println("酒店相关信息：");
        System.out.println("1.(视图)酒店及经理信息");             //常用查询：建立视图
        System.out.println("2.(视图)酒店相关食材提供商");         //常用查询：建立视图
        System.out.println("3.(视图)员工");                      //常用查询：建立视图
        System.out.println("4.(分组)按酒店查询员工薪资水平");      //分组查询
        System.out.println("0.返回");
        System.out.println("-------------------------------");
    }
}