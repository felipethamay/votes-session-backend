package com.votes.session.service;

import com.votes.session.entity.SessionEntity;
import com.votes.session.exception.EntityNotFoundException;
import com.votes.session.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionService.class);

    public Page<SessionEntity> listSessions(Integer page, Integer linesPerPage, String orderBy, String direction, String title) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage,
                Direction.valueOf(direction), orderBy);

        Page<SessionEntity> sessions = sessionRepository.findByTitleContainsIgnoreCase(title, pageRequest);

        LOGGER.info("Sessions listed successfully.");
        return sessions;
    }

    public SessionEntity sessionFindById(Integer id) {
        LOGGER.info("Sessions encountered successfully.");
        return sessionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public SessionEntity createSession(SessionEntity sessionEntity) {
        sessionEntity.setStartSession(LocalDateTime.now());

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

}
