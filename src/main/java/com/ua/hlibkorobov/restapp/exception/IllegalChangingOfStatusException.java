package com.ua.hlibkorobov.restapp.exception;

public class IllegalChangingOfStatusException extends RuntimeException {

    public IllegalChangingOfStatusException(String message) {
        super(message);
    }
}
