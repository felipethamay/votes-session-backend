package com.votes.session.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Session {

    private String title;

    private String description;

    private LocalDateTime startSession;

    private LocalDateTime endSession;

    private List<Integer> associateIds;

}
