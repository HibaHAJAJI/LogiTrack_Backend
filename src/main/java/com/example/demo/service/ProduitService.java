package com.example.demo.service;


import com.example.demo.dto.produit.ProduitRequestDTO;
import com.example.demo.dto.produit.ProduitResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProduitService {

    ProduitResponseDTO addProduct(ProduitRequestDTO dto);

    Page<ProduitResponseDTO> findAllProducts(Pageable pageable);

    ProduitResponseDTO findProductById(Long id);

    void deleteProductById(Long id);

    Page<ProduitResponseDTO> findProductsByCategory(String categorie, Pageable pageable);

    Page<ProduitResponseDTO> findProductsByPriceLessThan(double prix, Pageable pageable);

    Page<ProduitResponseDTO> findLowStock(int seuil, Pageable pageable);

   Page <ProduitResponseDTO> getTopProduct(Pageable pageable);

}