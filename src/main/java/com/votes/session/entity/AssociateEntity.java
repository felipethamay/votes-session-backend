package com.votes.session.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Associate")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ASSOCIATE")
public class AssociateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer associateId;

    private String cpf;

    private String name;

}