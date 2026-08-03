package com.example.demo.service.ServiceImpl;

import com.example.demo.dto.produit.ProduitRequestDTO;
import com.example.demo.dto.produit.ProduitResponseDTO;
import com.example.demo.entity.Produit;
import com.example.demo.mapper.ProduitMapper;
import com.example.demo.repository.ProduitRepos;
import com.example.demo.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProduitServiceImpl  implements ProduitService {

    private final ProduitRepos repos;
    private final ProduitMapper mapper;

    public ProduitResponseDTO addProduct(ProduitRequestDTO dto){
        Produit produit = mapper.toEntity(dto);
        return mapper.toDto(repos.save(produit));
    }

    public Page<ProduitResponseDTO> findAllProducts(Pageable pageable){
        return repos.findAll(pageable).map(mapper::toDto);
    }

    public ProduitResponseDTO findProductById(Long id){
        Produit produit=repos.findById(id).orElseThrow(()->new RuntimeException("Produit introvable"));
        return mapper.toDto(produit);
    }

    public void deleteProductById(Long id){
        if(!repos.existsById(id)){
            throw new RuntimeException("Produit introvable");
        }
        repos.deleteById(id);
    }

    public Page<ProduitResponseDTO> findProductsByCategory(String categorie, Pageable pageable){
        return repos.findByCategorie(categorie, pageable).map(mapper::toDto);
    }

    public Page<ProduitResponseDTO> findProductsByPriceLessThan(double prix, Pageable pageable){
        return repos.findByPrixLessThan(prix, pageable).map(mapper::toDto);
    }

    public Page<ProduitResponseDTO> findLowStock(int seuil, Pageable pageable){
        return repos.findLowStock(seuil, pageable).map(mapper::toDto);
    }

    public ProduitResponseDTO getTopProduct(){
        Produit produit = repos.findTopProduct().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucun produit trouvé"));
        return mapper.toDto(produit);
    }

}

