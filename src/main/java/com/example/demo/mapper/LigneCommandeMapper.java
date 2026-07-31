package com.example.demo.mapper;


import com.example.demo.dto.lignecommande.LigneCommandeRequestDTO;
import com.example.demo.dto.lignecommande.LigneCommandeResponseDTO;
import com.example.demo.entity.LigneCommande;
import org.mapstruct.Mapper;

@Mapper(componentModel= "spring")
public interface LigneCommandeMapper {

    LigneCommande toEntity(LigneCommandeRequestDTO dto);

    LigneCommandeResponseDTO toDto(LigneCommande ligneCommande);
}
