package dev.mzkhawar.cornerperks.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(TaskNotFoundException.class)
//    public ResponseEntity<String> handleTaskNotFoundException(TaskNotFoundException e) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//    }
//
//    @ExceptionHandler(TaskLogNotFoundException.class)
//    public ResponseEntity<String> handleTaskLogNotFoundException(TaskLogNotFoundException e) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//    }
}
