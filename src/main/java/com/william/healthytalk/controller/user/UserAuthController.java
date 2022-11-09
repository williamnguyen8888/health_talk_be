package com.william.healthytalk.controller.user;

import com.william.healthytalk.config.JWT.JwtTokenProvider;
import com.william.healthytalk.entity.LoginResponse;
import com.william.healthytalk.entity.user.RoleEntity;
import com.william.healthytalk.entity.user.UserDetails;
import com.william.healthytalk.entity.user.UserEntity;
import com.william.healthytalk.service.user.IRoleService;
import com.william.healthytalk.service.user.IUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.validation.Valid;
import java.io.Serializable;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user-auth")
public class UserAuthController implements Serializable {
    @Autowired
    private IUserAuthService userAuthService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    IRoleService roleService;


    @PutMapping
    private ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        UserEntity user = userAuthService.findUserEntityByUserName(userEntity.getUserName());
        if(user != null){
            return new ResponseEntity(null, HttpStatus.CONFLICT);
        }
        return new ResponseEntity(userAuthService.save(userEntity),HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<LoginResponse> loginUser(@RequestBody UserEntity userEntity){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserEntity user = userAuthService.findUserEntityByUserName(userEntity.getUserName());
        if(user == null){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

        // kiem tra pass cua nguoi dung nhap va trong db co giong nhau khong
        Boolean checkPassword = passwordEncoder.matches(userEntity.getPassword(),user.getPassword());

        if(!checkPassword){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userEntity.getUserName(),
                        userEntity.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // lấy thông tin role
        RoleEntity role = roleService.findRoleEntityByUsers(user);
        role.setUsers(null);
        user.setPassword("");
        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((UserDetails) authentication.getPrincipal());
        return new ResponseEntity(new LoginResponse(user,role,jwt), HttpStatus.OK);

    }


}
