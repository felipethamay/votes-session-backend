package com.votes.session.exception;

public class AssociatesMoreException extends RuntimeException {

    private static final String ASSOCIATE_MORE_MESSAGE = "Number of associates more than found.";

    public AssociatesMoreException() {
        super(ASSOCIATE_MORE_MESSAGE);
    }

}