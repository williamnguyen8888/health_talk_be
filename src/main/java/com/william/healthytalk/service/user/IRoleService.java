package com.william.healthytalk.service.user;

import com.william.healthytalk.entity.user.RoleEntity;

import java.util.ArrayList;
import java.util.Set;

public interface IRoleService {
    Iterable<RoleEntity> findAll();
    RoleEntity save(RoleEntity roleEntity);
    RoleEntity findRoleById(int id);
    int deleteRoleEntityById(int id);

    RoleEntity findRoleEntityByRoleName(String roleName);
}
