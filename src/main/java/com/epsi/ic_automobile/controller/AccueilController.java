package com.epsi.ic_automobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class AccueilControleur {

    @GetMapping({"/", "/accueil"})
    public String accueil() {
        return "accueil";
    }

}
