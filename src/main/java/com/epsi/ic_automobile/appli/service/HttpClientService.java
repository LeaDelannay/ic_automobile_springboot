package com.epsi.ic_automobile.appli.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class HttpClientService {

    HttpClient httpClient;

    public HttpClientService() {
        this.httpClient = HttpClient.newHttpClient();

    }

    public Integer postAuthentificationInfo(String email, String token){
            String authent = "{\"email\":\""+email+"\", \"token\":\""+token+"\"}";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8081/api/connexion/"))
                    .setHeader("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(authent))
                    .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return Integer.parseInt(response.body());

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
