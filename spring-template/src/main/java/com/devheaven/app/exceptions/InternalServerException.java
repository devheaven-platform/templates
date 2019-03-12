package com.devheaven.app.exceptions;

/**
 * This class represents a InternalServerError in the system.
 *
 * @author tomdewildt
 */
public class InternalServerException extends Exception {

    /**
     * Constructor for the internal server exception.
     *
     * @param message the message of the exception.
     */
    public InternalServerException(String message) {
        super(message);
    }

}
