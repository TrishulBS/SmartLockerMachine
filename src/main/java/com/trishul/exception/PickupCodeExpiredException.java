package com.trishul.exception;

public class PickupCodeExpiredException extends Exception {
    public PickupCodeExpiredException(String message){
        super(message);
    }
}
