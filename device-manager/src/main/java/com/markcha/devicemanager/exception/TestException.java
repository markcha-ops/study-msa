package com.markcha.devicemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TestException extends RuntimeException {
    public TestException(String message) {
        super(message);
    }
}
