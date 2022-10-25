package com.william.healthytalk.repository.user;

import com.william.healthytalk.entity.user.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepository extends CrudRepository<RoleEntity, Integer> {
    int deleteRoleEntityById(int id);
    RoleEntity findRoleEntityByRoleName(String roleName);
}
