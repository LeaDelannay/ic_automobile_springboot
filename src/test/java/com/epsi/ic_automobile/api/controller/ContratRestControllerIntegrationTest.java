package com.epsi.ic_automobile.api.controller;

import com.epsi.ic_automobile.model.Contrat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;


import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContratRestControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ArticlesRestController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    @Sql(
            scripts = "/sql/data.sql",
            config = @SqlConfig(commentPrefix = "#", separator = ";")
    )
    void doitRecupererLeContrat() throws Exception {

        int id = 1;

        ResponseEntity<Contrat> response = this.restTemplate.getForEntity("http://localhost:" + port + "/api/contrat/client?id="+id, Contrat.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody().getNom()).isNotEmpty();
        assertThat(response.getBody().getNom()).isEqualTo("cc5");
        assertThat(response.getBody().getMarge()).isEqualTo(5.0f);

    }

}
