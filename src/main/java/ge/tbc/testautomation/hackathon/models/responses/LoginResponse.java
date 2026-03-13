package ge.tbc.testautomation.hackathon.models.responses;

public class LoginResponse {

    private String token;
    private String email;
    private String fullName;

    public LoginResponse() {}

    public String getToken()    { return token;    }
    public String getEmail()    { return email;    }
    public String getFullName() { return fullName; }

    public void setToken(String token)       { this.token    = token;    }
    public void setEmail(String email)       { this.email    = email;    }
    public void setFullName(String fullName) { this.fullName = fullName; }
}
