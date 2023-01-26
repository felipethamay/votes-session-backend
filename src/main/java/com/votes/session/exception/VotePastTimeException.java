package com.votes.session.exception;

public class VotePastTimeException extends RuntimeException {

    private static final String VOTE_PAST_TIME_MESSAGE = "It's past time to vote.";

    public VotePastTimeException() {
        super(VOTE_PAST_TIME_MESSAGE);
    }

}