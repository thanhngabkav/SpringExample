package com.example.demo.services;

import com.example.demo.dataAccess.mysqlRepository.ICategoryFacade;
import com.example.demo.models.mysqlModel.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by THANH NGA on 6/30/2017.
 */
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryFacade categoryFacade;

    @Override
    public List<CategoryModel> GetAllCategories() {
        return null;
    }

    @Override
    public CategoryModel GetCategoryById(String categoryId) {
        return null;
    }

    @Override
    public void AddCategory(CategoryModel categoryModel) {

    }

    @Override
    public void RemoveCategory(CategoryModel categoryModel) {

    }

    @Override
    public void EditCategory(CategoryModel categoryModel) {

    }
}
