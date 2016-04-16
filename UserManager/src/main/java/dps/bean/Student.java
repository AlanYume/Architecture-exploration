package dps.bean;

import java.util.Date;

public class Student {
    private Integer sid;
    private String snum;
    private String sname;
    private Integer sage;
    private Date sbirthday;
    MyClass myClass;

    public MyClass getMyClass() {
        return myClass;
    }

    public void setMyClass(final MyClass myClass) {
        this.myClass = myClass;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(final Integer sid) {
        this.sid = sid;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(final String snum) {
        this.snum = snum;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(final String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(final Integer sage) {
        this.sage = sage;
    }

    public Date getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(final Date sbirthday) {
        this.sbirthday = sbirthday;
    }

    public Student() {
    }

    public Student(final String snum, final String sname, final Integer sage,
            final Date sbirthday) {
        super();
        this.snum = snum;
        this.sname = sname;
        this.sage = sage;
        this.sbirthday = sbirthday;
    }

    @Override
    public String toString() {
        return "Student [sid=" + sid + ", snum=" + snum + ", sname=" + sname
                + ", sage=" + sage + ", sbirthday=" + sbirthday + ", myClass="
                + myClass + "]";
    }
}
