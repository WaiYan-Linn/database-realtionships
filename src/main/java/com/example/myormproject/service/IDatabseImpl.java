package com.example.myormproject.service;

import com.example.myormproject.domain.*;
import com.example.myormproject.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IDatabseImpl implements CageAnimal,AnimalCategory, FoodItemAnimal,FoodItemSupplier {

    private final CageRepository cageRepository;
    private final AnimalRepository animalRepository;
    private final CategoryRepository categoryRepository;
    private final FoodItemRepository foodItemRepository;
    private final SupplierRepository supplierRepository;

    public IDatabseImpl(CageRepository cageRepository, AnimalRepository animalRepository,CategoryRepository categoryRepository,
                        FoodItemRepository foodItemRepository,SupplierRepository supplierRepository) {

        this.cageRepository = cageRepository;
        this.animalRepository = animalRepository;
        this.categoryRepository = categoryRepository;
        this.foodItemRepository = foodItemRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    @Transactional
    public void cageAnimalTable() {
        Cage cage1 = new Cage(1,"Dolphinarium");
        Cage cage2 = new Cage(2,"Menagerie");
        Cage cage3 = new Cage(7,"Menagerie2");
        Cage cage4 = new Cage(3,"Pond");
        Cage cage5 = new Cage(4,"Lake1");
        Cage cage6 = new Cage(5,"Lake2");
        Cage cage7 = new Cage(6,"Element-House");
        Cage cage8 = new Cage(7,"Bird-House");


        Animal animal1 = new Animal(15,"Dolphin");
        Animal animal2 = new Animal(10,"Tiger");
        Animal animal3 = new Animal(10,"Lion");
        Animal animal4 = new Animal(70,"Fish");
        Animal animal5 = new Animal(10,"Snake");
        Animal animal6 = new Animal(7,"Crocodile");
        Animal animal7 = new Animal(10,"Elephant");
        Animal animal8 = new Animal(20,"Bird");

        cageRepository.save(cage1);
        cageRepository.save(cage2);
        cageRepository.save(cage3);
        cageRepository.save(cage4);
        cageRepository.save(cage5);
        cageRepository.save(cage6);
        cageRepository.save(cage7);
        cageRepository.save(cage8);

        cage1.setAnimal(animal1);
        cage2.setAnimal(animal2);
        cage3.setAnimal(animal3);
        cage4.setAnimal(animal4);
        cage5.setAnimal(animal5);
        cage6.setAnimal(animal6);
        cage7.setAnimal(animal7);
        cage8.setAnimal(animal8);


    }

    @Override
    @Transactional
    public void animalCategoryTable() {
        Category category1 = new Category("Commerson's dolphin");
        Category category2 = new Category("Carnivorus");
        Category category4 = new Category("Cod");
        Category category5 = new Category("King Cobra");
        Category category7 = new Category("Asian Elephant");
        Category category8 = new Category("American Birds");

        animalRepository.getOne(1).setCategory(category1);
        animalRepository.getOne(2).setCategory(category2);
        animalRepository.getOne(3).setCategory(category2);
        animalRepository.getOne(4).setCategory(category4);
        animalRepository.getOne(5).setCategory(category5);
        animalRepository.getOne(6).setCategory(category2);
        animalRepository.getOne(7).setCategory(category7);
        animalRepository.getOne(8).setCategory(category8);

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category4);
        categoryRepository.save(category5);
        categoryRepository.save(category7);
        categoryRepository.save(category8);


    }

    @Override
    @Transactional
    public void foodItemAnimalTable() {
        FoodItem foodItem1 = new FoodItem("Squids",50);
        FoodItem foodItem2 = new FoodItem("Meat",200);
        FoodItem foodItem3 = new FoodItem("Worms",100);
        FoodItem foodItem4 = new FoodItem("Frogs",50);
        FoodItem foodItem5 = new FoodItem("Sugar_Cane",50);
        FoodItem foodItem6 = new FoodItem("Insects",300);

        foodItem1.getAnimalList().add(animalRepository.getOne(1)); //dolphin
        foodItem2.getAnimalList().add(animalRepository.getOne(2)); //tiger
        foodItem2.getAnimalList().add(animalRepository.getOne(3)); //lion
        foodItem3.getAnimalList().add(animalRepository.getOne(4)); //fish
        foodItem4.getAnimalList().add(animalRepository.getOne(5));//snake
        foodItem4.getAnimalList().add(animalRepository.getOne(6));//crocodile
        foodItem5.getAnimalList().add(animalRepository.getOne(7));//elephant
        foodItem6.getAnimalList().add(animalRepository.getOne(8));//bird

        animalRepository.getOne(1).getFoodItemList().add(foodItem1);
        animalRepository.getOne(2).getFoodItemList().add(foodItem2);
        animalRepository.getOne(3).getFoodItemList().add(foodItem2);
        animalRepository.getOne(4).getFoodItemList().add(foodItem3);
        animalRepository.getOne(5).getFoodItemList().add(foodItem4);
        animalRepository.getOne(5).getFoodItemList().add(foodItem6);
        animalRepository.getOne(6).getFoodItemList().add(foodItem2);
        animalRepository.getOne(6).getFoodItemList().add(foodItem4);
        animalRepository.getOne(7).getFoodItemList().add(foodItem5);
        animalRepository.getOne(8).getFoodItemList().add(foodItem6);


        foodItemRepository.save(foodItem1);
        foodItemRepository.save(foodItem2);
        foodItemRepository.save(foodItem3);
        foodItemRepository.save(foodItem4);
        foodItemRepository.save(foodItem5);
        foodItemRepository.save(foodItem6);


    }

    @Override
    @Transactional
    public void foodItemSupplierTable() {
        Supplier supplier1 = new Supplier("Aung Aung",778206157,"Yangon");
        Supplier supplier2 = new Supplier("Swann Swan",778206156,"Yangon");

        supplierRepository.save(supplier1);
        supplierRepository.save(supplier2);


        foodItemRepository.getOne(1).setSupplier(supplier1);
        foodItemRepository.getOne(2).setSupplier(supplier1);
        foodItemRepository.getOne(3).setSupplier(supplier1);
        foodItemRepository.getOne(4).setSupplier(supplier2);
        foodItemRepository.getOne(5).setSupplier(supplier2);
        foodItemRepository.getOne(6).setSupplier(supplier2);



    }
}

