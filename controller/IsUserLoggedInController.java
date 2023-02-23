package com.crmsystem.registration.controller;

import com.crmsystem.registration.service.IsLoggedInService;
import com.crmsystem.registration.vo.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IsUserLoggedInController {

    @Autowired
    private IsLoggedInService service;

    @GetMapping("/isLoggedIn")
    public UserDetails IsUserLoggedIn(){
       return service.isLoggedIn();
    }
}
