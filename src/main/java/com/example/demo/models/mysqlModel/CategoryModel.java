package com.example.demo.models.mysqlModel;

/**
 * Created by THANH NGA on 6/30/2017.
 */
public class CategoryModel {
    private String categoryId;
    private String name;
    private String description;

    public CategoryModel(String categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public CategoryModel() {
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
