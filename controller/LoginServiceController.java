package com.crmsystem.registration.controller;

import com.crmsystem.registration.entity.UserRegistry;
import com.crmsystem.registration.exceptions.InvalidEmailOrPasswordOrCaptcha;
import com.crmsystem.registration.repository.RegistrationRepository;
import com.crmsystem.registration.service.LoginService;
import com.crmsystem.registration.service.RegistrationService;
import com.crmsystem.registration.vo.LoginInfo;
import com.crmsystem.registration.vo.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginServiceController {
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private LoginService service;
    @Autowired
    private RegistrationRepository repository;

    @PostMapping("/login")
    public String login(@RequestBody LoginInfo info, HttpServletRequest request){
        boolean success = service.login(info.getEmail(), info.getPassword(), info.getCaptchaAnswer(), request);
        if(success){
            return "Login Successful !";
        }else{
            throw new InvalidEmailOrPasswordOrCaptcha("Wrong Email,Password or Captcha");
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        service.logout(request);
        return "LogOut Successful !";
    }

}
