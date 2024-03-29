package com.webapp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponse handleGlobalException(Exception exception, HttpServletRequest request) {
        return new ErrorResponse(exception.getMessage(), request.getRequestURI());
    }
}