package com.william.healthytalk.entity;

import com.william.healthytalk.entity.user.RoleEntity;
import com.william.healthytalk.entity.user.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer ";
    private UserEntity user;
    private RoleEntity role;

    public LoginResponse(UserEntity user,RoleEntity role ,String accessToken) {
        this.accessToken = tokenType + accessToken;
        this.user = user;
        this.role = role;
    }
}
