package com.epsi.ic_automobile.appli.service;

import com.epsi.ic_automobile.model.Contrat;
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

@Slf4j
@Service
public class HttpContratService {

    HttpClient httpClient;
    ObjectMapper mapper;

    @Value("${server.port}")
    String port;

    public HttpContratService(ObjectMapper mapper) {
        this.mapper=mapper;
        this.httpClient = HttpClient.newHttpClient();
    }

    public Contrat getContratClient(int idClient) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:"+port+"/api/contrat/client?id="+idClient))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            log.debug("Status  : " + response.statusCode());
            log.debug("Headers : " + response.headers());
            log.debug("Body    : " + response.body());
            return mapper.readValue(response.body(), new TypeReference<Contrat>() {});
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage());
            return null;
        }
    }


}
