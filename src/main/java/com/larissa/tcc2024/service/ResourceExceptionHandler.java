package com.larissa.tcc2024.service;


import com.larissa.tcc2024.exceptions.ObjectNotFoundExceptionTeste;
import com.larissa.tcc2024.exceptions.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundExceptionTeste.class)
    public ResponseEntity<StandardError> teste(ObjectNotFoundExceptionTeste e){
        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(CustomExceptionTeste.class)
    public ResponseEntity<StandardError> teste1(CustomExceptionTeste e){
        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


}
