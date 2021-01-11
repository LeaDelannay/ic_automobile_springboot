package com.epsi.ic_automobile.appli.controller.accueil;

import com.epsi.ic_automobile.appli.controller.connexion.ConnexionDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class AccueilController {

    @GetMapping({"/", "/accueil"})
    public String accueil(ConnexionDto connexionDto, Model model) {
        return "formulaireConnexion";
    }
}
