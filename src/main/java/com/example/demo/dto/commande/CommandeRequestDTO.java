package com.example.demo.dto.commande;


import com.example.demo.Enum.Statut;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeRequestDTO {

    private LocalDate dateCommande;

    private Statut statut;

    @NotNull(message = "clientId cannot be null")
    private Long clientId;
}
