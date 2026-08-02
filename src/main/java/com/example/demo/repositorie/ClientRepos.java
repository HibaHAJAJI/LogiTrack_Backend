package com.example.demo.repositorie;

import com.example.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepos extends JpaRepository<Client,Long> {
}
