package com.votes.session.service;

import com.votes.session.entity.AssociateEntity;
import com.votes.session.exception.AssociateNotFoundException;
import com.votes.session.exception.EntityNotFoundException;
import com.votes.session.repository.AssociateRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssociateService {

    private final AssociateRepository associateRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(AssociateService.class);

    public AssociateEntity findById(Integer id) {
        LOGGER.info("Associate found successfully.");
        return associateRepository.findById(id)
                .orElseThrow(() -> new AssociateNotFoundException());
    }

    public List<AssociateEntity> findAll() {
        LOGGER.info("Associate found successfully.");
        return associateRepository.findAll();
    }

    public AssociateEntity createAssociate(AssociateEntity associateEntity) {
        LOGGER.info("Associate created successfully.");
        return associateRepository.save(associateEntity);
    }

    public AssociateEntity updateAssociateById(AssociateEntity associateEntity, Integer associateId) {
        associateRepository.findById(associateId)
                .orElseThrow(() -> new EntityNotFoundException());

        associateEntity.setAssociateId(associateId);
        associateEntity.setCpf(associateEntity.getCpf());
        associateEntity.setName(associateEntity.getName());

        if (!associateId.equals(associateEntity.getAssociateId())) {
            throw new AssociateNotFoundException();
        }

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

}