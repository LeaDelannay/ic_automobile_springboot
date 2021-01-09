package com.epsi.ic_automobile.service;

import com.epsi.ic_automobile.repository.ContratRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith( MockitoExtension.class)
class AutomobileServiceTest {

    @Mock
    private ContratRepository contratRepository;
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
        assertTrue(true);
    }

}
