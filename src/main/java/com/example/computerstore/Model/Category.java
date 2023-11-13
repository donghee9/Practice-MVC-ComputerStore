package com.example.computerstore.Model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Category {
    private  int id;
    private String categoryName;

    private Category(String categoryName){
        this.id=IdGenerator.getNextCategoryId();
        this.categoryName=categoryName;
    }
    public static Category of(String categoryName) {
        return new Category(categoryName);
    }
}
