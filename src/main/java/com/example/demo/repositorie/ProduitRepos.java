package com.example.demo.repositorie;

import com.example.demo.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProduitRepos extends JpaRepository<Produit,Long> {
    Optional<Produit>findProduitById(Long id);
    void deleteById(Long id);

    List<Produit> findProduitByCategorie(String categorie);

    List<Produit> findProduitByPrixLessThan(double prix);

    @Query("select p from Produit p where p.quantiteStock< :seuil ")
    List<Produit> findLowStock(@Param("seuil") int seuil);

    @Query("select  ligne from LigneCommande ligne group by ligne.produit order by  sum (ligne.quantite)desc ")
    Produit findToProduit();


@Query("select p from Produit p where p.quantiteStock =:quantite")
    List<Produit>findProduitByQuantite(@Param("quantite")int quantite);
}
