package com.william.healthytalk.method;

import com.william.healthytalk.constants.HealthStatsContants;

public class HealthStatsMethod {

    public static final double  bmiCalculator(double weight, double height) {
        // chỉ số bmi là chi so beo phi
        double heightM = height / 100;
        return weight / (heightM * heightM);
    }

    public static final double bmrCalculator(String gender, double weight, double height, int age) {
        //Mifflin St Jeor
        /// weight (kg), height(cm), age(year)
        //chỉ số bmr được tính thông thông tin hiện tại của user
        if (gender == HealthStatsContants.Gender_male) {
            double bmr = (10 * weight) + (6.25 * height) - (5 * age) + 5;
            return bmr;
        }
        double bmr = (10 * weight) + (6.25 * height) - (5 * age) - 161;
        return bmr;
    }

    public static final double tdeeCalculator(double bmr,double r){
        // chỉ số tdee là calories cần hấp thu với mức cân hiện tại của user
        return bmr * r;
    }

    public static final double caloriesTarget(double tdee,String target){
        //tính được lượng calo cần hấp thụ theo mục tiêu dựa vào chỉ số tdee
        if (target == HealthStatsContants.Weight_gain) {
            return tdee + HealthStatsContants.calories_tdee_target;
        }
        if (target == HealthStatsContants.Weight_loss) {
            return tdee - HealthStatsContants.calories_tdee_target;
        }
        return tdee;
    }

    public static final double fatValueGram(double tdee_weight_loss){
        // gram
        // tính fat cần hấp thu dựa theo tdee đã tính toán theo nhu cầu của user
        return (HealthStatsContants.Fat_percent * tdee_weight_loss) / 9;
    }

    public static final double fatvalueCalories(double tdee_weight_loss){
        // calories
        // tính fat cần hấp thu dựa theo tdee đã tính toán theo nhu cầu của user
        return (HealthStatsContants.Fat_percent * tdee_weight_loss);
    }

    public static final double proteinValueGram(double weightTarget){
        // gram
        // tính lượng protein cần hấp thụ dựa theo vào số cân mục tiêu của user
        return weightTarget * 2.2;
    }

    public static final double proteinValueCalories(double weightTarget){
        // calories
        // tính lượng protein cần hấp thụ dựa theo vào số cân mục tiêu của user
        return (weightTarget * 2.2) * 4;
    }

    public static final double carbValueGram(double tdee_weight_loss,double protein_calories,double fat_calories){
        //gram
        // tính lượng card dựa vào chỉ số tdee đã tính toán theo nhu cầu của user và chỉ ố fat , protein
        double carb = tdee_weight_loss - (protein_calories + fat_calories);
        carb = carb / 4;
        return carb;
    }

    public static final double carbValueCalories(double tdee_weight_loss,double protein_calories,double fat_calories){
        //calories
        // tính lượng carb dựa vào chỉ số tdee đã tính toán theo nhu cầu của user và chỉ ố fat , protein
        double carb = tdee_weight_loss - (protein_calories + fat_calories);
        return carb;
    }

    public static final double idealWeight(double height){
        return (height - 100) * 0.9;
    }

    public static final double minWeight(double height){
        return (height - 100) * 0.8;
    }

    public static final double maxWeight(double height){
        return height - 100;
    }
}
