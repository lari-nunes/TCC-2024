package com.larissa.tcc2024.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.larissa.tcc2024.service.ErrorResponse;

public class CustomExceptionTeste extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CustomExceptionTeste(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomExceptionTeste(String message){
        super(message);
    }
}
