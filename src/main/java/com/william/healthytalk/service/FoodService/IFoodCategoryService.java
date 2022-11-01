package com.william.healthytalk.service.FoodService;

import com.william.healthytalk.entity.Food.FoodCategoryEntity;
import com.william.healthytalk.entity.Food.FoodStuffEntity;


public interface IFoodCategoryService {
    FoodCategoryEntity save(FoodCategoryEntity foodCategoryEntity);
    Iterable<FoodCategoryEntity> findAll();
    int deleteFoodCategoryEntityById(int id);
    FoodCategoryEntity findFoodCategoryEntityByNameEn(String nameEn);
    FoodCategoryEntity findFoodCategoryEntityByNameVi(String nameVi);
    FoodCategoryEntity findFoodCategoryEntityById(int id);
}
