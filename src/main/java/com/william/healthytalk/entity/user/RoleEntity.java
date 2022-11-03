package com.william.healthytalk.entity.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
@Table(name = "Role")
public class RoleEntity {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String roleName;

    @NotNull
    @NotBlank
    private Date createdTime;

    private int createdUser;

    @NotNull
    @NotBlank
    private Long lastModifiedUser;

    @NotNull
    @NotBlank
    private boolean isActive;

    @ManyToMany(mappedBy = "roles")
    private Collection<UserEntity> users;

}
