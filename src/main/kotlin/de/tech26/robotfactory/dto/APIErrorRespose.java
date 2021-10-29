package de.tech26.robotfactory.dto;


import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class APIErrorRespose {

    private Integer statusCode;
    private HttpStatus status;
    private String message;
    private String location;
    private List<String> errors;

    public APIErrorRespose() {
    }

    public APIErrorRespose(HttpStatus status, String message, String error, String location) {
        this.status = status;
        this.message = message;
        this.statusCode = status.value();
        this.location = location;
        errors = Arrays.asList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }
}