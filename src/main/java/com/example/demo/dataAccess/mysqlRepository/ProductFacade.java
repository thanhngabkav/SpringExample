package com.example.demo.dataAccess.mysqlRepository;

import com.example.demo.entities.mysqlEntities.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by THANH NGA on 6/29/2017.
 */
@Repository
public class ProductFacade implements IProductFacade{

    //Init EntityManager
    @PersistenceContext(unitName = "default")
    private EntityManager em;

    /**
     * Get all Products in database
     * @param : none
     * @return : List<Product>
     */
    @Override
    public List<Product> GetAllProduct() {
        return em.createNamedQuery("Product.FindAll",Product.class).getResultList();
    }

    /**
     * Get list products by category id
     * @param : String
     * @return : List<Product>
     */
    @Override
    public List<Product> GetProductsByCategoryId(String categoryId) {
        return em.createNamedQuery("Product.FindByCategoryId",Product.class).getResultList();
    }

    /**
     * Get Product by product id
     * @param : String
     * @return : Product
     */
    @Override
    public Product GetProductById(String productId){
        return em.createNamedQuery("Product.GetById",Product.class)
                .setParameter("productId",productId)
                .getSingleResult();
    }

    /**
     * Add new product into database
     * @param : Product
     * @return : void
     */
    @Override
    public void AddProduct(Product product) {
        em.persist(product);
    }

    /**
     * Remove a product from database
     * @param : Product
     * @return : void
     */
    @Override
    public void RemoveProduct(Product product) {
        em.remove(product);
    }

    /**
     * Edit a product in database
     * @param : Product
     * @return : void
     */
    @Override
    public void EditProduct(Product product) {
        em.merge(product);
    }
}
