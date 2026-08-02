package com.example.demo.service;


import com.example.demo.Enum.Statut;
import com.example.demo.dto.commande.CommandeRequestDTO;
import com.example.demo.dto.commande.CommandeResponseDTO;
import com.example.demo.dto.lignecommande.LigneCommandeRequestDTO;
import com.example.demo.dto.lignecommande.LigneCommandeResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommandeService {

    Page<CommandeResponseDTO> findAllCommandes(Pageable pageable);

    CommandeResponseDTO findCommandeById(Long id);

    long countCommandes();

    Page<CommandeResponseDTO>findCommandesByClientId(Long clientId, Pageable pageable);

    LigneCommandeResponseDTO addProduct(Long orderId, LigneCommandeRequestDTO dto);

    CommandeResponseDTO updateStatus(Long id, Statut statut);

    CommandeResponseDTO addCommande(CommandeRequestDTO dto);

}