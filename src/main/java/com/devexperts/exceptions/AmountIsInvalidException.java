package com.devexperts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AmountIsInvalidException extends Exception {
    public AmountIsInvalidException(String message) {
        super(message);
    }
}
