package com.ua.hlibkorobov.restapp.exception;

public class TodoListNotFound extends RuntimeException{

    public TodoListNotFound(String message) {
        super(message);
    }
}
