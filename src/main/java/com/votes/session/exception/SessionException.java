package com.votes.session.exception;

public class SessionException extends RuntimeException {

    private static final String SESSION_MESSAGE = "Session not found.";

    public SessionException() {
        super(SESSION_MESSAGE);
    }

}