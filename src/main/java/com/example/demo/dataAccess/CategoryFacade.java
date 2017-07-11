//package com.example.demo.dataAccess;
//
//import com.example.demo.entities.Category;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
///**
// * Created by THANH NGA on 6/29/2017.
// */
//@Repository
//public class CategoryFacade implements ICategoryFacade {
//
//    //Init EntityManager
//    @PersistenceContext(unitName = "default")
//    private EntityManager em;
//
//    /**
//     * Get all Categories in database
//     * @param : none
//     * @return : List<Category>
//     */
//    @Override
//    public List<Category> GetAllCategories() {
//        return em.createNamedQuery("Category.FindAll",Category.class).getResultList();
//    }
//
//    /**
//     * Get Single Category by category id
//     * @param : String
//     * @return category
//     */
//    @Override
//    public Category GetCategoryById(String categoryId) {
//
//        return em.createNamedQuery("category.GetById",Category.class)
//                .setParameter("categoryId",categoryId)
//                .getSingleResult();
//    }
//
//    /**
//     * Add new category into database
//     * @param : Category
//     * @return void
//     */
//    @Override
//    public void AddCategory(Category category) {
//        em.persist(category);
//    }
//
//    /**
//     *Remove a category from database
//     * @param : Category
//     * @return : void
//     */
//    @Override
//    public void RemoveCategory(Category category) {
//        em.remove(category);
//    }
//
//    /**
//     * @Use : Edit a category in database
//     * @param : Category
//     * @return void
//     */
//    @Override
//    public void EditCategory(Category category) {
//        em.merge(category);
//    }
//}
