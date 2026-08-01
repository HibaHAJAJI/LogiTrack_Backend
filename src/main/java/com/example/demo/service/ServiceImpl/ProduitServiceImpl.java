package com.example.demo.service.ServiceImpl;

import com.example.demo.dto.produit.ProduitRequestDTO;
import com.example.demo.dto.produit.ProduitResponseDTO;
import com.example.demo.entity.Produit;
import com.example.demo.mapper.ProduitMapper;
import com.example.demo.repositorie.ProduitRepos;
import com.example.demo.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl  implements ProduitService {

    private final ProduitRepos repos;
    private final ProduitMapper mapper;

    public ProduitResponseDTO addProduct(ProduitRequestDTO dto){
        Produit produit = mapper.toEntity(dto);
        return mapper.toDto(repos.save(produit));
    }

    public  List<ProduitResponseDTO> getAllProducts(){
        return mapper.toDtoList(repos.findAll());
    }

    public ProduitResponseDTO findById(Long id){
        Produit produit=repos.findById(id).orElseThrow(()->new RuntimeException("Produit introvable"));
        return mapper.toDto(produit);
    }

    public  void deleteById(Long id){
        if(!repos.existsById(id)){
            throw new RuntimeException("Produit introvable");
        }
        repos.deleteById(id);
    }

    public List<ProduitResponseDTO> findProductsByCategory(String categorie){
        return mapper.toDtoList(repos.findByCategorie(categorie));
    }

    public List<ProduitResponseDTO> findProductsByPriceLessThan(double prix){
        return mapper.toDtoList(repos.findByPrixLessThan(prix));
    }

    public List<ProduitResponseDTO> findLowStock(int seuil){
        return mapper.toDtoList(repos.findLowStock(seuil));
    }
    public ProduitResponseDTO getTopProduct(){
        Produit produit = repos.findTopProduct().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucun produit trouvé"));
        return mapper.toDto(produit);
    }

}

