package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String categorie;
    private double prix;
    private  int quantiteStock;
    @OneToMany(mappedBy = "produit",cascade = CascadeType.ALL)
    @JsonIgnore
    List<LigneCommande >LigneCommande;

    public Produit( String nom, String categorie, double prix, int quantiteStock) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
    }

    public Produit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", categorie='" + categorie + '\'' +
                ", prix=" + prix +
                ", quantiteStock=" + quantiteStock +
                '}';
    }
}
