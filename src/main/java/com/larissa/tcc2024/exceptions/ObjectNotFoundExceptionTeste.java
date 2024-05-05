package com.larissa.tcc2024.exceptions;

public class ObjectNotFoundExceptionTeste extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundExceptionTeste(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoundExceptionTeste(String message){
        super(message);
    }
}
