package com.william.healthytalk.service.user;

import com.william.healthytalk.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;




@Service
public class UserService implements UserDetailsService {
    @Autowired
    IUserAuthService userAuthService;
    @Autowired
    IRoleService roleService;


    @Override
    public UserDetails loadUserByUsername(String username){
        //check user in the database
        UserEntity user = userAuthService.findUserEntityByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new com.william.healthytalk.entity.user.UserDetails(user,roleService);
    }


    // JWTAuthenticationFilter sẽ sử dụng hàm này
    @Transactional
    public UserDetails loadUserById(int id) {
        UserEntity user = userAuthService.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return new com.william.healthytalk.entity.user.UserDetails(user,roleService);
    }
}
