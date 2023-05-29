package com.example.week5hw1.ControllerAdvise;

import com.example.week5hw1.ApiException.ApiException;
import com.example.week5hw1.ApiRespons.ApiRespons;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvis {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiRespons> ApiExsption(ApiException e){
        String massege=e.getMessage();
        return ResponseEntity.status(400).body(new ApiRespons(massege));
    }
}
