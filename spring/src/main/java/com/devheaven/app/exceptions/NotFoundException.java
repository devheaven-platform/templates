package com.devheaven.app.exceptions;

/**
 * This class represents a NotFound error in the system.
 *
 * @author tomdewildt
 */
public class NotFoundException extends Exception {

    /**
     * Constructor for the not found exception.
     *
     * @param message the message of the exception.
     */
    public NotFoundException(String message) {
        super(message);
    }

}
