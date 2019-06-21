package com.club.Po;

import java.util.Date;

/**
 * Created by Administrator on 2019-03-25.
 */
public class User {
    private int userId;
    private String userPwd;
    private String userName;
    private String userSex;
    private int userAge;
    private String userPhone;
    private String userPic;

    public User() {
    }

    public User(int userId, String userName, String userSex, int userAge, String userPhone) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userPhone = userPhone;
    }

    public User(String userName, String userSex, int userAge, String userPhone) {
        this.userName = userName;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userPhone = userPhone;
    }

    public User(int userId, String userPwd, String userName, String userSex, int userAge, String userPhone, String userPic) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userPhone = userPhone;
        this.userPic = userPic;
    }

    public User(String userPwd, String userName, String userSex, int userAge, String userPhone, String userPic) {
        this.userPwd = userPwd;
        this.userName = userName;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userPhone = userPhone;
        this.userPic = userPic;
    }

    public User(String userPwd, String userName, String userSex, int userAge, String userPhone) {
        this.userPwd = userPwd;
        this.userName = userName;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                ", userPhone='" + userPhone + '\'' +
                ", userPic='" + userPic + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }
}
