package com.william.healthytalk.repository.user;

import com.william.healthytalk.entity.user.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface IUserAuthRepository extends CrudRepository<UserEntity, Integer> {
    boolean existsUserEntitiesByUserNameAndPassword(String userName, String password);
    UserEntity findUserEntityByUserName(String userName);
    int deleteUserEntitiesById(int id);
}
