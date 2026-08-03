package com.example.demo.auth.service;


import com.example.demo.auth.dto.AuthResponse;
import com.example.demo.auth.dto.LoginRequest;
import com.example.demo.users.dto.UserRegisterRequest;


public interface AuthService {


    AuthResponse login(LoginRequest dto);

    AuthResponse register(UserRegisterRequest dto);
}
