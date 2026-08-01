package com.example.demo.controller;

import com.example.demo.dto.ajouterProduitCommandeDto;
import com.example.demo.Enum.Statut;
import com.example.demo.entity.Commande;
import com.example.demo.entity.LigneCommande;
import com.example.demo.service.CommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class CommandeController {
/*
    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }


    @GetMapping
    public List<Commande>afficherTous(){
        return commandeService.afficherCommandes();
    }

    @GetMapping("{id}")
    public Optional<Commande>consulterId(@PathVariable Long id){
        return commandeService.consulterParId(id);
    }

    @GetMapping("client/{clientId}")
    private List<Commande>findByClientId(@PathVariable Long clientId){
        return commandeService.rechercheParClientId(clientId);
    }

    @GetMapping("/count")
    public long NumbreCommandes(){
        return commandeService.countCommandes();
    }
    @PostMapping
    public Commande addCommandeClient(@RequestParam Long clientId) throws Exception {
        return commandeService.creerCommande(clientId);
    }
    @PostMapping("/{orderId}/products")
    public ResponseEntity<LigneCommande> addProduit(@PathVariable Long orderId, @RequestBody ajouterProduitCommandeDto produits )throws Exception{
        LigneCommande ligne =commandeService.ajouterProduit(orderId,produits);
        return ResponseEntity.ok(ligne);
    }
    @PutMapping("/{id}/status")
    public Commande modiferStatus(@PathVariable Long id,@RequestBody Statut statut) throws Exception {
        return commandeService.updateStatus(id, statut);
    }*/
}