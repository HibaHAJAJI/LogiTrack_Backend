package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "produit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String categorie;

    private double prix;

    private  int quantiteStock;

    @OneToMany(mappedBy = "produit",cascade = CascadeType.ALL)
    @ToString.Exclude
    List<LigneCommande >LigneCommande;

}
