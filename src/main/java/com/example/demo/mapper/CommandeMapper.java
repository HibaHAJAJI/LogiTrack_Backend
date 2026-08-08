package com.example.demo.mapper;


import com.example.demo.dto.commande.CommandeRequestDTO;
import com.example.demo.dto.commande.CommandeResponseDTO;
import com.example.demo.entity.Commande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel= "spring")
public interface CommandeMapper {

    Commande toEntity(CommandeRequestDTO dto);

    @Mapping(source = "client.id", target = "clientId")
    CommandeResponseDTO toDto(Commande commande);

    List<CommandeResponseDTO> toDtoList(List<Commande> commandes);

}
