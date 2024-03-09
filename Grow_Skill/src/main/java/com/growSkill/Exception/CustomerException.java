package com.growSkill.Exception;

public class CustomerException extends RuntimeException{

    public CustomerException() {
    }

    public CustomerException(String message) {
        super(message);
    }
}
