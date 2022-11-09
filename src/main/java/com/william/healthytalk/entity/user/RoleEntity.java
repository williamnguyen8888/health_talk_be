package com.william.healthytalk.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
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

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
//    @JsonManagedReference(value = "RoleEntity-UserEntity")
    @JsonIgnore
    private Collection<UserEntity> users;

}
