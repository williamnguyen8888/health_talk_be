package com.william.healthytalk.service.FoodService;

import com.william.healthytalk.entity.Food.NutritionValueEntity;

public interface INutritionValueService {
    NutritionValueEntity save(NutritionValueEntity nutritionValueEntity);
    Iterable<NutritionValueEntity> findAll();
    int deleteNutritionValueEntityById(int id);
    NutritionValueEntity findNutritionValueEntityByUnit(String unit);
}
