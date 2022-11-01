package com.william.healthytalk.controller.Food;

import com.william.healthytalk.entity.Food.FoodCategoryEntity;
import com.william.healthytalk.entity.Food.FoodStuffEntity;
import com.william.healthytalk.entity.user.UserEntity;
import com.william.healthytalk.service.FoodService.IFoodCategoryService;
import com.william.healthytalk.service.user.IUserAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/food-category")
@Slf4j
public class FoodCategoryController {
    @Autowired
    IFoodCategoryService foodCategoryService;
    @Autowired
    IUserAuthService userAuthService;

    @PostMapping
    private ResponseEntity<FoodCategoryEntity> createFoodCategory(@RequestBody FoodCategoryEntity foodCategoryEntity){
        FoodCategoryEntity foodCategoryNameEn = foodCategoryService.findFoodCategoryEntityByNameEn(foodCategoryEntity.getNameEn());
        FoodCategoryEntity foodCategoryNameVi = foodCategoryService.findFoodCategoryEntityByNameVi(foodCategoryEntity.getNameVi());

        if (foodCategoryNameEn != null || foodCategoryNameVi != null){
            return new ResponseEntity(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity(foodCategoryService.save(foodCategoryEntity), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<FoodCategoryEntity> getFoodCategory(){
        return new ResponseEntity(foodCategoryService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<FoodCategoryEntity> updateFoodCategory(@RequestBody FoodCategoryEntity foodCategoryEntity){
        FoodCategoryEntity foodCategory = foodCategoryService.findFoodCategoryEntityById(foodCategoryEntity.getId());
        if (foodCategory == null){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(foodCategoryService.save(foodCategoryEntity),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<FoodCategoryEntity> deleteFoodCategory(@PathVariable("id") int id){
        return new ResponseEntity(foodCategoryService.deleteFoodCategoryEntityById(id),HttpStatus.OK);
    }
}
