package com.votes.session.exception;

public class AssociateNotFoundException extends RuntimeException {

    private static final String ASSOCIATE_NOT_FOUND_MESSAGE = "Associate not found.";

    public AssociateNotFoundException() {
        super(ASSOCIATE_NOT_FOUND_MESSAGE);
    }

}