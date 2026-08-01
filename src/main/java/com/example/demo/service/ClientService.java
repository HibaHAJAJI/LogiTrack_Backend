package com.example.demo.service;


import com.example.demo.dto.client.ClientRequestDTO;
import com.example.demo.dto.client.ClientResponseDTO;

import java.util.List;


public interface ClientService {

    ClientResponseDTO addClient(ClientRequestDTO dto);

    List<ClientResponseDTO> findAllClients();

    ClientResponseDTO findById(Long id);

    void deleteById(Long id);
}
