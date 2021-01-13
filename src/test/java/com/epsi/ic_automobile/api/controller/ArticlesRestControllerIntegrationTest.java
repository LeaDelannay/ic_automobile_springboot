package com.epsi.ic_automobile.api.controller;

import com.epsi.ic_automobile.model.Article;
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
class ArticlesRestControllerIntegrationTest {

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
    void doitRecupererLesArticles() throws Exception {

        ResponseEntity<Article[]> response = this.restTemplate.getForEntity("http://localhost:" + port + "/api/article/all",
                Article[].class);

        assertThat(response.getBody()).isNotEmpty();
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody().length==10);
        assertThat(response.getBody()[0].getNom()).isEqualTo("Injecteur");
    }

}
