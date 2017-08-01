package com.example.demo.services;

import com.example.demo.models.mysqlModel.CategoryModel;

import java.util.List;

/**
 * Created by THANH NGA on 6/28/2017.
 */
public interface ICategoryService {
    /**
     * Use : Get all Categories in database
     * @param : none
     * @return : List<CategoryModel>
     */
    List<CategoryModel> GetAllCategories();
    /**
     * Use : Get Single Category by category id
     * @param : String
     * @return CategoryModel
     */
    CategoryModel GetCategoryById(String categoryId);
    /**
     * @Use : Add new category into database
     * @param : CategoryModel
     * @return void
     */
    void AddCategory(CategoryModel categoryModel);
    /**
     *@Use : Remove a category from database
     * @param : CategoryModel
     * @return : void
     */
    void RemoveCategory(CategoryModel categoryModel);
    /**
     * @Use : Edit a category in database
     * @param : CategoryModel
     * @return void
     */
    void EditCategory(CategoryModel categoryModel);
}
