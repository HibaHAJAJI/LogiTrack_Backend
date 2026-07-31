package com.example.demo.controller;

import com.example.demo.entity.Produit;
import com.example.demo.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public List<Produit> afficherTous(){
        return produitService.afficherProduits();
    }

    @GetMapping("/{id}")
    public Optional<Produit>afficherUneProduit(@PathVariable Long id){
        return produitService.ConsulterParId(id);
    }

    @PostMapping
    public Produit save(@RequestBody Produit produit){
        return produitService.ajouterProduit(produit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         produitService.SupprimerParId(id);
    }

    @GetMapping("/category/{category}")
    public List<Produit>findProduitParCategorie(@PathVariable String category){
        return produitService.RechercheProduitParCategorie(category);
    }
    @GetMapping("/price/{prix}")
    public List<Produit>findProduitInfirieur(@PathVariable double prix){
     return produitService.RechercheProduitParPrixInferieur(prix);
    }
    @GetMapping("/statistics/top-product")
    public Produit TopProduit(){
        return produitService.getTopProduit();
    }
    @GetMapping("/low-stock")
    public List<Produit> afficherProduitParStockFaible(@RequestParam int prix){
        return produitService.getProduitsByPrixInferieur(prix);
    }

    @GetMapping("/quantite")
    public List<Produit>getProduitByQuantite(int quantite){
        return produitService.findProduitbyQuantites(quantite);
    }
}
