package com.william.healthytalk.repository.Food;

import com.william.healthytalk.entity.Food.FoodCategoryEntity;
import com.william.healthytalk.entity.Food.FoodStuffEntity;
import org.springframework.data.repository.CrudRepository;

public interface IFoodStuffRepo extends CrudRepository<FoodStuffEntity, Integer> {
    int deleteFoodStuffEntityById(int id);
    FoodStuffEntity findFoodStuffEntityByNameEn(String nameEn);
    FoodStuffEntity findFoodStuffEntityByNameVi(String nameVi);

    FoodStuffEntity findFoodStuffEntityById(int id);
}
