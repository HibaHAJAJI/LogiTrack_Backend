package com.example.demo.dto.produit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitResponseDTO {

    private Long id;

    private String nom;

    private String categorie;

    private double prix;

    private  int quantiteStock;

}
