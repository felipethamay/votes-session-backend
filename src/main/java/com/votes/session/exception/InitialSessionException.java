package com.votes.session.exception;

public class InitialSessionException extends RuntimeException {

    private static final String INITIAL_SESSION_MESSAGE = "Initial session time cannot be less than current time.";

    public InitialSessionException() {
        super(INITIAL_SESSION_MESSAGE);
    }

}