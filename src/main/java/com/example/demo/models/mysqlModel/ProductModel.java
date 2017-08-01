package com.example.demo.models.mysqlModel;

/**
 * Created by THANH NGA on 6/29/2017.
 */
public class ProductModel {
    private String productId;
    private String name;
    private double price;
    private int quantity;
    private String categoryId;

    public ProductModel(String productId, String name, double price, int quantity, String categoryId) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public ProductModel() {
        this("","",-1,-1,"");
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }
}
