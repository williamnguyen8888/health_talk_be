package com.william.healthytalk.service.FoodService;

import com.william.healthytalk.entity.Food.FoodCategoryEntity;
import com.william.healthytalk.entity.Food.FoodStuffEntity;
import com.william.healthytalk.repository.Food.IFoodCategoryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class FoodCategoryServiceImpl implements IFoodCategoryService{
    @Autowired
    IFoodCategoryRepo iFoodCategoryRepo;
    @Override
    public FoodCategoryEntity save(FoodCategoryEntity foodCategoryEntity) {
        return iFoodCategoryRepo.save(foodCategoryEntity);
    }

    @Override
    public Iterable<FoodCategoryEntity> findAll() {
        return iFoodCategoryRepo.findAll();
    }

    @Override
    public int deleteFoodCategoryEntityById(int id) {
        int count = iFoodCategoryRepo.deleteFoodCategoryEntityById(id);
        if(count == 0){
            log.warn("row deleted "+ count);
        }
        return count;
    }

    @Override
    public FoodCategoryEntity findFoodCategoryEntityByNameEn(String nameEn) {
        return iFoodCategoryRepo.findFoodCategoryEntityByNameEn(nameEn);
    }

    @Override
    public FoodCategoryEntity findFoodCategoryEntityByNameVi(String nameVi) {
        return iFoodCategoryRepo.findFoodCategoryEntityByNameVi(nameVi);
    }


    @Override
    public FoodCategoryEntity findFoodCategoryEntityById(int id) {
        return iFoodCategoryRepo.findFoodCategoryEntityById(id);
    }
}
