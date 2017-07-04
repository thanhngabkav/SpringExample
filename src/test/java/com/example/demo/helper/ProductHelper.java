package com.example.demo.helper;

import com.example.demo.entities.Product;
import com.example.demo.models.ProductModel;


/**
 * Created by THANH NGA on 7/3/2017.
 */
public class ProductHelper {
    public boolean ProductEntitties_IsEqual(Product p1, Product p2){
        if(!p1.getProductId().equals(p2.getProductId()))
            return false;
        if(! p1.getName().equals(p2.getName()))
            return false;
        if(!Double.valueOf(p1.getPrice()).equals(Double.valueOf(p2.getPrice())))
        return  false;
        if(!(p1.getQuantity() == p2.getQuantity()))
            return false;
        if(! p1.getCategoryId().equals(p2.getCategoryId()))
            return false;
        return   true;
    }
    public boolean ProductModel_IsEqual(ProductModel pm1, ProductModel pm2){
        if(!pm1.getProductId().equals(pm2.getProductId()))
            return false;
        if(! pm1.getName().equals(pm2.getName()))
            return false;
        if(!Double.valueOf(pm1.getPrice()).equals(Double.valueOf(pm2.getPrice())))
            return  false;
        if(!(pm1.getQuantity() == pm2.getQuantity()))
            return false;
        if(!pm1.getCategoryId().equals(pm2.getCategoryId()))
            return false;
        return   true;
    }
}
