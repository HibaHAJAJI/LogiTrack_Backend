package com.example.demo.service.ServiceImpl;


import com.example.demo.Enum.Statut;
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
import com.example.demo.repositorie.ClientRepos;
import com.example.demo.repositorie.CommandeRepos;
import com.example.demo.repositorie.LigneCommandeRepos;
import com.example.demo.repositorie.ProduitRepos;
import com.example.demo.service.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {

    private final CommandeRepos commandeRepos;
    private final ProduitRepos produitRepos;
    private final ClientRepos clientRepos;
    private final LigneCommandeRepos ligneCommandeRepos;
    private final CommandeMapper commandeMapper;
    private final LigneCommandeMapper ligneCommandeMapper;


    public List<CommandeResponseDTO> findAllCommandes(){
        return commandeMapper.toDtoList(commandeRepos.findAll());
    }

    public CommandeResponseDTO findCommandeById(Long id){
        Commande commande=commandeRepos.findById(id)
                .orElseThrow(()->new RuntimeException("Commande introuvable !"));
        return commandeMapper.toDto(commande);
    }

    public long countCommandes(){
        return commandeRepos.count();
    }

    public  List<CommandeResponseDTO>findCommandesByClientId(Long clientId){
        return commandeMapper.toDtoList(commandeRepos.findByClientId(clientId));
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

        return ligneCommandeMapper.toDto(ligneCommandeRepos.save(ligne));
    }

    public CommandeResponseDTO updateStatus(Long id, Statut statut){
        Commande commande =commandeRepos.findById(id)
                .orElseThrow(()->new RuntimeException("Commande introvable"));
        commande.setStatut(statut);
        return commandeMapper.toDto(commandeRepos.save(commande));
    }
}
