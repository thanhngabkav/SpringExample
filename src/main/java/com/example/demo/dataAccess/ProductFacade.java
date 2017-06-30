package com.example.demo.dataAccess;

import com.example.demo.entities.Product;
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

    @Override
    public List<Product> GetAllProduct() {
        return em.createNamedQuery("Product.FindAll",Product.class).getResultList();
    }

    @Override
    public List<Product> GetProductsByCategoryId(String categoryId) {
        return null;
    }

    @Override
    public Product GetProductById(String productId) {
        return em.createNamedQuery("Product.GetById",Product.class)
                .setParameter("productId",productId)
                .getSingleResult();
    }

    @Override
    public void AddProduct(Product product) {

    }

    @Override
    public void RemoveProduct(Product product) {

    }
    @Override
    public void EditProduct(Product product) {

    }
}
