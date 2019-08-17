package zrm;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 * Hello world!
 *实现jdbc对mysql数据库的连接
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
        String url="jdbc:mysql://localhost/test?user=root&password=123&severTimezone=UTC";
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection connectio=DriverManager.getConnection(url);
         Statement statement = connectio.createStatement();
         ResultSet set = statement.executeQuery("select age from users ;");
         set.next();
         int ages = set.getInt("age");
         System.out.println(ages);
    }
}
