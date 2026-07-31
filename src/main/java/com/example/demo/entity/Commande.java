package com.example.demo.entity;
import com.example.demo.Enum.Statut;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "commande")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateCommande;

    private Statut statut;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    @OneToMany(mappedBy = "commande",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<LigneCommande > ligneCommandes;

}
