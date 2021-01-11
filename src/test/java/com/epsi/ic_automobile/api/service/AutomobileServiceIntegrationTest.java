package com.epsi.ic_automobile.api.service;

import com.epsi.ic_automobile.model.Contrat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class AutomobileServiceIntegrationTest {

    @Autowired
    private AutomobileService automobileService;

    @Test
    @Sql(
            scripts = "/sql/data.sql",
            config = @SqlConfig(commentPrefix = "#", separator = ";")
    )
    public void doitRecupererListeContrats(){
        List<Contrat> listeContrats = automobileService.getListeContrats();
        assertThat(listeContrats.size()).isEqualTo(5);
        assertThat(listeContrats.size()).isNotEqualTo(6);

    }

}
