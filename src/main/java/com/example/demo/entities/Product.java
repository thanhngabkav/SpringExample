package com.example.demo.entities;

import javax.persistence.*;

/**
 * Created by THANH NGA on 6/28/2017.
 */
@Entity
@Table(name = "Product")
@NamedQueries({
        @NamedQuery(name = "Product.FindAll",query = "select p from Product p"),
        @NamedQuery(name = "Product.GetById",query = "select p from Product p where p.productId=:productId")
})
public class Product {
    @Id
    private String productId;
    private String name;
    private double price;
    private int quantity;
    private String categoryId;

    public Product(String productId, String name, double price, int quantity, String categoryId) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public Product() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        if (quantity != product.quantity) return false;
        if (productId != null ? !productId.equals(product.productId) : product.productId != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantity;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "CategoryId", nullable = false,insertable = false,updatable = false)
    private Category category;


}
