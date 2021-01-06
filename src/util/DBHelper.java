package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static Connection con = null;
    //数据库的url地址;useUnicode=true&characterEncoding=utf-8解决数据库中文乱码问题
    //时区问题过一段时间就需要设置，具体原因未知
    private static String url = "jdbc:mysql://localhost:3306/student?"
            + "&useSSL=true&characterEncoding=utf-8&serverTimezone=GMT";
    //驱动的完整包名
    private static String driver = "com.mysql.cj.jdbc.Driver";
    //数据库的用户名
    private static String user = "root";
    //数据库的用户名密码
    private static String password = "123456";

    static{
        try{
            Class.forName(driver); //加载JDBC-MySQL驱动
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            //获取数据库连接
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //构造方法私有化，确保不会被其他类访问
    private DBHelper(){

    }

    //只对外提供这一个方法，确保单例，同时封装性更好
    //用于返回connection
    public static Connection getConnect(){
        return con;
    }

    //关闭数据库连接
    public static void closeConnect(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
