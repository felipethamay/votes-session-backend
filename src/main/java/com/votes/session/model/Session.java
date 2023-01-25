package com.votes.session.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private Long duration;

    private LocalDateTime startSession;

    private LocalDateTime endSession;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;
}
