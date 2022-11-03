package com.william.healthytalk.service.FoodService;

import com.william.healthytalk.entity.Food.DishEntity;
import com.william.healthytalk.repository.Food.IDishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class DishServiceImpl implements IDishService{
    @Autowired
    IDishRepo dishRepo;
    @Override
    public DishEntity save(DishEntity dishEntity) {
        return dishRepo.save(dishEntity);
    }

    @Override
    public Iterable<DishEntity> findAll() {
        return dishRepo.findAll();
    }

    @Override
    @Transactional
    public int deleteDishEntityById(int id) {
        return dishRepo.deleteDishEntityById(id);
    }

    @Override
    public DishEntity findDishEntityByNameEn(String nameEn) {
        return dishRepo.findDishEntityByNameEn(nameEn);
    }

    @Override
    public DishEntity findDishEntityByNameVi(String nameVi) {
        return dishRepo.findDishEntityByNameVi(nameVi);
    }

    @Override
    public DishEntity findDishEntityById(int id) {
        return dishRepo.findDishEntityById(id);
    }
}
