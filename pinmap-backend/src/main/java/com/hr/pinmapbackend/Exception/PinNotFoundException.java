package com.hr.pinmapbackend.Exception;

public class PinNotFoundException extends RuntimeException{

    public PinNotFoundException(String message){
        super(message);
    }
    
}
