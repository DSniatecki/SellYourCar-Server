package com.dsniatecki.sellyourcar.exceptions;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }

}
