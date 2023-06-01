package com.example.externalauthenticationserver.exceptions;

public class UserAlreadyRegisterException extends Exception{
    public UserAlreadyRegisterException(String message) {
        super(message);
    }
}
