package com.votes.session.exception;

public class SessionNotFound extends RuntimeException {

    private static final String SESSION_NOT_FOUND_MESSAGE = "Session not found.";

    public SessionNotFound() {
        super(SESSION_NOT_FOUND_MESSAGE);
    }

}