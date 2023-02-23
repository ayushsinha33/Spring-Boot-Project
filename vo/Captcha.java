package com.crmsystem.registration.vo;

import java.util.Random;

public class Captcha {
    private int firstNumber;
    private int secondNumber;
    private int captchaAnswer;

    public Captcha() {
        this.firstNumber = new Random().nextInt(100);
        this.secondNumber = new Random().nextInt(100);
        this.captchaAnswer = firstNumber+secondNumber;
    }

    public String getCaptcha(){
        return firstNumber+ "+" +secondNumber;
    }

    public int getAnswer(){
        return captchaAnswer;
    }

}
