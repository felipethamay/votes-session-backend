package com.votes.session.repository;

import com.votes.session.entity.AssociateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociateRepository extends JpaRepository<AssociateEntity, Integer> {

}