package com.example.demo.dto.client;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDTO {

        private Long id;

        private String nom;

        private String email;

        private String telephone;

        private String ville;

}
