package com.epsi.ic_automobile.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_client;
    private String nom;
    private String adresse;
    private String email;
    private String token;

    @ManyToOne
    @JoinColumn(name = "id_contrat")
    private Contrat contrat;
}
