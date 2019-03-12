package com.devheaven.app.exceptions;

/**
 * This class represents a unauthorized error in the system.
 *
 * @author tomdewildt
 */
public class UnauthorizedException extends Exception {

    /**
     * Constructor for the unauthorized exception.
     *
     * @param message the message of the exception.
     */
    public UnauthorizedException(String message) {
        super(message);
    }

}
