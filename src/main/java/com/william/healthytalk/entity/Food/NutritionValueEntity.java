package com.william.healthytalk.entity.Food;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
@Table(name = "NutritionValue")
public class NutritionValueEntity {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "FoodStuff_id")
    @JsonBackReference(value = "FoodStuffEntity-NutritionValueEntity")
    private FoodStuffEntity foodStuff;

    @ManyToOne
    @JoinColumn(name = "Dish_id")
    @JsonBackReference(value = "DishEntity-NutritionValueEntity")
    private DishEntity dish;

    @ManyToOne
    @JoinColumn(name = "FoodMaterial_id")
    @JsonBackReference(value = "FoodMaterialEntity-NutritionValueEntity")
    private FoodMaterialEntity foodMaterial;

    private String unit;
    private int amount;
    private double kcal;
    private double fat;
    private double protein;
    private double carbs;
    private boolean defaultValue;
    private boolean isActive;
}
