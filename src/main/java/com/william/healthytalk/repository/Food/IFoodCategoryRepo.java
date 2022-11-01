package com.william.healthytalk.repository.Food;

import com.william.healthytalk.entity.Food.FoodCategoryEntity;
import com.william.healthytalk.entity.Food.FoodStuffEntity;
import org.springframework.data.repository.CrudRepository;

public interface IFoodCategoryRepo extends CrudRepository<FoodCategoryEntity, Integer> {
    int deleteFoodCategoryEntityById(int id);
    FoodCategoryEntity findFoodCategoryEntityByNameEn(String nameEn);
    FoodCategoryEntity findFoodCategoryEntityByNameVi(String nameVi);

    FoodCategoryEntity findFoodCategoryEntityById(int id);
}
