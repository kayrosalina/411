package UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class usertest {

    private int validity;
    private user test1;

    private static Connection c;
    PreparedStatement ps;


    public void retrieveDB(String userN, String passW) throws SQLException {
        ps = c.prepareStatement("SELECT Username,Password,Attempts,Active FROM technical.userinfo WHERE Username LIKE" + userN);
        //.prepareCall
        //ps.setString(1, userN);
        //ps.execute();
        //ResultSet rs = ps.getResultSet();

        ResultSet rs = ps.executeQuery();
        String pW = rs.getString(2);

        if (passW.equals(pW)) {
            this.validity = 1;
            try {
                this.test1 = new user(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4));
            } catch (InstantiationException e) {
                System.out.println(e);
            }
        }
        else if(pW == null) this.validity = 2;
        else this.validity =0;
    }
    // List<User> users = new ArrayList<>();
    // while(rs.next())
    //     users.add( test1 = new User(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4) )); }

    public int isValidLogin() {
        return validity;
    }

    public user getuser() {
        return test1;
    }

}