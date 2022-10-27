package com.william.healthytalk.controller.statistics;

import com.william.healthytalk.entity.statistics.HealthStatsEntity;
import com.william.healthytalk.entity.statistics.HealthStatsValue;
import com.william.healthytalk.method.HealthStatsMethod;
import com.william.healthytalk.service.stastics.IHealthStatsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/health-stats")
@Slf4j
public class HealthStatsController {
    @Autowired
    IHealthStatsService healthStatsService;
    @GetMapping
    private ResponseEntity<HealthStatsEntity> getAll(){
        return new ResponseEntity(healthStatsService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<HealthStatsEntity> createHealthStats(@RequestBody HealthStatsValue healthStatsValue,
                                                                @RequestParam(name = "gender") String gender,
                                                                @RequestParam(name = "age") int age)
    {
        HealthStatsEntity healthStatsEntity = new HealthStatsEntity();

        double bmr = HealthStatsMethod.bmrCalculator(gender,healthStatsValue.getWeight(),healthStatsValue.getHeight(), age);
        double bmi = HealthStatsMethod.bmiCalculator(healthStatsValue.getWeight(),healthStatsValue.getWeight());
        /// cần sử lý R từ input của user
        double tdee = HealthStatsMethod.tdeeCalculator(bmr, healthStatsValue.getR());
        double ideal_weight = HealthStatsMethod.idealWeight(healthStatsValue.getHeight());
        double min_weight = HealthStatsMethod.minWeight(healthStatsValue.getHeight());
        double max_weight = HealthStatsMethod.maxWeight(healthStatsValue.getHeight());
        /// cần sử lý target lấy từ action của user
        double calories_in = HealthStatsMethod.caloriesTarget(tdee, healthStatsValue.getTarget());
        double protein_in = HealthStatsMethod.proteinValueGram(healthStatsValue.getWeight_target());
        double fat_in = HealthStatsMethod.fatValueGram(calories_in);
        double protein_calories = HealthStatsMethod.proteinValueCalories(healthStatsValue.getWeight_target());
        double fat_calories = HealthStatsMethod.fatvalueCalories(calories_in);
        double carb_in = HealthStatsMethod.carbValueGram(calories_in, protein_calories, fat_calories);

        healthStatsEntity.setAge(age);
        healthStatsEntity.setGender(gender);
        healthStatsEntity.setWeight(healthStatsValue.getWeight());
        healthStatsEntity.setHeight(healthStatsValue.getHeight());
        healthStatsEntity.setWeightTarget(healthStatsValue.getWeight_target());
        healthStatsEntity.setBmi(bmi);
        healthStatsEntity.setBmr(bmr);
        healthStatsEntity.setTdee(tdee);
        healthStatsEntity.setIdealWeight(ideal_weight);
        healthStatsEntity.setMinWeight(min_weight);
        healthStatsEntity.setMaxWeight(max_weight);
        healthStatsEntity.setCaloriesIn(calories_in);
        healthStatsEntity.setProteinIn(protein_in);
        healthStatsEntity.setFatIn(fat_in);
        healthStatsEntity.setCarbsIn(carb_in);



    }
}
