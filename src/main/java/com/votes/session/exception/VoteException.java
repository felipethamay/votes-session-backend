package com.votes.session.exception;

public class VoteException extends RuntimeException {

    private static final String VOTE_MESSAGE = "Vote not found.";

    public VoteException() {
        super(VOTE_MESSAGE);
    }

}
