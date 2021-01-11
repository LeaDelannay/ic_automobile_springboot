package com.epsi.ic_automobile.api.service;

import com.epsi.ic_automobile.api.repository.ClientRepository;
import com.epsi.ic_automobile.api.repository.ContratRepository;
import com.epsi.ic_automobile.model.Contrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutomobileService {

    private ContratRepository contratRepository;
    private ClientRepository clientRepository;

    public AutomobileService(ContratRepository contratRepository, ClientRepository clientRepository) {
        this.contratRepository = contratRepository;
        this.clientRepository = clientRepository;
    }

    public List<Contrat> getListeContrats(){
        List<Contrat> allContrats = new ArrayList<>();
        Iterable<Contrat> allContratsIterable = this.contratRepository.findAll();

//        allContratsIterable.forEach(contrat -> allContrats.add(contrat));
        allContratsIterable.forEach(allContrats::add);

        return allContrats;
    }

    public Integer getIdClient(String email, String token){
        return clientRepository.findByEmailAndToken(email, token).get(0).getId_client();
    }

    public Contrat getContratByIdClient(int idClient) throws Exception {
        return clientRepository.findById(idClient).orElseThrow(() -> new Exception("Client inexistant en base.")).getContrat();
    }


}
