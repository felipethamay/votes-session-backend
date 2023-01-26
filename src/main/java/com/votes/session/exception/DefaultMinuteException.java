package com.votes.session.exception;

public class DefaultMinuteException extends RuntimeException {

    private static final String MINUTE_DEFAULT_MESSAGE = "Session time cannot be less than 1 minute.";

    public DefaultMinuteException() {
        super(MINUTE_DEFAULT_MESSAGE);
    }

}