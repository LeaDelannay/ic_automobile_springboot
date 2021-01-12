package com.epsi.ic_automobile.api.controller;

import com.epsi.ic_automobile.appli.controller.connexion.ConnexionDto;
import com.epsi.ic_automobile.model.Article;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConnexionRestControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ConnexionRestController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    @Sql(
            scripts = "/sql/data.sql",
            config = @SqlConfig(commentPrefix = "#", separator = ";")
    )
    void doitRecupererLesArticles() throws Exception {


        //creation du header êrmettant l'ajout de body volumineux cf : https://www.baeldung.com/rest-template
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject jsonClientObject = new JSONObject();
        jsonClientObject.put("email","client1@ici.fr");
        jsonClientObject.put("token", "token1");

        HttpEntity<String> request = new HttpEntity<String>(jsonClientObject.toString(), headers);

        Integer response = restTemplate.postForObject("http://localhost:" + port + "/api/connexion/", request , Integer.class);

        assertThat(response).isEqualTo(1);
    }

}
