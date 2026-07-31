package com.example.demo.mapper;


import com.example.demo.dto.client.ClientRequestDTO;
import com.example.demo.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel= "spring")
public interface ClientMapper {

    Client toEntity(ClientRequestDTO dto);

    ClientRequestDTO toDto(Client client);
}
