package com.alv.mvc.bean;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/16 15:57
 * @description：
 */
public class User {
    private String username;
    private String pwd;
    private String age;

    public User(String username, String pwd, String age) {
        this.username = username;
        this.pwd = pwd;
        this.age = age;
    }

    public User() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

    public String getAge() {
        return age;

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
