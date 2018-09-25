package UserInfo;

public class Testing {

    private static int attempts = 0;

    public static int checkUnPw(String Un, String Pw){
        if (Un.equals("test") && !Pw.equals("test")){
            return 0;
        }
        else if (Un.equals("test") && Pw.equals("test")){
            return 1;
        }
        else return 2;
    }

    public static user createUser(String Uname, String Pword){
        user user;
        try {
            while (attempts < 3) {
                user = new user(Uname, Pword, attempts, true);
                attempts++;
                if (user.isActive()) {
                    return user;
                }
            }
        } catch (InstantiationException e) {
            System.out.println(e);
        }

        return null;
    }

}
