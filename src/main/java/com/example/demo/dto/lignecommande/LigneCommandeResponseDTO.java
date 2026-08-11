package com.example.demo.dto.lignecommande;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommandeResponseDTO {

    private Long id;

    private int quantite;

    private Long commandeId;

    private Long produitId;

    private List<LigneCommandeResponseDTO> lignes;

}
