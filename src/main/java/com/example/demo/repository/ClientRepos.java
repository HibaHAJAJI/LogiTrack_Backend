package com.example.demo.repository;

import com.example.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClientRepos extends JpaRepository<Client,Long> {
    Optional<Client>findByEmail(String email);
}
