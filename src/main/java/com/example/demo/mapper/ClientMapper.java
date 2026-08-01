package com.example.demo.mapper;


import com.example.demo.dto.client.ClientRequestDTO;
import com.example.demo.dto.client.ClientResponseDTO;
import com.example.demo.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel= "spring")
public interface ClientMapper {

    Client toEntity(ClientRequestDTO dto);

    ClientResponseDTO toDto(Client client);

    List<ClientResponseDTO> toDtos(List<Client> clients);
}
