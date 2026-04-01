package com.example.demo.Model;
import com.example.demo.Enum.Statut;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate dateCommande;
    private Statut statut;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;
    @OneToMany(mappedBy = "commande",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<LigneCommande > ligneCommandes;

    public Commande() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public List<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", dateCommande=" + dateCommande +
                ", statut=" + statut +
                ", client=" + client +
                ", ligneCommandes=" + ligneCommandes +
                '}';
    }
}
