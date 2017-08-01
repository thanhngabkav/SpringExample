package com.example.demo.dataAccess;

import com.example.demo.dataAccess.mysqlRepository.IProductFacade;
import com.example.demo.entities.mysqlEntities.Product;
import com.example.demo.helper.ProductHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by THANH NGA on 7/3/2017.
 * Uncompleted
 * @Error: Can not load database
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductFacadeTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private IProductFacade productFacade;

    @Test
    public void AddProduct(){
        ProductHelper productHelper = new ProductHelper();
        em.persist(new Product("T_1","test",10,10,"1"));
        Product product = productFacade.GetProductById("T_1");
        Assert.assertTrue(productHelper.ProductEntitties_IsEqual(product,new Product("T_1","test",10,10,"1")));
    }
}
