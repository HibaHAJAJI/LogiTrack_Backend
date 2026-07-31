package com.example.demo.service;

import com.example.demo.entity.Client;
import com.example.demo.repositorie.ClientRepos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepos repos;

    public ClientService(ClientRepos repos) {
        this.repos = repos;
    }


    public Client ajouterClient(Client client){
        return repos.save(client);
    }

    public List<Client> afficherClient(){
        return repos.findAll();
    }

    public Optional<Client> consulterParId(Long id) {
        return repos.findClientById(id) ;
    }

    public void supprimerParID(Long id){
     Optional<Client>client=repos.findClientById(id);
     if(client.isPresent()){
         repos.deleteById(id);
     }else {
         throw new RuntimeException("Client introvable");
     }
    }
}
