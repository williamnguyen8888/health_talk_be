package com.william.healthytalk.service.FoodService;

import com.william.healthytalk.entity.Food.FoodCategoryEntity;
import com.william.healthytalk.entity.Food.FoodStuffEntity;
import com.william.healthytalk.repository.Food.IFoodStuffRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@Slf4j
@Transactional
public class FoodStuffServiceImpl implements IFoodStuffService{
    @Autowired
    IFoodStuffRepo foodStuffRepo;
    @Override
    public FoodStuffEntity save(FoodStuffEntity foodStuffEntity) {
        return foodStuffRepo.save(foodStuffEntity);
    }

    @Override
    public Iterable<FoodStuffEntity> findAll() {
        return foodStuffRepo.findAll();
    }

    @Override
    public int deleteFoodStuffEntityById(int id) {
        int count = foodStuffRepo.deleteFoodStuffEntityById(id);
        if(count == 0){
            log.warn("row deleted "+ count);
        }
        return count;
    }

    @Override
    public FoodStuffEntity findFoodStuffEntityByNameEn(String nameEn) {
        return foodStuffRepo.findFoodStuffEntityByNameEn(nameEn);
    }

    @Override
    public FoodStuffEntity findFoodStuffEntityByNameVi(String nameVi) {
        return foodStuffRepo.findFoodStuffEntityByNameVi(nameVi);
    }

    @Override
    public FoodStuffEntity findFoodStuffEntityById(int id) {
        return foodStuffRepo.findFoodStuffEntityById(id);
    }


}
