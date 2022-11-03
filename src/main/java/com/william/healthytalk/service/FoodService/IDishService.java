package com.william.healthytalk.service.FoodService;

import com.william.healthytalk.entity.Food.DishEntity;
import com.william.healthytalk.repository.Food.IDishRepo;

public interface IDishService {
    DishEntity save(DishEntity dishEntity);
    Iterable<DishEntity> findAll();
    int deleteDishEntityById(int id);
    DishEntity findDishEntityByNameEn(String nameEn);
    DishEntity findDishEntityByNameVi(String nameVi);
    DishEntity findDishEntityById(int id);
}
