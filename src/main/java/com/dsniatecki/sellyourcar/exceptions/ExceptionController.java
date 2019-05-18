package com.dsniatecki.sellyourcar.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
@RestController
class ExceptionController {

    @ExceptionHandler({ResourceNotFoundException.class, EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleNotFoundException(Exception exception, WebRequest webRequest){
        return new ExceptionResponse(LocalDateTime.now(),  exception.getMessage(), webRequest.getDescription(false));
    }

    @ExceptionHandler({NumberFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleMultipleBadRequestExceptions(Exception exception, WebRequest webRequest){
        return new ExceptionResponse(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false));
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ExceptionResponse handleMethodNotSupportedException(Exception exception, WebRequest webRequest){
        return new ExceptionResponse(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false));
    }

}
