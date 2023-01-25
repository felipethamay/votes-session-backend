package com.votes.session.service;

import com.votes.session.entity.SessionEntity;
import com.votes.session.entity.VoteEntity;
import com.votes.session.exception.EntityNotFoundException;
import com.votes.session.repository.SessionRepository;
import com.votes.session.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final SessionRepository sessionRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(AssociateService.class);

    public VoteEntity create(VoteEntity voteEntity) {
        voteEntity.setCreationDate(LocalDateTime.now());

        LOGGER.info("Vote created successfully.");
        return voteRepository.save(voteEntity);
    }

    public VoteEntity deleteVoteById(Integer id) {
        VoteEntity voteEntity = voteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        voteRepository.delete(voteEntity);

        LOGGER.info("Vote deleted successfully.");
        return voteEntity;
    }

    public SessionEntity startVoting(Integer id) {
        SessionEntity sessionEntity = sessionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        LOGGER.info("Voting started successfully.");
        return null;
    }

    public SessionEntity endingVoting() {
        return null;
    }

    public SessionEntity calculeVoting() {
        return null;
    }
}
