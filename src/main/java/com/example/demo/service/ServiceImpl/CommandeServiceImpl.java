package com.example.demo.service.ServiceImpl;


import com.example.demo.enums.Statut;
import com.example.demo.dto.commande.CommandeRequestDTO;
import com.example.demo.dto.commande.CommandeResponseDTO;
import com.example.demo.dto.lignecommande.LigneCommandeRequestDTO;
import com.example.demo.dto.lignecommande.LigneCommandeResponseDTO;
import com.example.demo.entity.Client;
import com.example.demo.entity.Commande;
import com.example.demo.entity.LigneCommande;
import com.example.demo.entity.Produit;
import com.example.demo.mapper.CommandeMapper;
import com.example.demo.mapper.LigneCommandeMapper;
import com.example.demo.repository.ClientRepos;
import com.example.demo.repository.CommandeRepos;
import com.example.demo.repository.LigneCommandeRepos;
import com.example.demo.repository.ProduitRepos;
import com.example.demo.service.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {

    private final CommandeRepos commandeRepos;
    private final ProduitRepos produitRepos;
    private final ClientRepos clientRepos;
    private final LigneCommandeRepos ligneCommandeRepos;
    private final CommandeMapper commandeMapper;
    private final LigneCommandeMapper ligneCommandeMapper;


    public Page<CommandeResponseDTO> findAllCommandes(Pageable pageable){
        return commandeRepos.findAll(pageable).map(commandeMapper::toDto);
    }

    public CommandeResponseDTO findCommandeById(Long id){
        Commande commande=commandeRepos.findById(id)
                .orElseThrow(()->new RuntimeException("Commande introuvable !"));
        return commandeMapper.toDto(commande);
    }

    public long countCommandes(){
        return commandeRepos.count();
    }

    public  Page<CommandeResponseDTO>findCommandesByClientId(Long clientId, Pageable pageable){
        return commandeRepos.findByClientId(clientId, pageable).map(commandeMapper::toDto);
    }

    public CommandeResponseDTO addCommande(CommandeRequestDTO dto){

        Client client=clientRepos.findById(dto.getClientId())
                .orElseThrow(()->new RuntimeException("Client introuvable"));

        Commande commande=commandeMapper.toEntity(dto);
        commande.setClient(client);
        commande.setDateCommande(LocalDate.now());
        commande.setStatut(Statut.EN_ATTENTE);

        return commandeMapper.toDto(commandeRepos.save(commande));
    }

    public LigneCommandeResponseDTO addProduct(Long orderId, LigneCommandeRequestDTO dto){

        Commande commande=commandeRepos.findById(orderId)
                .orElseThrow(()->new RuntimeException("Commande introuvable"));

        Produit produit=produitRepos.findById(dto.getProduitId())
                .orElseThrow(()->new RuntimeException("Produit introuvable"));

        LigneCommande ligne=ligneCommandeMapper.toEntity(dto);
        ligne.setCommande(commande);
        ligne.setProduit(produit);
        ligne.setQuantite(dto.getQuantite());

        return ligneCommandeMapper.toDto(ligneCommandeRepos.save(ligne));
    }

    public CommandeResponseDTO updateStatus(Long id, Statut statut){
        Commande commande =commandeRepos.findById(id)
                .orElseThrow(()->new RuntimeException("Commande introvable"));
        commande.setStatut(statut);
        return commandeMapper.toDto(commandeRepos.save(commande));
    }

    public Page<LigneCommandeResponseDTO> getProducts(Long orderId, Pageable pageable) {

        commandeRepos.findById(orderId).orElseThrow(() ->
                        new RuntimeException("Commande introuvable"));

        return ligneCommandeRepos
                .findByCommandeId(orderId, pageable)
                .map(ligneCommandeMapper::toDto);
    }
}
