package dps.bean;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String gender;
    private Date birthday;

    public User() {
    }

    public User(final String name, final String password, final Integer age, final String gender,
            final Date birthday) {
        super();
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(final Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.id;
        return result;
    }
}
