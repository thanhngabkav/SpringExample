package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Created by THANH NGA on 7/18/2017.
 */
public class MyExceptionModel extends Exception{

    private HttpStatus status;
    private String content;
    private StackTraceElement[] stackTrace;

    public MyExceptionModel(HttpStatus status, String content, StackTraceElement[] stackTrace) {
        this.status = status;
        this.content = content;
        this.stackTrace = stackTrace;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return stackTrace;
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        this.stackTrace = stackTrace;
    }
}
