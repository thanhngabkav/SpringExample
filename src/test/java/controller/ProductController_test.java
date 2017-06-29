package controller;

import com.example.demo.DemoApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Product;
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
import services.ProductService;
import services.StudentService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by THANH NGA on 6/29/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@ContextConfiguration(classes = DemoApplication.class)
public class ProductController_test {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;
    @MockBean
    private StudentService studentService;
    private List<Product> productList;
    @Before
    public void setUp(){
        //Create fake data
        productList = new ArrayList<Product>();
        for(int i=1;i<=10;i++){
            productList.add(new Product(i+"",i+"",i,i,i+""));
        }
        String productId="";
        Product product = null;
        when(productService.GetAllProduct()).thenReturn(productList);
        when(productService.GetProductById(productId)).thenReturn(FindProduct(productList,productId));
    }
    public Product FindProduct(List<Product> productList,String productId){
        for (Product p:productList) {
            if(p.getProductId().equals(productId)){
                return  p;
            }
        }
        return null;
    }
    public void EditProduct(List<Product> productList,Product product){
        for (Product p:productList) {
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


}
