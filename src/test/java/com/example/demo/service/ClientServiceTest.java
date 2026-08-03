package com.example.demo.service;

import com.example.demo.dto.client.ClientRequestDTO;
import com.example.demo.dto.client.ClientResponseDTO;
import com.example.demo.entity.Client;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.repository.ClientRepos;
import com.example.demo.service.ServiceImpl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepos clientRepos;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    void shouldAddClient() {

        ClientRequestDTO request = new ClientRequestDTO( "Hiba", "hiba@gmail.com", "0600000000", "Beni Mellal");

        Client client = new Client();
        ClientResponseDTO response = new ClientResponseDTO(1L, "Hiba", "hiba@gmail.com", "0600000000", "Beni Mellal");

        when(clientMapper.toEntity(request)).thenReturn(client);
        when(clientRepos.save(client)).thenReturn(client);
        when(clientMapper.toDto(client)).thenReturn(response);

        ClientResponseDTO result = clientService.addClient(request);

        assertEquals("Hiba", result.getNom());
        assertEquals("hiba@gmail.com", result.getEmail());

    }

    @Test
    void shouldFindAllClients() {
/*
        Client client = new Client();

        ClientResponseDTO response = new ClientResponseDTO(1L, "Hiba", "hiba@gmail.com", "0600000000", "Beni Mellal");

        when(clientRepos.findAll()).thenReturn(List.of(client));

        when(clientMapper.toDtoList(List.of(client))).thenReturn(List.of(response));

        Page<ClientResponseDTO> result = clientService.findAllClients(Pageable.unpaged());

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Hiba", result.get(0).getNom());*/

    }

    @Test
    void shouldFindById() {

        Long id = 1L;

        Client client = new Client();

        ClientResponseDTO response = new ClientResponseDTO(1L, "Hiba", "hiba@gmail.com", "0600000000", "Beni Mellal");

        when(clientRepos.findById(id)).thenReturn(Optional.of(client));

        when(clientMapper.toDto(client)).thenReturn(response);

        ClientResponseDTO result = clientService.findById(id);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Hiba", result.getNom());

    }

    @Test
    void shouldDeleteById() {

        Long id = 1L;

        when(clientRepos.existsById(id)).thenReturn(true);

        clientService.deleteById(id);
    }
}