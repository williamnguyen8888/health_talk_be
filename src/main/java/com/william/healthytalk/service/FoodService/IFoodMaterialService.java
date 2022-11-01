package com.william.healthytalk.service.FoodService;

import com.william.healthytalk.entity.Food.FoodCategoryEntity;
import com.william.healthytalk.entity.Food.FoodMaterialEntity;

public interface IFoodMaterialService {
    FoodMaterialEntity save(FoodMaterialEntity foodMaterialEntity);
    Iterable<FoodMaterialEntity> findAll();
    int deleteFoodMaterialEntityById(int id);
    FoodMaterialEntity findFoodMaterialEntityByNameEn(String nameEn);
    FoodMaterialEntity findFoodMaterialEntityByNameVi(String nameVi);
    FoodMaterialEntity findFoodMaterialEntityById(int id);
}
