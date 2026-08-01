package com.example.demo.repositorie;

import com.example.demo.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommandeRepos extends JpaRepository<Commande,Long> {

    List<Commande> findByClientId(Long clientId);

    @Query("SELECT COUNT(c) FROM Commande c")
    long countCommande();

}
