package com.example.demo.dto.commande;


import com.example.demo.enums.Statut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeResponseDTO {

    private Long id;

    private LocalDate dateCommande;

    private Statut statut;

    private Long clientId;
}
