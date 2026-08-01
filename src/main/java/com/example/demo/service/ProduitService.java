package com.example.demo.service;


import com.example.demo.dto.produit.ProduitRequestDTO;
import com.example.demo.dto.produit.ProduitResponseDTO;

import java.util.List;


public interface ProduitService {

    ProduitResponseDTO addProduct(ProduitRequestDTO dto);

    List<ProduitResponseDTO> findAllProducts();

    ProduitResponseDTO findProductById(Long id);

    void deleteProductById(Long id);

    List<ProduitResponseDTO> findProductsByCategory(String categorie);

    List<ProduitResponseDTO> findProductsByPriceLessThan(double prix);

    List<ProduitResponseDTO> findLowStock(int seuil);

    ProduitResponseDTO getTopProduct();

}