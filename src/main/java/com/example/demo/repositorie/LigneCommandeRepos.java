package com.example.demo.repositorie;

import com.example.demo.entity.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepos extends JpaRepository<LigneCommande,Long> {
}
