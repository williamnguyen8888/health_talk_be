package com.william.healthytalk.service.user;

import com.william.healthytalk.entity.user.UserEntity;

import java.util.Optional;

public interface IUserService {
    Iterable<UserEntity> findAll();
    Optional<UserEntity> findById(int id);
    UserEntity save(UserEntity user);
    int deleteUserEntityById(int id);
}
