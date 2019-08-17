package zrm.curd;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
public class Jdbcconnector {
    /**
     * 此次的实例将会展示如何连接到mysql数据库
     */
    public static void main(String[] args) {
        /*驱动加载*/
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*先创建下面连接所需要的对象*/
        Connection connection = null;//创建一个connection用于连接mysql的一个接口
        Statement statement = null;//创建一个statement用于处理sql语句
        ResultSet set = null;//创建的resultset用来处理结果集

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test" +
                    "?user=root&password=123&serverTimezone=UTC");
            statement = connection.createStatement();
            set = statement.executeQuery("select age from users");

            while (set.next()) {
                int ages = set.getInt("age");
                System.out.println(ages);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*关闭连接最后关闭*/
        finally {
            try {
                if (set != null) {
                    set.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
