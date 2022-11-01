package com.william.healthytalk.entity.Food;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private FoodCategoryEntity Category;

    private String imageFoodStuff;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity createdUser;

    private Boolean isActive;

    @ManyToMany
    @JoinTable(name="foodStuff_foodMaterial", joinColumns =@JoinColumn(name = "foodStuff_id"), inverseJoinColumns = @JoinColumn(name="foodMaterial_id"))
    private Set<FoodMaterialEntity> foodMaterial;

    @OneToMany(mappedBy = "foodStuff", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<NutritionValueEntity> nutritionValueEntities;
}
