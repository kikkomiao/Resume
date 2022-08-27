package Entity;

public class Asso {
    private int id;
    private int assoid;
    private String assoname;
    private String assotime;
    private String detail;

    public Asso() {
    }

    public Asso(String assoname, String assotime, String detail) {
        this.assoname = assoname;
        this.assotime = assotime;
        this.detail = detail;
    }

    public Asso(int id, int assoid, String assoname, String assotime, String detail) {
        this.id = id;
        this.assoid = assoid;
        this.assoname = assoname;
        this.assotime = assotime;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssoid() {
        return assoid;
    }

    public void setAssoid(int assoid) {
        this.assoid = assoid;
    }

    public String getAssoname() {
        return assoname;
    }

    public void setAssoname(String assoname) {
        this.assoname = assoname;
    }

    public String getAssotime() {
        return assotime;
    }

    public void setAssotime(String assotime) {
        this.assotime = assotime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
