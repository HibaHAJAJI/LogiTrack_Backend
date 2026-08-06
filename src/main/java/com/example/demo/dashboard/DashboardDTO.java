package com.example.demo.dashboard;


import com.example.demo.dto.commande.CommandeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDTO {

    private Long totalClients;
    private Long totalProduits;
    private Long totalCommandes;

    private Long commandesEnAttente;
    private Long commandesExpediees;
    private Long commandesLivrees;

    private Long produitsStockFaible;

    private String produitPlusCommande;

    private List<CommandeResponseDTO> commandesRecents;
}
