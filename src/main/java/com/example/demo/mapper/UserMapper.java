package com.example.demo.mapper;


import com.example.demo.entity.User;
import com.example.demo.dto.user.UserRegisterRequest;
import com.example.demo.dto.user.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRegisterRequest dto);

    UserResponse toDto(User user);

}
