package com.william.healthytalk.repository.Food;

import com.william.healthytalk.entity.Food.NutritionValueEntity;
import org.springframework.data.repository.CrudRepository;

public interface INutritionValueRepo extends CrudRepository<NutritionValueEntity, Integer> {
    int deleteNutritionValueEntityById(int id);
    NutritionValueEntity findNutritionValueEntityByUnit(String unit);
}
