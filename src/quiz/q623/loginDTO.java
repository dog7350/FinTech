package quiz.q623;

public class loginDTO {
    private String id, pwd;

    loginDTO() {
        setId(null);
        setPwd(null);
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPwd() { return pwd; }
    public void setPwd(String pwd) { this.pwd = pwd; }
}
