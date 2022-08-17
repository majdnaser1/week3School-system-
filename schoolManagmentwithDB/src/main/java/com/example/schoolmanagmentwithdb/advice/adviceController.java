package com.example.schoolmanagmentwithdb.advice;

import com.example.schoolmanagmentwithdb.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class adviceController {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message,400));
    }
    @ExceptionHandler(value = HttpClientErrorException.NotFound.class)
    public ResponseEntity<ApiResponse> httpClientErrorException(HttpClientErrorException httpClientErrorException){
        String message=httpClientErrorException.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse("Not found !!!",400));

    }


}