package com.example.demo.controller;



import com.example.demo.dto.client.ClientRequestDTO;
import com.example.demo.dto.client.ClientResponseDTO;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


    @GetMapping
    public List<ClientResponseDTO> findAll(){
        return clientService.findAllClients();
    }

    @GetMapping("/{id}")
    public ClientResponseDTO findClientById(@PathVariable Long id){
        return clientService.findById(id);
    }

    @PostMapping
    public ClientResponseDTO CreateClient(@RequestBody ClientRequestDTO client){
        return clientService.addClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteById(id);
    }
}
