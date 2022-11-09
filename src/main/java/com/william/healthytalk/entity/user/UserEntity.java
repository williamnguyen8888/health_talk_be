package com.william.healthytalk.entity.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.william.healthytalk.entity.Food.DishEntity;
import com.william.healthytalk.entity.Food.FoodCategoryEntity;
import com.william.healthytalk.entity.Food.FoodMaterialEntity;
import com.william.healthytalk.entity.Food.FoodStuffEntity;
import com.william.healthytalk.entity.statistics.HealthStatsEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
@Table(name = "User")
public class UserEntity {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @NotBlank
    private String userName;

    @NotNull
    @NotBlank
    private String password;


    private String refreshToken;


    private String firstName;


    private String lastName;


    private Date birthDay;


    private String gender;


    private String address;


    private String email;


    private String phoneNumber;


    private String vip;

    @NotNull
    @NotBlank
    private Date createdTime;

    @NotNull
    @NotBlank
    private Long createdUser;

    @NotNull
    @NotBlank
    private Long lastModifiedUser;

    @NotNull
    @NotBlank
    private Boolean isActive;

    @ManyToOne
//    @JsonBackReference(value = "RoleEntity-UserEntity")
    @JoinColumn(name = "role_id")
    private  RoleEntity roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "HealthStatsEntity-UserEntity")
    private  Collection<HealthStatsEntity> healthStats;

    @OneToMany(mappedBy = "createdUser", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "FoodCategoryEntity-UserEntity")
    private  Collection<FoodCategoryEntity> foodCategoryEntities;

    @OneToMany(mappedBy = "createdUser", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "FoodStuffEntity-UserEntity")
    private  Collection<FoodStuffEntity> foodStuffEntities;

    @OneToMany(mappedBy = "createdUser", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "DishEntity-UserEntity")
    private  Collection<DishEntity> dishEntities;

    @OneToMany(mappedBy = "createdUser", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "FoodMaterialEntity-UserEntity")
    private Collection<FoodMaterialEntity> foodMaterialEntities;
}
