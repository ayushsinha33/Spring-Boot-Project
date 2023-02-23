package com.crmsystem.registration.controller;

import com.crmsystem.registration.entity.UserRegistry;
import com.crmsystem.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationServiceController {
    @Autowired
    private RegistrationService service;

    @PostMapping("/register")
    public ResponseEntity<UserRegistry> creatingNewRegistration(@RequestBody UserRegistry userRegistry){
        return service.registeringNewUser(userRegistry);
    }
}
