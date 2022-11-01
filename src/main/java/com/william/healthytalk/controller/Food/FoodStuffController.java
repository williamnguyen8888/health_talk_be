package com.william.healthytalk.controller.Food;

import com.william.healthytalk.entity.Food.FoodCategoryEntity;
import com.william.healthytalk.entity.Food.FoodStuffEntity;
import com.william.healthytalk.entity.user.UserEntity;
import com.william.healthytalk.service.FoodService.IFoodCategoryService;
import com.william.healthytalk.service.FoodService.IFoodStuffService;
import com.william.healthytalk.service.user.IUserAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/food-stuff")
@Slf4j
public class FoodStuffController {
    @Autowired
    IFoodStuffService foodStuffService;
    @Autowired
    IUserAuthService userAuthService;

    @Autowired
    IFoodCategoryService foodCategoryService;

    @PostMapping
    private ResponseEntity<FoodStuffEntity> createFoodStuff(@RequestBody FoodStuffEntity foodStuffEntity){

        FoodStuffEntity foodStuffEn = foodStuffService.findFoodStuffEntityByNameEn(foodStuffEntity.getNameEn());
        FoodStuffEntity foodStuffVi = foodStuffService.findFoodStuffEntityByNameVi(foodStuffEntity.getNameVi());

        if (foodStuffEn != null || foodStuffVi != null){
            return new ResponseEntity(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity(foodStuffService.save(foodStuffEntity),HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<FoodStuffEntity> getAllFoodStuff(){
        return new ResponseEntity(foodStuffService.findAll(),HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<FoodStuffEntity> updateFoodStuff(FoodStuffEntity foodStuffEntity){
        FoodStuffEntity foodStuff = foodStuffService.findFoodStuffEntityById(foodStuffEntity.getId());
        if (foodStuff == null){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(foodStuffService.save(foodStuffEntity),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<FoodStuffEntity> deleteFoodCategory(@PathVariable("id") int id){
        return new ResponseEntity(foodStuffService.deleteFoodStuffEntityById(id),HttpStatus.OK);
    }
}
