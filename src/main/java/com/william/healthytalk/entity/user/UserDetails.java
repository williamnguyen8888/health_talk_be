package com.william.healthytalk.entity.user;

import com.william.healthytalk.repository.user.IRoleRepository;
import com.william.healthytalk.service.user.IRoleService;
import com.william.healthytalk.service.user.IUserAuthService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

@Data
@AllArgsConstructor
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
    UserEntity userEntity;
    @Autowired
    IRoleService roleService;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<RoleEntity> roleEntityList = roleService.findAllByUsers(userEntity);

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        for (RoleEntity role:roleEntityList) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
