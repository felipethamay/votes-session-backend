package com.votes.session.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Session")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_SESSION")
public class SessionEntity {

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