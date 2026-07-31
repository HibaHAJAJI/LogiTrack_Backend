package com.example.demo.service;

import com.example.demo.dto.ajouterProduitCommandeDto;
import com.example.demo.Enum.Statut;
import com.example.demo.entity.Client;
import com.example.demo.entity.Commande;


import com.example.demo.entity.LigneCommande;
import com.example.demo.entity.Produit;
import com.example.demo.repositorie.ClientRepos;
import com.example.demo.repositorie.CommandeRepos;
import com.example.demo.repositorie.LigneCommandeRepos;
import com.example.demo.repositorie.ProduitRepos;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class CommandeService {


    private final CommandeRepos commandeRepos;
    private final ProduitRepos produitRepos;
    private final ClientRepos clientRepos;
    private final LigneCommandeRepos ligneCommandeRepos;

    public CommandeService(CommandeRepos commandeRepos, ProduitRepos produitRepos, ClientRepos clientRepos, LigneCommandeRepos ligneCommandeRepos) {
        this.commandeRepos = commandeRepos;
        this.produitRepos = produitRepos;
        this.clientRepos = clientRepos;
        this.ligneCommandeRepos = ligneCommandeRepos;
    }


    public List<Commande> afficherCommandes(){
        return commandeRepos.findAll();
    }

    public Optional<Commande>consulterParId(Long id){
        return commandeRepos.findCommandeById(id);
    }
    public long countCommandes(){
        return commandeRepos.count();
    }

    public  List<Commande>rechercheParClientId(Long clientId){
        return commandeRepos.findCommandeByClientId(clientId);
    }
    public Commande creerCommande(Long clientId)throws Exception{
        Client client=clientRepos.findClientById(clientId)
                .orElseThrow(()->new Exception("Client introvable"));
        Commande commande=new Commande();
        commande.setClient(client);
        commande.setDateCommande(LocalDate.now());
        commande.setStatut(Statut.EN_ATTENTE);
        return commandeRepos.save(commande);
    }

    public LigneCommande ajouterProduit(Long orderId,ajouterProduitCommandeDto produits)throws Exception{
        Commande commande=commandeRepos.findCommandeById(orderId)
                .orElseThrow(()->new Exception("Commande introvable"));
        Produit produit=produitRepos.findProduitById(produits.getProduitId())
                .orElseThrow(()->new Exception("Produit introvable"));

        LigneCommande ligne=new LigneCommande();
        ligne.setCommande(commande);
        ligne.setProduit(produit);
        ligne.setQuantite(produits.getQuantite());

        return ligneCommandeRepos.save(ligne);
    }

    public Commande updateStatus(Long id, Statut statut) throws Exception {
        Commande commande =commandeRepos.findCommandeById(id)
                .orElseThrow(()->new Exception("Commande introvable"));
        commande.setStatut(statut);
        return commandeRepos.save(commande);
    }
}