package com.example.demo.DTO;


public class ajouterProduitCommandeDto {
    private Long produitId;
    private int quantite;

    public ajouterProduitCommandeDto(Long produitId, int quantite) {
        this.produitId = produitId;
        this.quantite = quantite;
    }
    public ajouterProduitCommandeDto(){}

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
