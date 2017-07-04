package com.example.demo.dataAccess;

import com.example.demo.Application;
import com.example.demo.configruation.DBConfig;
import com.example.demo.entities.Product;
import com.example.demo.helper.ProductHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * Created by THANH NGA on 7/3/2017.
 * Uncompleted
 * @Error: Can not load database
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class ProductFacadeTest {

    @Autowired
    private EntityManager em;

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
