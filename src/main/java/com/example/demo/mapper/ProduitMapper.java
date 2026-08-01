package com.example.demo.mapper;


import com.example.demo.dto.produit.ProduitRequestDTO;
import com.example.demo.dto.produit.ProduitResponseDTO;
import com.example.demo.entity.Produit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel= "spring")
public interface ProduitMapper {

    Produit toEntity(ProduitRequestDTO dto);

    ProduitResponseDTO toDto(Produit produit);

    List<ProduitResponseDTO> toDtoList(List<Produit> produits);

}
