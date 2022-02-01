package com.CarsDemoEx.demo.exceptions;

import com.CarsDemoEx.demo.models.Owner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class OwnerNotFoundException extends RuntimeException{

    public OwnerNotFoundException(Long id){
        super("Owner id not found: " + id);
    }
}
