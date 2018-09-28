package UserInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSQL {

    public static void main(String[] args)
    {
        String Username = "grace";
        String Password = "1234";
        boolean userExists = false;
        boolean userCanLogin = false;
        String dbPassword = "";
        String email = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project","root","root");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from login WHERE username = '" + Username +"'");
            if(rs.next())
            {
                userExists = true;
                dbPassword= rs.getString("password");
                email = rs.getString("email");
                if(dbPassword.equals(Password))
                {
                    userCanLogin = true;
                }
            }
            con.close();
        }
        catch(Exception e){
            userExists = false;
            System.out.println(e);
        }
    }

}
