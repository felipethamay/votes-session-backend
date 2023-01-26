package com.votes.session.service;

import com.votes.session.entity.AssociateEntity;
import com.votes.session.entity.SessionEntity;
import com.votes.session.exception.AssociateException;
import com.votes.session.exception.DefaultMinuteException;
import com.votes.session.exception.EntityNotFoundException;
import com.votes.session.exception.InitialSessionException;
import com.votes.session.model.Session;
import com.votes.session.repository.AssociateRepository;
import com.votes.session.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;
    private final AssociateRepository associateRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionService.class);

    public List<SessionEntity> findAll() {
        LOGGER.info("Sessions listed successfully.");
        return sessionRepository.findAll();
    }

    public SessionEntity sessionFindById(Integer id) {
        LOGGER.info("Sessions encountered successfully.");
        return sessionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public SessionEntity createSession(Session session) {

        List<Integer> associateIds = session.getAssociateIds();
        idsVerification(associateIds);
        defaultTimeSessionVerification(session.getStartSession(), session.getEndSession());

        SessionEntity sessionEntity = new SessionEntity();
        sessionEntity.setStartSession(session.getStartSession());
        sessionEntity.setEndSession(session.getEndSession());
        sessionEntity.setAssociates(getAssociates(associateIds));
        sessionEntity.setTitle(sessionEntity.getTitle());
        sessionEntity.setDescription(session.getDescription());
        sessionEntity.setVotes(new ArrayList<>());

        LOGGER.info("Session created successfully.");
        return sessionRepository.save(sessionEntity);
    }

    public SessionEntity updateSessionById(SessionEntity sessionEntity, Integer id) {
        sessionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        LOGGER.info("Session changed successfully.");
        return sessionRepository.save(sessionEntity);
    }

    public SessionEntity deleteSessionById(Integer id) {
        SessionEntity sessionEntity = sessionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        sessionRepository.delete(sessionEntity);

        LOGGER.info("Session deleted successfully.");
        return sessionEntity;
    }

    private void idsVerification(List<Integer> associateIds) {

        List<AssociateEntity> associateEntities = associateRepository.findAll();

        int count = 0;
        for (Integer associateId : associateIds) {
            for (AssociateEntity associateEntity : associateEntities) {
                if (associateId.equals(associateEntity.getAssociateId())) {
                    count++;
                }
            }
        }

        if (count < associateIds.size()) {
            // Algum dos ids fornecidos não existem na base
            throw new AssociateException();
        }

        if (associateIds.size() > associateEntities.size()) {
            // Existe mais ids do que itens na base
            throw new AssociateException();
        }

    }

    private List<AssociateEntity> getAssociates(List<Integer> associateIds) {

        List<AssociateEntity> associateEntities = associateRepository.findAll();
        List<AssociateEntity> response = new ArrayList<>();

        for (Integer associateId : associateIds) {
            for (AssociateEntity associateEntity : associateEntities) {
                if (associateId.equals(associateEntity.getAssociateId())) {
                    response.add(associateEntity);
                }
            }
        }
        return response;
    }

    private void defaultTimeSessionVerification(LocalDateTime startSession, LocalDateTime endSession) {
        var calculatedMinute = endSession.minusHours(startSession.getHour()).minusMinutes(startSession.getMinute());
        LocalDateTime actualDateTime = LocalDateTime.now();

        if (calculatedMinute.getMinute() < 1) {
            throw new DefaultMinuteException();
        }
        if (startSession.getMinute() < actualDateTime.getMinute()) {
            throw new InitialSessionException();
        }


    }

}
