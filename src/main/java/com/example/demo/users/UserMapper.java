package com.example.demo.users;


import com.example.demo.users.dto.UserRegisterRequest;
import com.example.demo.users.dto.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRegisterRequest dto);

    UserResponse toDto(User user);

}
