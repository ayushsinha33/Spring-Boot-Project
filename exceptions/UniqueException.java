package com.crmsystem.registration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UniqueException extends RuntimeException{
    public UniqueException() {
    }

    public UniqueException(String message) {
        super(message);
    }
}
