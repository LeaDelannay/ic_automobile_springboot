package com.epsi.ic_automobile.controller;

import com.epsi.ic_automobile.model.Contrat;
import com.epsi.ic_automobile.service.AutomobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
class AccueilController {

    @Autowired
    private AutomobileService automobileService;

    @GetMapping({"/", "/accueil"})
    public String accueil(Model model) {
        List<Contrat> listeContrats = automobileService.getListeContrats();
        model.addAttribute("listeContrats", listeContrats);
        return "accueil";
    }
}
