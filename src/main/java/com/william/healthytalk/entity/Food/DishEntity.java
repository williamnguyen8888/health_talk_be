package com.william.healthytalk.entity.Food;


import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.william.healthytalk.entity.user.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
@Table(name = "Dish")
public class DishEntity {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nameEn;
    private String nameVi;

    @ManyToOne
    @JoinColumn(name = "FoodCategory_id")
    @JsonBackReference (value = "DishEntity-FoodCategoryEntity")
    private FoodCategoryEntity category;

    private String imageDish;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "DishEntity-UserEntity")
    private UserEntity createdUser;
    private String isActive;

    @ManyToMany
    @JoinTable
    private  Collection<FoodMaterialEntity> foodMaterial;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "DishEntity-NutritionValueEntity")
    private Collection<NutritionValueEntity> nutritionValueEntities;
}
