package com.william.healthytalk.service.FoodService;

import com.william.healthytalk.entity.Food.FoodCategoryEntity;
import com.william.healthytalk.entity.Food.FoodStuffEntity;

public interface IFoodStuffService {
    FoodStuffEntity save(FoodStuffEntity foodStuffEntity);
    Iterable<FoodStuffEntity> findAll();
    int deleteFoodStuffEntityById(int id);
    FoodStuffEntity findFoodStuffEntityByNameEn(String nameEn);
    FoodStuffEntity findFoodStuffEntityByNameVi(String nameVi);

    FoodStuffEntity findFoodStuffEntityById(int id);
}
