package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ligne_commande")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantite;

   @ManyToOne
   @JoinColumn(name = "commande_id")
   private Commande commande;

   @ManyToOne
   @JoinColumn(name="produit_id")
    private Produit produit;

}
