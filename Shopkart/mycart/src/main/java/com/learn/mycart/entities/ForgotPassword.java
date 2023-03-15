package com.learn.mycart.entities;

public class ForgotPassword {

    String newPassword;
    String email;
    String code;

    public ForgotPassword(String email, String code) {
        this.email = email;
        this.code = code;
    }

    public ForgotPassword() {
    }

    public ForgotPassword(String newPassword, String email, String code) {
        this.newPassword = newPassword;
        this.email = email;
        this.code = code;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
