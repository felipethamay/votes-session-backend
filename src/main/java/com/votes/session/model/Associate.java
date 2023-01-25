package com.votes.session.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Associate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer associateId;

    private String cpf;

    private String name;

}
