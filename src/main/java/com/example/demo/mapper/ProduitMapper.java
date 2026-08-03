package com.example.demo.mapper;


import com.example.demo.dto.produit.ProduitRequestDTO;
import com.example.demo.dto.produit.ProduitResponseDTO;
import com.example.demo.entity.Produit;
import org.mapstruct.Mapper;


@Mapper(componentModel= "spring")
public interface ProduitMapper {

    Produit toEntity(ProduitRequestDTO dto);

    ProduitResponseDTO toDto(Produit produit);

}
