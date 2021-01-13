package com.epsi.ic_automobile.api.service;

import com.epsi.ic_automobile.api.repository.ArticleRepository;
import com.epsi.ic_automobile.api.repository.ClientRepository;
import com.epsi.ic_automobile.api.repository.ContratRepository;
import com.epsi.ic_automobile.model.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith( MockitoExtension.class)
class AutomobileServiceTest {

    @Mock
    private ContratRepository contratRepository;
    @Mock
    private ArticleRepository articleRepository;
    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private AutomobileService automobileService;

    private static Stream<Arguments> chargerDonneesTest() {
        return Stream.of(
                Arguments.of(1, "client1@ici.fr", "token1"),
                Arguments.of(2, "client2@ici.fr", "token2"),
                Arguments.of(3, "client3@ici.fr", "token3"),
                Arguments.of(4, "client4@ici.fr", "token4"),
                Arguments.of(5,"client5@ici.fr", "token5")
        );
    }

    @Test
    public void doitRecupererListeContrats(){
        //Arrange
        when(contratRepository.findAll()).thenReturn(new ArrayList<>());

        //Act
        int resultSize = automobileService.getListeContrats().size();

        //Assert
        assertThat(resultSize).isEqualTo(0);
    }

    @Test
    public void doitRecupererLidDuClient(){
        //Arrange
        int id_client = 1;
        String email = "client1@ici.fr";
        String token = "token1";

        List<Client> listeClient = new ArrayList<>();
        Client client1 = new Client();
        client1.setId_client(id_client);
        client1.setEmail(email);
        client1.setToken(token);
        listeClient.add(client1);

        when(clientRepository.findByEmailAndToken(email, token)).thenReturn(listeClient);

        //Act
        int idClientFromService = automobileService.getIdClient(email, token);

        //Assert
        assertThat(idClientFromService).isEqualTo(id_client);
    }

    @ParameterizedTest
    @MethodSource("chargerDonneesTest")
    public void doitRecupererLidDuClientParametre(int idClient, String email, String token){
        //Arrange
        List<Client> listeClient = new ArrayList<>();
        Client client = new Client();
        client.setId_client(idClient);
        client.setEmail(email);
        client.setToken(token);
        listeClient.add(client);

        when(clientRepository.findByEmailAndToken(email, token)).thenReturn(listeClient);

        //Act
        int idClientFromService = automobileService.getIdClient(email, token);

        //Assert
        assertThat(idClientFromService).isEqualTo(idClient);
    }
}
