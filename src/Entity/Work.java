package Entity;

public class Work {
    private int id;
    private int workid;
    private String company;
    private String worktime;
    private String detail;

    public Work() {
    }

    public Work(String company, String worktime, String detail) {
        this.company = company;
        this.worktime = worktime;
        this.detail = detail;
    }

    public Work(int id, int workid, String company, String worktime, String detail) {
        this.id = id;
        this.workid = workid;
        this.company = company;
        this.worktime = worktime;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkid() {
        return workid;
    }

    public void setWorkid(int workid) {
        this.workid = workid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
