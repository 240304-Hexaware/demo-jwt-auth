package com.revature.demojwtauth.exceptions;

public class BadAuthenticationException extends Exception{
    public BadAuthenticationException(String msg) {
        super(msg);
    }
}
