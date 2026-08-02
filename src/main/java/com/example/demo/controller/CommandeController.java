package com.example.demo.controller;

import com.example.demo.Enum.Statut;
import com.example.demo.dto.commande.CommandeRequestDTO;
import com.example.demo.dto.commande.CommandeResponseDTO;
import com.example.demo.dto.lignecommande.LigneCommandeRequestDTO;
import com.example.demo.dto.lignecommande.LigneCommandeResponseDTO;
import com.example.demo.service.CommandeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class CommandeController {

    private final CommandeService commandeService;


    @GetMapping
    public ResponseEntity<Page<CommandeResponseDTO>> findAllOrders(Pageable pageable){
        return ResponseEntity.ok(commandeService.findAllCommandes(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeResponseDTO> findOrderById(@PathVariable Long id){
        return ResponseEntity.ok(commandeService.findCommandeById(id));
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<Page<CommandeResponseDTO>> findByClientId(@PathVariable Long clientId, Pageable pageable){
        return ResponseEntity.ok(commandeService.findCommandesByClientId(clientId, pageable));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countOrders(){
        return ResponseEntity.ok(commandeService.countCommandes());
    }

    @PostMapping
    public ResponseEntity<CommandeResponseDTO> addCommandeClient(@Valid @RequestBody CommandeRequestDTO dto){
        return ResponseEntity.ok(commandeService.addCommande(dto));
    }

    @PostMapping("/{orderId}/products")
    public ResponseEntity<LigneCommandeResponseDTO> addProduit(@PathVariable Long orderId,@Valid @RequestBody LigneCommandeRequestDTO dto ){
        return ResponseEntity.ok(commandeService.addProduct(orderId, dto));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<CommandeResponseDTO> updateOrderStatus(@PathVariable Long id,@RequestBody Statut statut){
        return ResponseEntity.ok(commandeService.updateStatus(id, statut));
    }
}