package com.william.healthytalk.controller.user;

import com.william.healthytalk.entity.user.UserEntity;
import com.william.healthytalk.service.user.IUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user-auth")
public class UserAuthController {
    @Autowired
    private IUserAuthService userAuthService;

    @PutMapping
    private ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        UserEntity user = userAuthService.findUserEntityByUserName(userEntity.getUserName());
        if(user != null){
            return new ResponseEntity(null, HttpStatus.CONFLICT);
        }
        return new ResponseEntity(userAuthService.save(userEntity),HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<UserEntity> loginUser(@RequestBody UserEntity userEntity){
        Boolean user = userAuthService.existsUserEntitiesByUserNameAndPassword(userEntity.getUserName(), userEntity.getPassword());
        if(!user){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(userAuthService.findUserEntityByUserName(userEntity.getUserName()),HttpStatus.OK);
    }

}
