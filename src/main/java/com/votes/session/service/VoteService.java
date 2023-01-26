package com.votes.session.service;

import com.votes.session.entity.SessionEntity;
import com.votes.session.entity.VoteEntity;
import com.votes.session.exception.EntityNotFoundException;
import com.votes.session.exception.VoteAgainException;
import com.votes.session.exception.VoteNotTimeException;
import com.votes.session.exception.VotePastTimeException;
import com.votes.session.model.Vote;
import com.votes.session.repository.SessionRepository;
import com.votes.session.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final SessionRepository sessionRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(AssociateService.class);

    @Transactional
    public VoteEntity create(Vote vote, Integer sessionId, Integer associateId) {

        VoteEntity voteEntity = new VoteEntity();
        voteEntity.setVote(vote.getVote());
        voteEntity.setAssociateId(associateId);
        voteEntity.setCreationDate(LocalDateTime.now());

        uniqueVoteVerification(sessionId, associateId);
        timeSessionVerification(sessionId, associateId);

        SessionEntity sessionEntity = sessionRepository.findById(sessionId).orElseThrow(() -> new EntityNotFoundException());
        sessionEntity.getVotes().add(voteEntity);

        VoteEntity vote1 = voteRepository.save(voteEntity);
        sessionRepository.save(sessionEntity);

        LOGGER.info("Vote created successfully.");
        return vote1;
    }

    public SessionEntity calculeVoting() {
        return null;
    }

    private void uniqueVoteVerification(Integer sessionId, Integer associateId) {
        LOGGER.info("Unique vote verification.");
        SessionEntity sessionEntity = sessionRepository.findById(sessionId).orElseThrow(
                () -> new EntityNotFoundException());

        for (VoteEntity voteEntity : sessionEntity.getVotes()) {
            if (associateId.equals(voteEntity.getAssociateId())) {
                throw new VoteAgainException();
            }
        }
    }

    private void timeSessionVerification(Integer sessionId, Integer associateId) {
        LOGGER.info("Time session verification.");
        LocalDateTime actualDateTime = LocalDateTime.now();
        System.out.println(actualDateTime);

        SessionEntity sessionEntity = sessionRepository.findById(sessionId).orElseThrow(
                () -> new EntityNotFoundException());
        System.out.println(sessionEntity.getStartSession());

        if (actualDateTime.compareTo(sessionEntity.getStartSession()) == -1) {
            throw new VoteNotTimeException();
        }

        if (actualDateTime.compareTo(sessionEntity.getEndSession()) == 1) {
            throw new VotePastTimeException();
        }
    }
}
