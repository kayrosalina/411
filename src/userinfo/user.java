package userinfo;

import org.mindrot.jbcrypt.BCrypt;


import java.time.LocalDateTime;

public class user {

    private String Username;
    private String Password;
    private int Attempts;
    private Boolean Active;
    private LocalDateTime LastPage;

    user(String userN, String passW, int attempts, Boolean active){
        this.Username = userN;
        // this.Password = encryptPW(passW);
        this.Password = passW;
        this.Active = active;
        this.Attempts = attempts;
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

    private String encryptPW(String password){
        String salt = BCrypt.gensalt();
        String hash = BCrypt.hashpw(password, salt);
        return hash;
    }

}
