package com.william.healthytalk.entity.statistics;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@AllArgsConstructor
public class HealthStatsValue {
    private int userId;
    private double weight;
    private double height;
    private String target;
    private double r;
    private double weight_target;
}
