package com.github.jmariama.worm.exception;

//for when book does not have enough fields
public class InsufficientBookFieldsException extends RuntimeException {
    public InsufficientBookFieldsException(String message) {
        super(message);
    }
}