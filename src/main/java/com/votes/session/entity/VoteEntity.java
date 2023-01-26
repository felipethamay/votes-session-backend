package com.votes.session.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Vote")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_VOTE")
public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer voteId;

    private Integer associateId;

    private Boolean vote;

    private LocalDateTime creationDate;

}