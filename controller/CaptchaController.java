package com.crmsystem.registration.controller;

import com.crmsystem.registration.vo.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CaptchaController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/captcha")
    public String getCaptcha(){
        Captcha captcha=new Captcha();
//        Cookie captchaCookie= new Cookie("captcha",captcha.getCaptcha());
//        Cookie captchaAnswerCookie= new Cookie("captchaAnswer",Integer.toString(captcha.getAnswer()));
//
//        response.addCookie(captchaCookie);
//        response.addCookie(captchaAnswerCookie);

        //Setting the attributes(captcha and its value) in the current session :
        request.getSession().setAttribute("captcha",captcha);
        request.getSession().setAttribute("captchaAnswer",captcha.getAnswer());

        return captcha.getCaptcha();
    }

}
