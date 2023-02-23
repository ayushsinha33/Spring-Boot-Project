package com.crmsystem.registration.serviceimplementation;

import com.crmsystem.registration.entity.UserRegistry;
import com.crmsystem.registration.exceptions.UniqueException;
import com.crmsystem.registration.repository.RegistrationRepository;
import com.crmsystem.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationRepository repository;



    @Override
    public ResponseEntity<UserRegistry> registeringNewUser(UserRegistry registration) {
        try{
            String hashedPassword=hashPassword(registration.getPassword());   //calling hashing function to hash the password inputted by the user.
            registration.setPassword(hashedPassword);

            UserRegistry newRegistration = repository.save(registration);
            return ResponseEntity.status(HttpStatus.CREATED).body(newRegistration);
        }catch(Exception e){
        throw new UniqueException("All FIELDS are MANDATORY and the values of EMAIL and UIDAI SHOULD BE UNIQUE");
        }
    }

    private String hashPassword(String password){
        try{
            MessageDigest messageDigest=MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = messageDigest.digest(password.getBytes());
            return new String(hashedPassword);
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("No Algorithm exist for hashing password");
        }

    }
}
