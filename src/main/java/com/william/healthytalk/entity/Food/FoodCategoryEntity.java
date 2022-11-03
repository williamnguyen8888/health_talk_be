package com.william.healthytalk.entity.Food;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.william.healthytalk.entity.user.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
@Table(name = "FoodCategory")
public class FoodCategoryEntity {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int parentId;
    private String nameEn;
    private String nameVi;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "FoodCategoryEntity-UserEntity")
    private UserEntity createdUser;

    private boolean isActive;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "FoodCategoryEntity-FoodStuffEntity")
    private  Collection<FoodStuffEntity> foodStuffEntities;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "DishEntity-FoodCategoryEntity")
    private Collection<DishEntity> dishEntities;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "FoodCategoryEntity-FoodMaterialEntity")
    private  Collection<FoodMaterialEntity> foodMaterialEntities;

}
