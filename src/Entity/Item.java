package Entity;

public class Item {
    private int id;
    private int itemid;
    private String itemname;
    private String itemtime;
    private String detail;

    public Item() {
    }

    public Item(String itemname, String itemtime, String detail) {
        this.itemname = itemname;
        this.itemtime = itemtime;
        this.detail = detail;
    }

    public Item(int id, int itemid, String itemname, String itemtime, String detail) {
        this.id = id;
        this.itemid = itemid;
        this.itemname = itemname;
        this.itemtime = itemtime;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemtime() {
        return itemtime;
    }

    public void setItemtime(String itemtime) {
        this.itemtime = itemtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
