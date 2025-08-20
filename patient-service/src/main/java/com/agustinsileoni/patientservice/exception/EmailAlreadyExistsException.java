package com.agustinsileoni.patientservice.exception;

public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException(String message) { super(message);}
}
