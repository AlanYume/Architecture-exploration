package dps.bean;

public class MyClass {
    private Integer cid;
    private String cname;

    public Integer getCid() {
        return this.cid;
    }

    public void setCid(final Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return this.cname;
    }

    public void setCname(final String cname) {
        this.cname = cname;
    }

    public MyClass() {
    }

    public MyClass(final String cname) {
        super();
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "MyClass [cid=" + this.cid + ", cname=" + this.cname + "]";
    }
}
