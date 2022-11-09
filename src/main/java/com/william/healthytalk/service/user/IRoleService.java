package com.william.healthytalk.service.user;

import com.william.healthytalk.entity.user.RoleEntity;
import com.william.healthytalk.entity.user.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface IRoleService {
    Iterable<RoleEntity> findAll();
    RoleEntity save(RoleEntity roleEntity);
    RoleEntity findRoleById(int id);
    int deleteRoleEntityById(int id);

    RoleEntity findRoleEntityByRoleName(String roleName);

    List<RoleEntity> findAllByUsers(UserEntity userEntity);
    RoleEntity findRoleEntityByUsers(UserEntity userEntity);
}
