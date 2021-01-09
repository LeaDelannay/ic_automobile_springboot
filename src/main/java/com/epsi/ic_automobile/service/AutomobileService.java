package com.epsi.ic_automobile.service;

import com.epsi.ic_automobile.model.Contrat;
import com.epsi.ic_automobile.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutomobileService {

    @Autowired
    private ContratRepository contratRepository;

    public List<Contrat> getListeContrats(){
        List<Contrat> allContrats = new ArrayList<>();
        Iterable<Contrat> allContratsIterable = this.contratRepository.findAll();

//        allContratsIterable.forEach(contrat -> allContrats.add(contrat));
        allContratsIterable.forEach(allContrats::add);

        return allContrats;
    }
}
