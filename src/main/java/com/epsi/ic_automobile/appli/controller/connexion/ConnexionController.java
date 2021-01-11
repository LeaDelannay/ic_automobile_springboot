package com.epsi.ic_automobile.appli.controller.connexion;

import com.epsi.ic_automobile.appli.service.HttpClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ConnexionController {

    HttpClientService httpClientService;

    public ConnexionController(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }

    @PostMapping("/connexion")
    public String seConnecter(@Validated ConnexionDto connexionDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "formulaireConnexion";
        }
        try {
            //appeler api pour récupérer l'id de la personne
            int idClient = httpClientService.postAuthentificationInfo(connexionDto.getEmail(), connexionDto.getToken());

            //appeler la page de récap qui va faire le reste du traitement
            return "redirect:/recap?id=" + idClient;
        } catch (Exception e) {
            log.error(e.getMessage());
            return "formulaireConnexion";
        }
    }
}
