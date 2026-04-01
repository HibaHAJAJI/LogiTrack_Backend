package com.example.demo.Repositorie;

import com.example.demo.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommandeRepos extends JpaRepository<Commande,Long> {
    Optional<Commande>findCommandeById(Long id);

    List<Commande> findCommandeByClientId(Long clientId);

    @Query("select count(c) from Commande c")
    long countCommande();
}
