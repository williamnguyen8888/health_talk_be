package com.william.healthytalk.entity;

import com.william.healthytalk.entity.user.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private UserEntity user;

    public LoginResponse(UserEntity user,String accessToken) {
        this.accessToken = accessToken;
        this.user = user;
    }
}
