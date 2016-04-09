package cn.edu.bupt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;


@Entity
@Table(name = "tuser")
public class User implements java.io.Serializable {

    private String id;
    private String username;
    private String password;
    private Date regtime;
    private String code;

    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @Column(name = "username", unique = false, nullable = false, length = 100)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "regtime", length = 7)
    public Date getRegtime() {
        return this.regtime;
    }

    public void setRegtime(final Date regtime) {
        this.regtime = regtime;
    }

    @Transient
    public String getCode() {
        return this.code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public User() {
    }

    public User(final String id, final Date regtime, final String username, final String password) {
        super();
        this.id = id;
        this.regtime = regtime;
        this.username = username;
        this.password = password;
    }
}
