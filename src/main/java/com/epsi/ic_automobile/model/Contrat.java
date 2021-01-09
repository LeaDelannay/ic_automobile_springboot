package com.epsi.ic_automobile.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_contrat;
    private String nom;
    private Float marge;
}
