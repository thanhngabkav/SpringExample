package com.example.demo.services;

import com.example.demo.dataAccess.IProductFacade;
import com.example.demo.entities.Product;
import com.example.demo.helper.ProductHelper;
import com.example.demo.models.ProductModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by THANH NGA on 6/30/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @MockBean
    private IProductFacade productFacade;

    @Autowired
    private IProductService productService;

    private List<Product> productList;

    @Before
    public void SetUp(){
        productList = new ArrayList<Product>();
        for(int i = 1; i <= 10 ; i++){
            productList.add(new Product(i+"",i+"",i,i,i+""));
        }
    }
    @Test
    public void GetAllProductTest(){
        when(productFacade.GetAllProduct()).thenReturn(productList);
        List<ProductModel> expectedResult = new ArrayList<ProductModel>();
        for( Product p : productList){
            expectedResult.add(new ProductModel(p.getProductId(),p.getName(),p.getPrice(),p.getQuantity(),p.getCategoryId()));
        }
        List<ProductModel> actualResult = productService.GetAllProduct();
        Assert.assertEquals(expectedResult.size(),actualResult.size());
        ProductHelper productHelper = new ProductHelper();
        for (int i=0;i<expectedResult.size();i++){
            Assert.assertTrue(productHelper.ProductModel_IsEqual(expectedResult.get(i),actualResult.get(i)));
        }
    }
}
