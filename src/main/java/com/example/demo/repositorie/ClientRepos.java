package com.example.demo.repositorie;

import com.example.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepos extends JpaRepository<Client,Long> {
    Optional<Client> findClientById(Long id) ;

    void deleteById(Long id);
}
