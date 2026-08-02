package com.example.demo.controller;

import com.example.demo.dto.produit.ProduitRequestDTO;
import com.example.demo.dto.produit.ProduitResponseDTO;
import com.example.demo.entity.Produit;
import com.example.demo.service.ProduitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;


    @GetMapping
    public List<ProduitResponseDTO> getAllProducts(){
        return produitService.findAllProducts();
    }

    @GetMapping("/{id}")
    public ProduitResponseDTO getProductById(@PathVariable Long id){
        return produitService.findProductById(id);
    }

    @PostMapping
    public ProduitResponseDTO CreateProduct(@Valid @RequestBody ProduitRequestDTO produit){
        return produitService.addProduct(produit);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
         produitService.deleteProductById(id);
    }

    @GetMapping("/category/{category}")
    public List<ProduitResponseDTO> getProductByCategory(@PathVariable String category){
        return produitService.findProductsByCategory(category);
    }

    @GetMapping("/price/{prix}")
    public List<ProduitResponseDTO>getProductsByPriceLessThan(@PathVariable double prix){
     return produitService.findProductsByPriceLessThan(prix);
    }

    @GetMapping("/statistics/top-product")
    public ProduitResponseDTO TopProduit(){
        return produitService.getTopProduct();
    }

    @GetMapping("/low-stock")
    public List<ProduitResponseDTO> getProductsByLowStock(@RequestParam int seuil){
        return produitService.findLowStock(seuil);
    }
}
