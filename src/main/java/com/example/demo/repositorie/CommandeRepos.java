package com.example.demo.repositorie;

import com.example.demo.entity.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommandeRepos extends JpaRepository<Commande,Long> {

    Page<Commande> findByClientId(Long clientId, Pageable pageable);

}
