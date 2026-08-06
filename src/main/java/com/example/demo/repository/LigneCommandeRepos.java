package com.example.demo.repository;

import com.example.demo.entity.LigneCommande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LigneCommandeRepos extends JpaRepository<LigneCommande,Long> {

    @Query("select lc.produit.nom from LigneCommande lc group by lc.produit.id,lc.produit.nom order by sum(lc.quantite) desc")
    Page<String> findMostOrderedProduct(Pageable pageable);


}
