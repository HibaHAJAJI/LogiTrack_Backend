package com.example.demo.service;


import com.example.demo.dto.client.ClientRequestDTO;
import com.example.demo.dto.client.ClientResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ClientService {


    ClientResponseDTO addClient(ClientRequestDTO dto);

    Page<ClientResponseDTO> findAllClients(Pageable pageable);

    ClientResponseDTO findById(Long id);

    void deleteById(Long id);
}
