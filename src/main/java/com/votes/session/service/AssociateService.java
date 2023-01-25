package com.votes.session.service;

import com.votes.session.entity.AssociateEntity;
import com.votes.session.exception.EntityNotFoundException;
import com.votes.session.repository.AssociateRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssociateService {

    private final AssociateRepository associateRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(AssociateService.class);

    public AssociateEntity findById(Integer id) {
        LOGGER.info("Associate found successfully.");
        return associateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public List<AssociateEntity> findAll() {
        LOGGER.info("Associate found successfully.");
        return associateRepository.findAll();
    }

    public AssociateEntity createAssociate(AssociateEntity associateEntity) {
        associateEntity.setCreationDate(LocalDateTime.now());
        associateEntity.setUpdateDate(LocalDateTime.now());

        LOGGER.info("Associate created successfully.");
        return associateRepository.save(associateEntity);
    }

    public AssociateEntity updateAssociateById(AssociateEntity associateEntity, Integer id) {
        associateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        associateEntity.setUpdateDate(LocalDateTime.now());

        LOGGER.info("Associate changed successfully.");
        return associateRepository.save(associateEntity);
    }

    public AssociateEntity deleteAssociateById(Integer id) {
        AssociateEntity associateEntity = associateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        associateRepository.delete(associateEntity);

        LOGGER.info("Associate deleted successfully.");
        return associateEntity;
    }

    public AssociateEntity validPermissionAssociateVoting() {
        return null;
    }

}