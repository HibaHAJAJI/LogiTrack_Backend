package com.example.demo.repository;

import com.example.demo.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProduitRepos extends JpaRepository<Produit,Long> {

    Page<Produit> findByCategorie(String categorie, Pageable pageable);

    Page<Produit> findByPrixLessThan(double prix, Pageable pageable);

    @Query("select p from Produit p where p.quantiteStock< :seuil ")
    Page<Produit> findLowStock(@Param("seuil") int seuil,Pageable pageable);

    @Query(" SELECT ligne.produit FROM LigneCommande ligne GROUP BY ligne.produit ORDER BY SUM(ligne.quantite) DESC")
    Page<Produit>findTopProduct();

}
