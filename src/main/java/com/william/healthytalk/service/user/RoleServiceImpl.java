package com.william.healthytalk.service.user;

import com.william.healthytalk.entity.user.RoleEntity;
import com.william.healthytalk.entity.user.UserEntity;
import com.william.healthytalk.repository.user.IRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class RoleServiceImpl implements IRoleService{
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Iterable<RoleEntity> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public RoleEntity save(RoleEntity roleEntity) {
        return roleRepository.save(roleEntity);
    }

    @Override
    public RoleEntity findRoleById(int id) {
        Optional<RoleEntity> role = roleRepository.findById(id);
        if(role.isPresent()){
            return role.get();
        }
        log.info("can't find role with Id: "+id);
        return null;
    }

    @Override
    public int deleteRoleEntityById(int id) {
        int roleCount = roleRepository.deleteRoleEntityById(id);
        if(roleCount == 0){
            log.warn("row deleted "+ roleCount);
        }
        return roleCount;
    }

    @Override
    public RoleEntity findRoleEntityByRoleName(String roleName) {
        return roleRepository.findRoleEntityByRoleName(roleName);
    }

    @Override
    public List<RoleEntity> findAllByUsers(UserEntity userEntity) {
        return roleRepository.findAllByUsers(userEntity);
    }

    @Override
    public RoleEntity findRoleEntityByUsers(UserEntity userEntity) {
        return roleRepository.findRoleEntityByUsers(userEntity);
    }
}
