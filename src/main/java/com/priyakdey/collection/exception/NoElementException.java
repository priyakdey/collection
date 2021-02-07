package com.priyakdey.collection.exception;

import java.io.Serial;

public class NoElementException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -5857808024882761429L;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public NoElementException(String message) {
        super(message);
    }
}
