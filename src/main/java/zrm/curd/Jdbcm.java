package zrm.curd;

import com.mysql.cj.xdevapi.SqlDataResult;

import java.sql.*;

public class Jdbcm {
    public static void main(String[] args) {

        String jrul = "com.mysql.cj.jdbc.Driver";
        String jmconnector = "jdbc:mysql://localhost/test?user=root&password=123&serverTimezone=UTC";

        try {
            Class.forName(jrul);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        /*预编译statement*/
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(jmconnector);
            /*
            statement = connection.prepareStatement("insert into users value (?,?,?,?);");
            statement.setString(1,"zrm");
            statement.setInt(2,13);
            statement.setInt(3,17);
            statement.setInt(4,23);
            statement.execute();
            */
            /*
            resultSet = statement.executeQuery("select * from users;");
            if (resultSet.next()) {
                int age = resultSet.getInt("age");
                System.out.println(age);
            }*/
            statement = connection.prepareStatement("select name from users where age=?;");
            statement.setInt(1,18);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString("name");
                System.out.println(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
