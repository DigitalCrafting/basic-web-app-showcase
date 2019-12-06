package com.digitalcrafting.base.exception;

public class MissingImplementationException extends RuntimeException {
    public MissingImplementationException() {
    }

    public MissingImplementationException(String message) {
        super(message);
    }

    public MissingImplementationException(String message, Throwable cause) {
        super(message, cause);
    }
}
