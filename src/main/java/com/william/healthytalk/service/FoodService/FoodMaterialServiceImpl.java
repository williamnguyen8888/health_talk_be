package com.william.healthytalk.service.FoodService;

import com.william.healthytalk.entity.Food.FoodCategoryEntity;
import com.william.healthytalk.entity.Food.FoodMaterialEntity;
import com.william.healthytalk.repository.Food.IFoodMaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FoodMaterialServiceImpl implements IFoodMaterialService{
    @Autowired
    IFoodMaterialRepo foodMaterialRepo;

    @Override
    public FoodMaterialEntity save(FoodMaterialEntity foodMaterialEntity) {
        return foodMaterialRepo.save(foodMaterialEntity);
    }

    @Override
    public Iterable<FoodMaterialEntity> findAll() {
        return foodMaterialRepo.findAll();
    }

    @Override
    public int deleteFoodMaterialEntityById(int id) {
        return foodMaterialRepo.deleteFoodMaterialEntityById(id);
    }

    @Override
    public FoodMaterialEntity findFoodMaterialEntityByNameEn(String nameEn) {
        return foodMaterialRepo.findFoodMaterialEntityByNameEn(nameEn);
    }

    @Override
    public FoodMaterialEntity findFoodMaterialEntityByNameVi(String nameVi) {
        return foodMaterialRepo.findFoodMaterialEntityByNameVi(nameVi);
    }

    @Override
    public FoodMaterialEntity findFoodMaterialEntityById(int id) {
        return foodMaterialRepo.findFoodMaterialEntityById(id);
    }
}
