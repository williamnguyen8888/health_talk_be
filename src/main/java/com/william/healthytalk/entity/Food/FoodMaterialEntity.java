package com.william.healthytalk.entity.Food;

import com.william.healthytalk.entity.user.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
@Table(name = "FoodMaterial")
public class FoodMaterialEntity {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nameEn;
    private String nameVi;
    @ManyToOne
    @JoinColumn(name = "FoodCategory_id")
    private FoodCategoryEntity Category;
    private String image;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity createdUser;
    private String isActive;

    @ManyToMany(mappedBy = "foodMaterial")
    private Set<DishEntity> dish;

    @ManyToMany(mappedBy = "foodMaterial")
    private Set<FoodStuffEntity> foodStuff;

    @OneToMany(mappedBy = "foodMaterial", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<NutritionValueEntity> nutritionValueEntities;
}
