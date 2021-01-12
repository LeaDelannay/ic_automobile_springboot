package com.epsi.ic_automobile.appli.service;

import com.epsi.ic_automobile.model.Article;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Slf4j
@Service
public class HttpArticleService {

    HttpClient httpClient;
    ObjectMapper articleMapper;

    @Value("${server.port}")
    String port;

    public HttpArticleService(ObjectMapper articleMapper) {
        this.httpClient = HttpClient.newHttpClient();
        this.articleMapper=articleMapper;
    }

    public List<Article> getAllArticles() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:"+port+"/api/article/all"))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            log.debug("Status  : " + response.statusCode());
            log.debug("Headers : " + response.headers());
            log.debug("Body    : " + response.body());
            List<Article> articles = articleMapper.readValue(response.body(), new TypeReference<>() {});
            return articles;
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage());
            return null;
        }
    }

}
