package com.example.demo.dto.lignecommande;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommandeRequestDTO {

    @Min(value = 1, message = "La quantité doit être supérieure à 0")
    private int quantite;

    @NotNull(message = "La commande est obligatoire")
    private Long commandeId;

    @NotNull(message = "Le produit est obligatoire")
    private Long produitId;
}
