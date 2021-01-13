package com.epsi.ic_automobile.api.service;

import com.epsi.ic_automobile.api.repository.ArticleRepository;
import com.epsi.ic_automobile.api.repository.ClientRepository;
import com.epsi.ic_automobile.api.repository.ContratRepository;
import com.epsi.ic_automobile.model.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @Test
    public void doitRecupererListeContrats(){
        //Given
        when(contratRepository.findAll()).thenReturn(new ArrayList<>());

        //When
        int resultSize = automobileService.getListeContrats().size();

        //Then
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

}
