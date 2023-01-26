package com.votes.session.service;

import com.votes.session.entity.SessionEntity;
import com.votes.session.entity.VoteEntity;
import com.votes.session.exception.AssociateException;
import com.votes.session.exception.EntityNotFoundException;
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

//        voteEntity.setSessionId(sessionId);
        VoteEntity vote1 = voteRepository.save(voteEntity);
        sessionRepository.save(sessionEntity);

        LOGGER.info("Vote created successfully.");
        return vote1;
    }

    public SessionEntity calculeVoting() {
        return null;
    }

    private void uniqueVoteVerification(Integer sessionId, Integer associateId) {

        SessionEntity sessionEntity = sessionRepository.findById(sessionId).orElseThrow(
                () -> new EntityNotFoundException());

        for (VoteEntity voteEntity : sessionEntity.getVotes()) {
            if (associateId.equals(voteEntity.getAssociateId())) {
                //Erro: associado já votou, não pode votar duas vezes na mesma sessão
                throw new AssociateException();
            }
        }
    }

    private void timeSessionVerification(Integer sessionId, Integer associateId) {

        LocalDateTime actualDateTime = LocalDateTime.now();
        System.out.println(actualDateTime);

        SessionEntity sessionEntity = sessionRepository.findById(sessionId).orElseThrow(
                () -> new EntityNotFoundException());
        System.out.println(sessionEntity.getStartSession());

        if (actualDateTime.compareTo(sessionEntity.getStartSession()) == -1) {
            // Ainda não chegou a hora de votar
            throw new AssociateException();
        }

        if (actualDateTime.compareTo(sessionEntity.getEndSession()) == 1) {
            // já passou a hora de votar
            throw new AssociateException();
        }
    }
}
