package com.votes.session.exception;

public class AssociateException extends RuntimeException {

    private static final long serialVersionUID = -3478009627666756418L;

    private static final String ALREADY_VOTED_MESSAGE = "Associate has voted already.";

    public AssociateException() {
        super(ALREADY_VOTED_MESSAGE);
    }

}
