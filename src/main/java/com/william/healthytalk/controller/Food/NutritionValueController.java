package com.william.healthytalk.controller.Food;

import com.william.healthytalk.entity.Food.NutritionValueEntity;
import com.william.healthytalk.service.FoodService.INutritionValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/nutritation-value")
@Slf4j
public class NutritionValueController {
    @Autowired
    INutritionValueService nutritationValueService;

    @PostMapping
    private ResponseEntity<NutritionValueEntity> createNutritationValue(@RequestBody NutritionValueEntity nutritionValueEntity){
        return new ResponseEntity(nutritationValueService.save(nutritionValueEntity), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<NutritionValueEntity>  getAll(){
        return new ResponseEntity(nutritationValueService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<NutritionValueEntity> updateNutritation(@RequestBody NutritionValueEntity nutritionValueEntity){
        return new ResponseEntity(nutritationValueService.save(nutritionValueEntity),HttpStatus.OK);
    }

    @DeleteMapping
    private ResponseEntity<NutritionValueEntity> deleteNutrition(@RequestParam(name = "id") int id){
        return new ResponseEntity(nutritationValueService.deleteNutritionValueEntityById(id),HttpStatus.OK);
    }
}
