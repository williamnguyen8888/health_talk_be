package com.william.healthytalk.service.FoodService;

import com.william.healthytalk.entity.Food.NutritionValueEntity;
import com.william.healthytalk.repository.Food.INutritionValueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NutritionValueServiceImpl implements INutritionValueService {
    @Autowired
    INutritionValueRepo nutritionValueRepo;
    @Override
    public NutritionValueEntity save(NutritionValueEntity nutritionValueEntity) {
        return nutritionValueRepo.save(nutritionValueEntity);
    }

    @Override
    public Iterable<NutritionValueEntity> findAll() {
        return nutritionValueRepo.findAll();
    }

    @Override
    public int deleteNutritionValueEntityById(int id) {
        return nutritionValueRepo.deleteNutritionValueEntityById(id);
    }

    @Override
    public NutritionValueEntity findNutritionValueEntityByUnit(String unit) {
        return nutritionValueRepo.findNutritionValueEntityByUnit(unit);
    }
}
