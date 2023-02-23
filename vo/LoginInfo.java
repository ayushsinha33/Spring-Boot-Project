package com.crmsystem.registration.vo;

public class LoginInfo {
    private String email;
    private String password;
    private int captchaAnswer;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCaptchaAnswer() {
        return captchaAnswer;
    }

    public void setCaptchaAnswer(int captchaAnswer) {
        this.captchaAnswer = captchaAnswer;
    }
}
