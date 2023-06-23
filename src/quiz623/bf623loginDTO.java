package quiz623;

public class bf623loginDTO {
    private String id, pwd;

    bf623loginDTO() {
        setId(null);
        setPwd(null);
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPwd() { return pwd; }
    public void setPwd(String pwd) { this.pwd = pwd; }
}
