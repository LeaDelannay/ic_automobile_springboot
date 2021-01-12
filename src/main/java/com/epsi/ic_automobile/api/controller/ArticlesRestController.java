package com.epsi.ic_automobile.api.controller;

import com.epsi.ic_automobile.api.repository.ArticleRepository;
import com.epsi.ic_automobile.api.service.AutomobileService;
import com.epsi.ic_automobile.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/article")
public class ArticlesRestController {

    AutomobileService automobileService;

    public ArticlesRestController(AutomobileService automobileService) {
        this.automobileService = automobileService;
    }

    @GetMapping("/all")
    public List<Article> getAllArticles(){
        return automobileService.getAllArticles();
    }
}
