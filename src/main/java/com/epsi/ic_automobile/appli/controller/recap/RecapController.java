package com.epsi.ic_automobile.appli.controller.recap;

import com.epsi.ic_automobile.appli.service.HttpArticleService;
import com.epsi.ic_automobile.appli.service.HttpContratService;
import com.epsi.ic_automobile.model.Article;
import com.epsi.ic_automobile.model.Contrat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecapController {

    public static final float TVA = 20;
    HttpContratService httpContratService;
    HttpArticleService httpArticleService;
    public RecapController(HttpContratService httpContratService,  HttpArticleService httpArticleService) {
        this.httpContratService=httpContratService;
        this.httpArticleService=httpArticleService;
    }

    @GetMapping({"/recap"})
    public String recap(@RequestParam("id") int idClient, Model model) throws Exception {
        // avec cet id, appeler l'api pour récupérer le contrat du type
        Contrat contrat = httpContratService.getContratClient(idClient);

        // récupérer la liste des articles et leurs montants
        List<Article> articles = httpArticleService.getAllArticles();

        List<Article> articlesMaj = new ArrayList<>();

        articles.forEach(article -> {
        //(montant + montant*marge ) + (montant + montant*marge )*tva
            float montantEtMarge = article.getMontant() + article.getMontant() * (contrat.getMarge()/100);
            float montantEtmargeEtTva = montantEtMarge + montantEtMarge * (TVA/100);
            Article newArticle = new Article();
            newArticle.setId_article(article.getId_article());
            newArticle.setMontant(montantEtmargeEtTva);
            newArticle.setNom(article.getNom());
            articlesMaj.add(newArticle);
        });

        //afficher la page avec tout le récap
        model.addAttribute("contrat", contrat);
        model.addAttribute("articles", articlesMaj);
        model.addAttribute("tva", TVA);
        return "recap";
    }
}
