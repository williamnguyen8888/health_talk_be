package com.william.healthytalk.entity.Food;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.william.healthytalk.entity.user.RoleEntity;
import com.william.healthytalk.entity.user.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private FoodCategoryEntity Category;
    private String imageDish;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity createdUser;
    private String isActive;
    @ManyToMany
    @JoinTable(name="dish_foodMaterial", joinColumns =@JoinColumn(name = "dish_id"), inverseJoinColumns = @JoinColumn(name="foodMaterial_id"))
    private Set<FoodMaterialEntity> foodMaterial;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<NutritionValueEntity> nutritionValueEntities;
}
