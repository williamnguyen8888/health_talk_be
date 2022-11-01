package com.william.healthytalk.entity.Food;

import com.william.healthytalk.entity.user.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private String FoodStufMaterial;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity createdUser;

    private Boolean isActive;
}
