package com.example.demo.users.dto;


import com.example.demo.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;

    private String nom;

    private String prenom;

    private String email;

    private String password;

    private Role role;
}
