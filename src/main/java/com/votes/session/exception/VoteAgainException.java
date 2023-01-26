package com.votes.session.exception;

public class VoteAgainException extends RuntimeException {

    private static final String VOTE_AGAIN_MESSAGE = "Associate cannot vote again in the same session.";

    public VoteAgainException() {
        super(VOTE_AGAIN_MESSAGE);
    }

}