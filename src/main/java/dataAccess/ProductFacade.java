package dataAccess;

import entities.Product;
import org.springframework.stereotype.Repository;
import services.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by THANH NGA on 6/29/2017.
 */
@Repository
public class ProductFacade implements ProductService{
    //Init EntityManager
    @PersistenceContext(unitName = "Entities")
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
        return null;
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
