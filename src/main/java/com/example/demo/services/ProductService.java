package com.example.demo.services;

import com.example.demo.dataAccess.IProductFacade;
import com.example.demo.entities.Product;
import com.example.demo.models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by THANH NGA on 6/30/2017.
 */
@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductFacade productFacade;

    @Override
    public List<ProductModel> GetAllProduct() {
        List<Product> productList = productFacade.GetAllProduct();
        List<ProductModel> productModelList = new ArrayList<ProductModel>();
        for(Product p : productList){
            ProductModel productModel = new ProductModel(p.getProductId(),p.getName(),p.getPrice(),p.getQuantity(),p.getCategoryId());
            productModelList.add(productModel);
        }
        return productModelList;
    }

    @Override
    public List<ProductModel> GetProductsByCategoryId(String categoryId) {
        return null;
    }

    @Override
    public ProductModel GetProductById(String productId) {
        Product p = productFacade.GetProductById(productId);
        ProductModel productModel = new ProductModel(p.getProductId(),p.getName(),p.getPrice(),p.getQuantity(),p.getCategoryId());
        return productModel;
    }

    @Override
    public void AddProduct(ProductModel productModel) {

    }

    @Override
    public void RemoveProduct(ProductModel productModel) {

    }

    @Override
    public void EditProduct(ProductModel productModel) {

    }
}
