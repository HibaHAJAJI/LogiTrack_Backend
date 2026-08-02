package com.example.demo.controller;


import com.example.demo.dto.client.ClientRequestDTO;
import com.example.demo.dto.client.ClientResponseDTO;
import com.example.demo.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


    @GetMapping
    public ResponseEntity<Page<ClientResponseDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(clientService.findAllClients(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> findClientById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> CreateClient(@Valid @RequestBody ClientRequestDTO client){
        return ResponseEntity.ok(clientService.addClient(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
