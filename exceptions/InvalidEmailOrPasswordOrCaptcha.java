package com.crmsystem.registration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
public class InvalidEmailOrPasswordOrCaptcha extends RuntimeException{
    public InvalidEmailOrPasswordOrCaptcha() {
    }

    public InvalidEmailOrPasswordOrCaptcha(String message) {
        super(message);
    }
}
