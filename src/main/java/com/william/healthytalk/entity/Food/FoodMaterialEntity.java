package com.william.healthytalk.entity.Food;

import com.fasterxml.jackson.annotation.*;
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
@Table(name = "FoodMaterial")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class FoodMaterialEntity {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nameEn;
    private String nameVi;
    @ManyToOne
    @JoinColumn(name = "FoodCategory_id")
    @JsonBackReference(value = "FoodCategoryEntity-FoodMaterialEntity")
    private FoodCategoryEntity category;
    private String image;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "FoodMaterialEntity-UserEntity")
    private UserEntity createdUser;
    private String isActive;

    @ManyToMany(mappedBy = "foodMaterial")
    private Collection<DishEntity> dish;

    @ManyToMany(mappedBy = "foodMaterial")
    private Collection<FoodStuffEntity> foodStuff;

    @OneToMany(mappedBy = "foodMaterial", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "FoodMaterialEntity-NutritionValueEntity")
    private  Collection<NutritionValueEntity> nutritionValueEntities;
}
