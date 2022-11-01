package com.william.healthytalk.repository.Food;

import com.william.healthytalk.entity.Food.FoodCategoryEntity;
import com.william.healthytalk.entity.Food.FoodMaterialEntity;
import org.springframework.data.repository.CrudRepository;

public interface IFoodMaterialRepo extends CrudRepository<FoodMaterialEntity, Integer> {
    int deleteFoodMaterialEntityById(int id);
    FoodMaterialEntity findFoodMaterialEntityByNameEn(String nameEn);
    FoodMaterialEntity findFoodMaterialEntityByNameVi(String nameVi);
    FoodMaterialEntity findFoodMaterialEntityById(int id);
}
