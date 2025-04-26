package com.example.senai.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> IllegalArgumentExceptionHandler(IllegalArgumentException erro) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", erro.getMessage()));
    }
}
