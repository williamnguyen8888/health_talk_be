package com.william.healthytalk.entity.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long createdUSer;

    @NotNull
    @NotBlank
    private Long lastModifiedUser;

    @NotNull
    @NotBlank
    private Boolean isActive;

    @ManyToMany
    @JoinTable(name="user_role", joinColumns =@JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<RoleEntity> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<HealthStatsEntity> healthStats;

    @OneToMany(mappedBy = "CreatedUser", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<FoodCategoryEntity> foodCategoryEntities;

    @OneToMany(mappedBy = "createdUser", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<FoodStuffEntity> foodStuffEntities;

    @OneToMany(mappedBy = "createdUser", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<DishEntity> dishEntities;

    @OneToMany(mappedBy = "createdUser", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<FoodMaterialEntity> foodMaterialEntities;
}
