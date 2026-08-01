package com.example.demo.repositorie;

import com.example.demo.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepos extends JpaRepository<Produit,Long> {

    List<Produit> findByCategorie(String categorie);

    List<Produit> findByPrixLessThan(double prix);

    @Query("select p from Produit p where p.quantiteStock< :seuil ")
    List<Produit> findLowStock(@Param("seuil") int seuil);

    @Query(" SELECT ligne.produit FROM LigneCommande ligne GROUP BY ligne.produit ORDER BY SUM(ligne.quantite) DESC")
    List<Produit>findTopProduct();

}
