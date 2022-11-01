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
    private UserEntity CreatedUser;

    private boolean isActive;

    @OneToMany(mappedBy = "Category", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<FoodStuffEntity> foodStuffEntities;

    @OneToMany(mappedBy = "Category", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<DishEntity> dishEntities;

    @OneToMany(mappedBy = "Category", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<FoodMaterialEntity> foodMaterialEntities;

}
