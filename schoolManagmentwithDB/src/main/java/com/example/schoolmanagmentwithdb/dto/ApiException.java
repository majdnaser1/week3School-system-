package com.example.schoolmanagmentwithdb.dto;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
