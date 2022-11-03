package com.william.healthytalk.repository.Food;

import com.william.healthytalk.entity.Food.DishEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDishRepo extends CrudRepository<DishEntity,Integer> {
    int deleteDishEntityById(int id);
    DishEntity findDishEntityByNameEn(String nameEn);
    DishEntity findDishEntityByNameVi(String nameVi);
    DishEntity findDishEntityById(int id);
}
