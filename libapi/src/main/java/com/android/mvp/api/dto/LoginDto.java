package com.android.mvp.api.dto;

/**
 * Created by meikai on 15/11/6.
 */
public class LoginDto {

    private String userName;

    private String userPwd;

    public LoginDto(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
