package com.ua.hlibkorobov.restapp.controller;

import com.ua.hlibkorobov.restapp.exception.IllegalChangingOfStatusException;
import com.ua.hlibkorobov.restapp.exception.TodoListNotFound;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TodoListNotFound.class)
    public ResponseEntity<?> handleUserNotFoundException(TodoListNotFound e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(IllegalChangingOfStatusException.class)
    public ResponseEntity<?> handleIllegalChangingOfStatusException(IllegalChangingOfStatusException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
