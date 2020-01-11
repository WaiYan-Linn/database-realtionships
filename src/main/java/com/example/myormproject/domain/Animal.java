package com.example.myormproject.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int totalNo;
    private String type;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @ManyToMany
    private List<FoodItem> foodItemList = new ArrayList<>();

    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    public void setFoodItemList(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Animal() {
    }

    public Animal(int totalNo,String type){
        this.totalNo=totalNo;
        this.type=type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTotalNo() {
        return totalNo;
    }

    public void setTotalNo(int totalNo) {
        this.totalNo = totalNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", totalNo=" + totalNo +
                ", type='" + type + '\'' +
                '}';
    }
}
