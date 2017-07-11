//package com.example.demo.dataAccess;
//
//import com.example.demo.entities.Product;
//
//import java.util.List;
//
///**
// * Created by THANH NGA on 6/30/2017.
// */
//public interface IProductFacade {
//    /**
//     * Get all Products in database
//     * @param : none
//     * @return : List<Product>
//     */
//    List<Product> GetAllProduct();
//    /**
//     * Get list products by category id
//     * @param : String
//     * @return : List<Product>
//     */
//    List<Product> GetProductsByCategoryId(String categoryId);
//    /**
//     * Get Product by product id
//     * @param : String
//     * @return : Product
//     */
//    Product GetProductById(String productId);
//    /**
//     * Add new product into database
//     * @param : Product
//     * @return : void
//     */
//    void AddProduct(Product product);
//    /**
//     * Remove a product from database
//     * @param : Product
//     * @return : void
//     */
//    void RemoveProduct(Product product);
//    /**
//     * Edit a product in database
//     * @param : Product
//     * @return : void
//     */
//    void EditProduct(Product product);
//
//}
