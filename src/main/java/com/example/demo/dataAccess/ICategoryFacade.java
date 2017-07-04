package com.example.demo.dataAccess;

import com.example.demo.entities.Category;

import java.util.List;

/**
 * Created by THANH NGA on 6/30/2017.
 */
public interface ICategoryFacade {
    /**
     * Use : Get all Categories in database
     * @param : none
     * @return : List<Category>
     */
    List<Category> GetAllCategories();
    /**
     * Use : Get Single Category by category id
     * @param : String
     * @return category
     */
    Category GetCategoryById(String categoryId);
    /**
     * @Use : Add new category into database
     * @param : Category
     * @return void
     */
    void AddCategory(Category category);
    /**
     *@Use : Remove a category from database
     * @param : Category
     * @return : void
     */
    void RemoveCategory(Category category);
    /**
     * @Use : Edit a category in database
     * @param : Category
     * @return void
     */
    void EditCategory(Category category);
}
