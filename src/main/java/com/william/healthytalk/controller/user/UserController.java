package com.william.healthytalk.controller.user;

import com.william.healthytalk.entity.user.UserEntity;
import com.william.healthytalk.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user")
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping
    private ResponseEntity<UserEntity> getAllUser(){
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }
}
