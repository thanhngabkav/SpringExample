package com.example.demo.dataAccess.mysqlRepository;

import com.example.demo.entities.mysqlEntities.Category;

import java.util.List;

/**
 * Created by THANH NGA on 6/30/2017.
 */
public interface ICategoryFacade {
    /**
     * Get all Categories in database
     * @param : none
     * @return : List<Category>
     */
    List<Category> GetAllCategories();
    /**
     * Get Single Category by category id
     * @param : String
     * @return category
     */
    Category GetCategoryById(String categoryId);
    /**
     * Add new category into database
     * @param : Category
     * @return void
     */
    void AddCategory(Category category);
    /**
     *Remove a category from database
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
