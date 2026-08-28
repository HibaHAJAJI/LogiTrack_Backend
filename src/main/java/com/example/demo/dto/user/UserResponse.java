package com.example.demo.dto.user;


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
