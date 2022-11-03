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
@Table(name = "FoodStuff")
public class FoodStuffEntity {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nameEn;
    private String nameVi;

    @ManyToOne
    @JoinColumn(name = "FoodCategory_id")
    @JsonBackReference(value = "FoodCategoryEntity-FoodStuffEntity")
    private FoodCategoryEntity category;

    private String imageFoodStuff;
    private String description;

    @ManyToOne
    @JsonBackReference(value = "FoodStuffEntity-UserEntity")
    private UserEntity createdUser;

    private Boolean isActive;

    @ManyToMany
    private  Collection<FoodMaterialEntity> foodMaterial;

    @OneToMany(mappedBy = "foodStuff", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "FoodStuffEntity-NutritionValueEntity")
    private Collection<NutritionValueEntity> nutritionValueEntities;
}
