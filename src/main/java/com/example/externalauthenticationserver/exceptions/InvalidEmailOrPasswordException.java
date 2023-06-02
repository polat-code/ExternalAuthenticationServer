package com.example.externalauthenticationserver.exceptions;

public class InvalidEmailOrPasswordException extends Throwable {
    public InvalidEmailOrPasswordException(String invalidEmailOrPassword) {
        super(invalidEmailOrPassword);
    }
}
