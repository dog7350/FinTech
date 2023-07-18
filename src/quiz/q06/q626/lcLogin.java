package quiz.q06.q626;

public class lcLogin extends lcTime {
    private String id, pwd;

    lcLogin() {
        setId(null);
        setPwd(null);
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPwd() { return pwd; }
    public void setPwd(String pwd) { this.pwd = pwd; }
}
