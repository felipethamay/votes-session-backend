package com.votes.session.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Session")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_SESSION")
public class SessionEntity {

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
