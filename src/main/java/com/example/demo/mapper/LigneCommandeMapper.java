package com.example.demo.mapper;


import com.example.demo.dto.lignecommande.LigneCommandeRequestDTO;
import com.example.demo.dto.lignecommande.LigneCommandeResponseDTO;
import com.example.demo.entity.LigneCommande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel= "spring")
public interface LigneCommandeMapper {

    LigneCommande toEntity(LigneCommandeRequestDTO dto);

    @Mapping(source = "commande.id", target = "commandeId")
    @Mapping(source = "produit.id", target = "produitId")
    LigneCommandeResponseDTO toDto(LigneCommande ligneCommande);
}
