package UserInfo;

public class Testing {

    public static int checkUnPw(String Un, String Pw){
        if (Un.equals("test") && !Pw.equals("test")){
            return 0;
        }
        else if (Un.equals("test") && Pw.equals("test")){
            return 1;
        }
        else return 2;
    }

    public static User createUser(String Uname, String Pword){
        User user = new User(Uname, Pword);
        return user;
    }

}
