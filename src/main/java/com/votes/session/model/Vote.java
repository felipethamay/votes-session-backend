package com.votes.session.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer voteId;

    private Integer sessionId;

    private Integer associateId;

    private Boolean vote;

    private LocalDateTime creationDate;

}
