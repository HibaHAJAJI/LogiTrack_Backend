package com.example.demo.dto.produit;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitRequestDTO {

    @NotBlank(message = "Le nom du produit ne peut pas être vide")
    private String nom;

    @NotBlank(message = "La catégorie du produit ne peut pas être vide")
    private String categorie;

    @Positive(message = "Le prix doit être un nombre positif")
    private double prix;

    @Min(value = 1, message = "La quantité en stock ne peut pas être négative")
    private  int quantiteStock;

}
