package com.william.healthytalk.controller.Food;

import com.william.healthytalk.entity.Food.DishEntity;
import com.william.healthytalk.service.FoodService.IDishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/dish")
@Slf4j
public class DishController{
    @Autowired
    IDishService dishService;
    @PostMapping
    private ResponseEntity<DishEntity> createDish(@RequestBody DishEntity dishEntity){
        DishEntity dishNameEn = dishService.findDishEntityByNameEn(dishEntity.getNameEn());
        DishEntity dishNameVi = dishService.findDishEntityByNameVi(dishEntity.getNameVi());
        if (dishNameVi != null || dishNameEn != null){
            return new ResponseEntity(null, HttpStatus.CONFLICT);
        }
        return new ResponseEntity(dishService.save(dishEntity), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<DishEntity> getAllDish(){
        Iterable<DishEntity> dishEntities = dishService.findAll();
        return new ResponseEntity(dishEntities,HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<DishEntity> updateDish(@RequestBody DishEntity dishEntity){
       DishEntity dishCheck =  dishService.findDishEntityById(dishEntity.getId());
       if (dishCheck == null){
           return new ResponseEntity(null, HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity(dishService.save(dishEntity),HttpStatus.OK);
    }

    @DeleteMapping
    private ResponseEntity<DishEntity> deleteDish(@RequestParam(name = "id") int id){
        return new ResponseEntity(dishService.deleteDishEntityById(id),HttpStatus.OK);
    }
}
