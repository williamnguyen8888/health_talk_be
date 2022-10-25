package com.william.healthytalk.service.user;

import com.william.healthytalk.entity.user.UserEntity;

import java.util.Optional;

public interface IUserAuthService {
    UserEntity save(UserEntity accountEntity);
    Optional<UserEntity> findById(int id);
    Iterable<UserEntity> findAll();
    int deleteUserEntitiesById(int id);
    boolean existsUserEntitiesByUserNameAndPassword(String userName, String password);
    UserEntity findUserEntityByUserName(String userName);
}
