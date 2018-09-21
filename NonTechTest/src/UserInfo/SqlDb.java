package UserInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDb {

    public static Connection getConnection(){
        Connection connect = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("http://localhost/phpmyadmin/db_structure.php?db=technical", "uer", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connect;
    }

}

//https://www.youtube.com/watch?v=NoPzqahrzp8
