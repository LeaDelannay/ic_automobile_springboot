package com.epsi.ic_automobile.api.service;

import com.epsi.ic_automobile.api.repository.ArticleRepository;
import com.epsi.ic_automobile.api.repository.ClientRepository;
import com.epsi.ic_automobile.api.repository.ContratRepository;
import com.epsi.ic_automobile.model.Article;
import com.epsi.ic_automobile.model.Contrat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AutomobileService {

    private ContratRepository contratRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    public AutomobileService(ContratRepository contratRepository, ClientRepository clientRepository, ArticleRepository articleRepository) {
        this.contratRepository = contratRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }

    public List<Contrat> getListeContrats(){
        List<Contrat> allContrats = new ArrayList<>();
        Iterable<Contrat> allContratsIterable = this.contratRepository.findAll();

//        allContratsIterable.forEach(contrat -> allContrats.add(contrat));
        allContratsIterable.forEach(allContrats::add);

        return allContrats;
    }

    //connexion

    public Integer getIdClient(String email, String token){
        return clientRepository.findByEmailAndToken(email, token).get(0).getId_client();
    }

    //articles

    public List<Article> getAllArticles(){
        List<Article> articles = new ArrayList<>();
        articleRepository.findAll().forEach(articles::add);
        return articles;
    }

    //contrats

    public Contrat getContratByIdClient(int idClient){
        log.debug("id client = "+ idClient);
        return clientRepository.findById(idClient).orElseThrow().getContrat();
    }
}
