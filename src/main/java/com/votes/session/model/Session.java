package com.votes.session.model;

import com.votes.session.entity.AssociateEntity;
import com.votes.session.entity.VoteEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sessionId;

    private String title;

    private String description;

    private LocalDateTime startSession;

    private LocalDateTime endSession;

    @OneToMany
    private List<VoteEntity> votes;

    @OneToMany
    private List<AssociateEntity> associates;

}
