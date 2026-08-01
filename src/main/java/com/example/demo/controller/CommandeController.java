package com.example.demo.controller;

import com.example.demo.Enum.Statut;
import com.example.demo.dto.commande.CommandeRequestDTO;
import com.example.demo.dto.commande.CommandeResponseDTO;
import com.example.demo.dto.lignecommande.LigneCommandeRequestDTO;
import com.example.demo.dto.lignecommande.LigneCommandeResponseDTO;
import com.example.demo.service.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class CommandeController {

    private final CommandeService commandeService;


    @GetMapping
    public List<CommandeResponseDTO> findAllOrders(){
        return commandeService.findAllCommandes();
    }

    @GetMapping("/{id}")
    public CommandeResponseDTO findOrderById(@PathVariable Long id){
        return commandeService.findCommandeById(id);
    }

    @GetMapping("/client/{clientId}")
    public List<CommandeResponseDTO>findByClientId(@PathVariable Long clientId){
        return commandeService.findCommandesByClientId(clientId);
    }

    @GetMapping("/count")
    public long countOrders(){
        return commandeService.countCommandes();
    }

    @PostMapping
    public CommandeResponseDTO addCommandeClient(@RequestBody CommandeRequestDTO dto){
        return commandeService.addCommande(dto);
    }

    @PostMapping("/{orderId}/products")
    public ResponseEntity<LigneCommandeResponseDTO> addProduit(@PathVariable Long orderId,@RequestBody LigneCommandeRequestDTO dto ){
        return ResponseEntity.ok(commandeService.addProduct(orderId, dto));
    }

    @PutMapping("/{id}/status")
    public CommandeResponseDTO updateOrderStatus(@PathVariable Long id,@RequestBody Statut statut){
        return commandeService.updateStatus(id, statut);
    }
}