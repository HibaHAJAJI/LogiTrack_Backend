package com.example.demo.Service;

import com.example.demo.Model.Produit;
import com.example.demo.Repositorie.ProduitRepos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private final ProduitRepos repos;

    public ProduitService(ProduitRepos repos) {
        this.repos = repos;
    }


    public Produit ajouterProduit(Produit produit){
        return repos.save(produit);
    }

    public List<Produit> afficherProduits(){
        return repos.findAll();
    }

    public List<Produit>RechercheProduitParCategorie(String categorie){
        return repos.findProduitByCategorie(categorie);
    }
    public List<Produit>RechercheProduitParPrixInferieur(double prix){
        return repos.findProduitByPrixLessThan(prix);
    }

    public List<Produit>getProduitsByPrixInferieur(int seuil){
        return repos.findProduitByPrixLessThan(seuil);
    }
    public Produit getTopProduit(){
        return repos.findToProduit();
    }

    public Optional<Produit>ConsulterParId(Long id){
        return repos.findProduitById(id);
    }
    public void SupprimerParId(Long id){
        Optional<Produit>produit=repos.findProduitById(id);
        if(produit.isPresent()){
            repos.deleteById(id);
        }else {
            throw new RuntimeException("Produit introvable");
        }

    }

    public List<Produit>findProduitbyQuantites(int quantite){
        return repos.findProduitByQuantite(quantite);
    }
}
