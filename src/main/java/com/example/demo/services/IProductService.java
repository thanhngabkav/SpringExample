package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.models.ProductModel;

import java.util.List;

/**
 * Created by THANH NGA on 6/28/2017.
 */
public interface IProductService {
    /**
     * Use : Get all Products in database
     * @param : none
     * @return : List<ProductModel>
     */
    List<ProductModel> GetAllProduct();
    /**
     * Use : Get list products by category id
     * @param : String
     * @return : List<ProductModel>
     */
    List<ProductModel> GetProductsByCategoryId(String categoryId);
    /**
     * Use : Get Product by product id
     * @param : String
     * @return : ProductModel
     */
    ProductModel GetProductById(String productId);
    /**
     * Use : Add new product into database
     * @param : ProductModel
     * @return : void
     */
    void AddProduct(ProductModel productModel);
    /**
     * Use : Remove a product from database
     * @param : ProductModel
     * @return : void
     */
    void RemoveProduct(ProductModel productModel);
    /**
     * Use : Edit a product in database
     * @param : ProductModel
     * @return : void
     */
    void EditProduct(ProductModel productModel);



}
