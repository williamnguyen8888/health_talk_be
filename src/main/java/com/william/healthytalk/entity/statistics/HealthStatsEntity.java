package com.william.healthytalk.entity.statistics;

import com.william.healthytalk.entity.user.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
@Table(name = "HealthStats")
public class HealthStatsEntity {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @NotBlank
    private Long userId;
    private int age;
    private String gender;
    private float weight;
    private float height;
    private float weightTarget;
    private float bmi;
    private float bmr;
    private float tdee;
    private float idealWeight;
    private float minWeight;
    private float maxWeight;
    private float caloriesIn;
    private float proteinIn;
    private float fatIn;
    private float carbsIn;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
