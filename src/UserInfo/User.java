package UserInfo;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;

public class User {

    private String Username;
    private String Password;
    private int Attempts;
    private Boolean Active;
    private LocalDateTime LastPage;

    User(String userN, String passW){
        this.Username = userN;
       // this.Password = encryptPW(passW);
        this.Password = passW;
        this.Active = true;
        this.Attempts = 0;
        this.LastPage = LocalDateTime.now();
    }

    public int getAttempts() {return Attempts; }
    public String getUsername(){return Username; }
    public String getPassword(){return Password; }
    public boolean isActive(){return Active; }
    public LocalDateTime getLastPg(){ return LastPage;  }

    public void setLastPg(LocalDateTime lastPage){ this.LastPage = lastPage;  }
    public void setActive(Boolean active) { Active = active;  }
    public void setAttempts(int attempts){Attempts = attempts;  }

//    private String encryptPW(String password){
//        String salt = BCrypt.gensalt();
//        String hash = BCrypt.hashpw(password, salt);
//        return hash;
//    }

}
