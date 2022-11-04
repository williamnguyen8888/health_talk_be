package com.william.healthytalk.repository.user;

import com.william.healthytalk.entity.user.RoleEntity;
import com.william.healthytalk.entity.user.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRoleRepository extends CrudRepository<RoleEntity, Integer> {
    int deleteRoleEntityById(int id);
    RoleEntity findRoleEntityByRoleName(String roleName);

    List<RoleEntity> findAllByUsers(UserEntity userEntity);
}
