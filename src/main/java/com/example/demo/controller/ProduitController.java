package com.example.demo.controller;

import com.example.demo.dto.produit.ProduitRequestDTO;
import com.example.demo.dto.produit.ProduitResponseDTO;
import com.example.demo.service.ProduitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;


    @GetMapping
    public ResponseEntity<Page<ProduitResponseDTO>> getAllProducts(Pageable pageable){
        return ResponseEntity.ok(produitService.findAllProducts(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitResponseDTO> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(produitService.findProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProduitResponseDTO> CreateProduct(@Valid @RequestBody ProduitRequestDTO produit){
        return ResponseEntity.ok(produitService.addProduct(produit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
         produitService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<Page<ProduitResponseDTO>> getProductByCategory(@PathVariable String category, Pageable pageable){
        return ResponseEntity.ok(produitService.findProductsByCategory(category, pageable));
    }

    @GetMapping("/price/{prix}")
    public ResponseEntity<Page<ProduitResponseDTO>> getProductsByPriceLessThan(@PathVariable double prix, Pageable pageable){
     return ResponseEntity.ok(produitService.findProductsByPriceLessThan(prix, pageable));
    }

    @GetMapping("/statistics/top-product")
    public ResponseEntity<Page<ProduitResponseDTO>> TopProduit(Pageable pageable){
        return ResponseEntity.ok(produitService.getTopProduct(pageable));
    }

    @GetMapping("/low-stock")
    public ResponseEntity<Page<ProduitResponseDTO>> getProductsByLowStock(@RequestParam int seuil,Pageable pageable){
        return ResponseEntity.ok(produitService.findLowStock(seuil, pageable));
    }
}
