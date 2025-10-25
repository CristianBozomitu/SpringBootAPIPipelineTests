package com.example.demo.handler;

import com.example.demo.controller.ResponseTemplate;
import com.example.demo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseTemplate<String>> handleNotFoundException(NotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseTemplate<>(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseTemplate<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        String[] words = ex.getMessage().split(" ");
        System.out.println(Arrays.toString(words));
        String field = words[4];
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseTemplate<>("Field" + field + " is required"));
    }
}
