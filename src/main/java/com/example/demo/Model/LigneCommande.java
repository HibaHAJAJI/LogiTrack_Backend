package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="ligne_commande")
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
   @JsonIgnore
    private Produit produit;

    public LigneCommande( int quantite) {
        this.quantite = quantite;
    }

    public LigneCommande() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "LigneCommande{" +
                "id=" + id +
                ", quantite=" + quantite +
                '}';
    }
}
