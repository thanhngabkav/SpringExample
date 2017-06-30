package com.example.demo.dataAccess;

import com.example.demo.entities.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by THANH NGA on 6/29/2017.
 */
@Repository
public class CategoryFacade implements ICategoryFacade {
    @Override
    public List<Category> GetAllCategories() {
        return null;
    }

    @Override
    public Category GetCategoryById(String categoryId) {
        return null;
    }

    @Override
    public void AddCategory(Category category) {

    }

    @Override
    public void RemoveCategory(Category category) {

    }

    @Override
    public void EditCategory(Category category) {

    }
}
