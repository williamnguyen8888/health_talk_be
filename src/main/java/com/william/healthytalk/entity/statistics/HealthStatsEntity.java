package com.william.healthytalk.entity.statistics;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int age;
    private String gender;
    private double weight;
    private double height;
    private double weightTarget;
    private double bmi;
    private double bmr;
    private double tdee;
    private double idealWeight;
    private double minWeight;
    private double maxWeight;
    private double caloriesIn;
    private double proteinIn;
    private double fatIn;
    private double carbsIn;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
