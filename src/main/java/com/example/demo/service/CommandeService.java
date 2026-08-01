package com.example.demo.service;


import com.example.demo.Enum.Statut;
import com.example.demo.dto.commande.CommandeRequestDTO;
import com.example.demo.dto.commande.CommandeResponseDTO;
import com.example.demo.dto.lignecommande.LigneCommandeRequestDTO;
import com.example.demo.dto.lignecommande.LigneCommandeResponseDTO;

import java.util.List;

public interface CommandeService {

    List<CommandeResponseDTO> findAllCommandes();

    CommandeResponseDTO findCommandeById(Long id);

    long countCommandes();

    List<CommandeResponseDTO>findCommandesByClientId(Long clientId);

    LigneCommandeResponseDTO addProduct(Long orderId, LigneCommandeRequestDTO dto);

    CommandeResponseDTO updateStatus(Long id, Statut statut);

    CommandeResponseDTO addCommande(CommandeRequestDTO dto);

}