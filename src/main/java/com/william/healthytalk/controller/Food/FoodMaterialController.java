package com.william.healthytalk.controller.Food;

import com.william.healthytalk.entity.Food.FoodMaterialEntity;
import com.william.healthytalk.repository.Food.IFoodMaterialRepo;
import com.william.healthytalk.service.FoodService.IFoodMaterialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/food-material")
@Slf4j
public class FoodMaterialController {
    @Autowired
    IFoodMaterialService foodMaterialService;

    @PostMapping
    private ResponseEntity<FoodMaterialEntity> createFoodMateial(@RequestBody FoodMaterialEntity foodMaterial){
        FoodMaterialEntity foodMaterialNameEn = foodMaterialService.findFoodMaterialEntityByNameEn(foodMaterial.getNameEn());
        FoodMaterialEntity foodMaterialNameVi = foodMaterialService.findFoodMaterialEntityByNameVi(foodMaterial.getNameVi());
        if (foodMaterialNameVi != null || foodMaterialNameEn != null){
            return new ResponseEntity(null, HttpStatus.CONFLICT);
        }
        return new ResponseEntity(foodMaterialService.save(foodMaterial),HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<FoodMaterialEntity> getAllFoodMaterial(){
        return new ResponseEntity(foodMaterialService.findAll(),HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<FoodMaterialEntity> updateFoodMaterial(@RequestBody FoodMaterialEntity foodMaterial, @RequestParam(name = "id") int id){
        FoodMaterialEntity foodMaterialCheck = foodMaterialService.findFoodMaterialEntityById(id);
        if (foodMaterialCheck == null){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        foodMaterial.setId(id);
        return new ResponseEntity(foodMaterialService.save(foodMaterial),HttpStatus.OK);
    }
    @DeleteMapping
    private ResponseEntity<Integer> deleteFoodMaterial(@RequestParam(name = "id") int id){
        return new ResponseEntity(foodMaterialService.deleteFoodMaterialEntityById(id),HttpStatus.OK);
    }
}
