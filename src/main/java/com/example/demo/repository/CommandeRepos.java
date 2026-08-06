package com.example.demo.repository;

import com.example.demo.entity.Commande;
import com.example.demo.enums.Statut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface CommandeRepos extends JpaRepository<Commande,Long> {

    Page<Commande> findByClientId(Long clientId, Pageable pageable);

    long countByStatut(Statut statut);

    @Query("select c from Commande c order by c.dateCommande desc ")
    Page<Commande> findRecentCommandes(Pageable pageable);
}
