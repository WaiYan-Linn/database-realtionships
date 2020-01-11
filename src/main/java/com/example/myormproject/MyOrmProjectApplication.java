package com.example.myormproject;

import com.example.myormproject.domain.FoodItem;
import com.example.myormproject.repository.*;
import com.example.myormproject.service.AnimalCategory;
import com.example.myormproject.service.CageAnimal;
import com.example.myormproject.service.FoodItemAnimal;
import com.example.myormproject.service.FoodItemSupplier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class MyOrmProjectApplication {

    private final CageAnimal cageAnimal;
    private final AnimalCategory animalCategory;
    private final FoodItemAnimal foodItemAnimal;
    private final FoodItemSupplier foodItemSupplier;

    public MyOrmProjectApplication(CageAnimal cageAnimal, AnimalCategory animalCategory, FoodItemAnimal foodItemAnimal,
                                    FoodItemSupplier foodItemSupplier) {
        this.cageAnimal = cageAnimal;
        this.animalCategory = animalCategory;
        this.foodItemAnimal = foodItemAnimal;
        this.foodItemSupplier = foodItemSupplier;
    }



    public static void main(String[] args) {
        SpringApplication.run(MyOrmProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
          cageAnimal.cageAnimalTable();
          animalCategory.animalCategoryTable();
          foodItemAnimal.foodItemAnimalTable();
          foodItemSupplier.foodItemSupplierTable();

        };
   }
}
