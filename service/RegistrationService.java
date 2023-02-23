package com.crmsystem.registration.service;

import com.crmsystem.registration.entity.UserRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface RegistrationService {
    ResponseEntity<UserRegistry> registeringNewUser(UserRegistry registration);
}
