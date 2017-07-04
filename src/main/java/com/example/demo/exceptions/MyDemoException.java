package com.example.demo.exceptions;

/**
 * Created by THANH NGA on 6/29/2017.
 */
public class MyDemoException extends Exception{
    private String exceptionMessage;

    public MyDemoException(String exceptionContent) {
        this.exceptionMessage = exceptionContent;
    }

    public MyDemoException() {
    }

    public String getExceptionContent() {
        return exceptionMessage;
    }

    public void setExceptionContent(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
