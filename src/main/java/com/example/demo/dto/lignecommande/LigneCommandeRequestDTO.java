package com.example.demo.dto.lignecommande;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommandeRequestDTO {

    private int quantite;

    private Long commandeId;

    private Long produitId;
}
