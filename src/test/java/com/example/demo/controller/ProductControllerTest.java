package com.example.demo.controller;

import com.example.demo.Application;
import com.example.demo.models.mysqlModel.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo.services.IProductService;
import com.example.demo.services.StudentService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by THANH NGA on 6/29/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@ContextConfiguration(classes = Application.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService productService;

    @MockBean
    private StudentService studentService;

    private List<ProductModel> productList;

    @Before
    public void setUp(){
        //Create fake data
        productList = new ArrayList<ProductModel>();
        for(int i=1;i<=10;i++) {
            productList.add(new ProductModel(i + "", i + "", i, i, i + ""));
        }
        when(productService.GetAllProduct()).thenReturn(productList);

    }
    public ProductModel FindProduct(List<ProductModel> productList,String productId){
        for (ProductModel p:productList) {
            if(p.getProductId().equals(productId)){
                return  p;
            }
        }
        return null;
    }
    public void EditProduct(List<ProductModel> productList,ProductModel product){
        for (ProductModel p:productList) {
            if(p.getProductId().equals(product.getProductId())){
                p = product;
                return;
            }
        }
    }
    @Test
    public void TestGetAllProduct() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(objectMapper.writeValueAsString(productList)));
        verify(productService,times(1)).GetAllProduct();
    }
    @Test
    public void TestGetProductById_1() throws Exception {
        mockMvc.perform(get("/products/{id}",101))
                .andExpect(status().isNotFound());
        verify(productService,times(1)).GetProductById("101");
    }

    @Test
    public void TestGetProductById_2() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String productId = "1";
        when(productService.GetProductById(productId)).thenReturn(FindProduct(productList,productId));
        mockMvc.perform(get("/products/{id}",1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(objectMapper.writeValueAsString(productList.get(0))));
        verify(productService,times(1)).GetProductById("1");
    }

//    @Test
//    public void TestCreateProduct() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Product product = new Product("111","fake",10,10,"11");
//        doAnswer(new Answer() {
//            @Override
//            public Object answer(InvocationOnMock invocation) throws Throwable {
//                productList.add(product);
//                return null;
//            }
//        }).when(productService).AddProduct(product);
//        mockMvc.perform(post("/products"))
//                .andExpect(status().isOk());
//        String productId = "111";
//        when(productService.GetProductById(productId)).thenReturn(FindProduct(productList,productId));
//        mockMvc.perform(get("/products{id}",111))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(content().json(objectMapper.writeValueAsString(product)));
//    }


}
