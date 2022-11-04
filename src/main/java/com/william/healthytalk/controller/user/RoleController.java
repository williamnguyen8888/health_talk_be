package com.william.healthytalk.controller.user;

import com.william.healthytalk.entity.user.RoleEntity;
import com.william.healthytalk.entity.user.UserEntity;
import com.william.healthytalk.service.user.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("api/role")
@Slf4j
public class RoleController {
    @Autowired
    IRoleService roleService;

    @PostMapping
    private ResponseEntity<RoleEntity> createRole(@RequestBody RoleEntity roleEntity) {
        RoleEntity role = roleService.findRoleEntityByRoleName(roleEntity.getRoleName());
        if(role != null){
            log.warn("role already exist");
            return new ResponseEntity(role, HttpStatus.CONFLICT);
        }
        log.info("role "+roleEntity.getRoleName()+" updated");
        return new ResponseEntity(roleService.save(roleEntity),HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<RoleEntity> updateRole(@RequestBody RoleEntity roleEntity){
        RoleEntity role = roleService.findRoleEntityByRoleName(roleEntity.getRoleName());
        if(role == null){
            log.warn("can't update role: "+roleEntity.getRoleName());
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        log.info("update success role: "+roleEntity.getRoleName());
        return new ResponseEntity(roleService.save(roleEntity), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<RoleEntity> getAllRole(){
        return new ResponseEntity(roleService.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<RoleEntity> deleteRoleById(@PathVariable("id") int id){
        int rowCount = roleService.deleteRoleEntityById(id);
        if(rowCount == 0){
            return new ResponseEntity(0,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(rowCount,HttpStatus.OK);
    }

    @PostMapping("/userRole")
    private ResponseEntity<List<RoleEntity>> findRolesUser(@RequestBody UserEntity userEntity){
        return new ResponseEntity(roleService.findAllByUsers(userEntity),HttpStatus.OK);
    }
}
