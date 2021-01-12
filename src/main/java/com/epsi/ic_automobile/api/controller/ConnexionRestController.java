package com.epsi.ic_automobile.api.controller;

import com.epsi.ic_automobile.api.service.AutomobileService;
import com.epsi.ic_automobile.appli.controller.connexion.ConnexionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/connexion")
public class ConnexionRestController {

    AutomobileService automobileService;

    public ConnexionRestController(AutomobileService automobileService) {
        this.automobileService = automobileService;
    }

    @PostMapping(path="/")
    public Integer seConnecter(@RequestBody ConnexionDto connexionDto) {
        log.debug("connexion from internal api : email="+connexionDto.getEmail()+" token="+connexionDto.getToken());
        return automobileService.getIdClient(connexionDto.getEmail(), connexionDto.getToken());
    }

}
