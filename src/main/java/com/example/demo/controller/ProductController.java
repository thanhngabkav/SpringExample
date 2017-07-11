//package com.example.demo.controller;
//
//import com.example.demo.entities.Product;
//import com.example.demo.exceptions.MyDemoException;
//import com.example.demo.models.ProductModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.example.demo.services.IProductService;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by THANH NGA on 6/28/2017.
// * @use : handle request about product
// */
//@RestController
//public class ProductController {
//    //Init Product Service
//    @Autowired
//    private IProductService productService;
//
//    /**
//     * RequestMethod : GET
//     * @param  :
//     * @return : ResponseEntity
//     * Response body: list productModels
//     * produceType : Json
//     * HttpStatus : OK
//     */
//    @RequestMapping(value = "/products",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<List<ProductModel>> GetAllProduct(){
//        List<ProductModel> productModels = productService.GetAllProduct();
//        ResponseEntity<List<ProductModel>> responseEntity = new ResponseEntity<List<ProductModel>>(productModels, HttpStatus.OK);
//        return  responseEntity;
//    }
//
//    /**
//     * RequestMethod : GET
//     * @param  : String (productId)
//     * @return : ResponseEntity
//     * Response body: productModel
//     * produceType : Json
//     * HttpStatus : OK
//     */
//    @RequestMapping(value = "/products/{id}",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<ProductModel> GetProductById(@PathVariable("id") String productId) throws MyDemoException {
//        try{
//            ProductModel product = productService.GetProductById(productId);
//            //If not exit return 404
//            if(product == null)
//                return  new ResponseEntity<ProductModel>(HttpStatus.NOT_FOUND);
//            else{
//                ProductModel productModel = new ProductModel(product.getProductId(),product.getName(),product.getPrice(),product.getQuantity(),product.getCategoryId());
//                return new ResponseEntity<ProductModel>(productModel,HttpStatus.OK);
//            }
//        }catch (Exception ex){
//            throw new MyDemoException(ex.getMessage());
//        }
//
//
//    }
//    /**
//     * RequestMethod : POST
//     * @param  : Product
//     * @return : ResponseEntity
//     * Response body:
//     * produceType : Json
//     * HttpStatus : Created (201)
//     */
//    @RequestMapping(value = "/products",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity CreateProduct(@RequestBody ProductModel product) throws MyDemoException {
//        //This try catch for test exception
//        /**
//         *
//         * How to test! Null, key,...
//         */
//        try {
//            productService.AddProduct(product);
//            return new ResponseEntity(HttpStatus.CREATED);
//        }catch (Exception ex){
//            throw new MyDemoException(ex.getMessage());
//        }
//    }
//    /**
//     * RequestMethod : PUT
//     * @param  : Product
//     * @return : ResponseEntity
//     * Response body:
//     * produceType : Json
//     * HttpStatus : OK
//     */
//     @RequestMapping(value = "/products",method = RequestMethod.PUT,produces = {MediaType.APPLICATION_JSON_VALUE})
//     public ResponseEntity EditProduct(@RequestBody ProductModel product) throws MyDemoException {
//        //This try catch for test exception
//        try {
//            productService.EditProduct(product);
//            return new ResponseEntity(HttpStatus.OK);
//        }catch (Exception ex){
//            throw new MyDemoException(ex.getMessage());
//        }
//     }
//    /**
//     * RequestMethod : DELETE
//     * @param  : String (productId)
//     * @return : ResponseEntity
//     * Response body:
//     * produceType : Json
//     * HttpStatus : OK
//     */
//    @RequestMapping(value = "/products/{id}",method = RequestMethod.DELETE,produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity Delete(@PathVariable("id") String productId) throws MyDemoException {
//        /**
//         * This try catch for test exception
//         */
//        try {
//            ProductModel product = productService.GetProductById(productId);
//            //If not exit
//            if(product == null){
//                return new ResponseEntity(HttpStatus.NOT_FOUND);
//            }
//            productService.RemoveProduct(product);
//            return new ResponseEntity(HttpStatus.OK);
//        }catch (Exception ex){
//            throw new MyDemoException(ex.getMessage());
//        }
//    }
//
//}
