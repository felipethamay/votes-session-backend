package com.votes.session.exception;

public class VoteNotTimeException extends RuntimeException {

    private static final String VOTE_NOT_TIME_MESSAGE = "It's not time to vote.";

    public VoteNotTimeException() {
        super(VOTE_NOT_TIME_MESSAGE);
    }

}