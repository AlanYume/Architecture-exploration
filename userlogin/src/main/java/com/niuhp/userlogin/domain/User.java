package com.niuhp.userlogin.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 8254592767704044523L;

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private String nickname;
    private int loginState;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLoginState() {
        return loginState;
    }

    public void setLoginState(int loginState) {
        this.loginState = loginState;
    }

}
