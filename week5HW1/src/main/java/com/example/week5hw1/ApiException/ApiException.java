package com.example.week5hw1.ApiException;

public class ApiException extends RuntimeException {
    public ApiException(String messege) {
        super(messege);
    }
}