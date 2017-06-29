package dataAccess;

import entities.Category;
import services.CategoryService;

import java.util.List;

/**
 * Created by THANH NGA on 6/29/2017.
 */
public class CategoryFacade implements CategoryService{
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
