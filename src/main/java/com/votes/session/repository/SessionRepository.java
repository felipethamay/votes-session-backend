package com.votes.session.repository;

import com.votes.session.entity.SessionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionEntity, Integer> {

    Page<SessionEntity> findByTitleContainsIgnoreCase(String title, Pageable pageable);

}

