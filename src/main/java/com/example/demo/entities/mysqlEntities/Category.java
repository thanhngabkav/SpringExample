package com.example.demo.entities.mysqlEntities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by THANH NGA on 6/28/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Category.FindAll", query = "select c from Category c"),
        @NamedQuery(name = "Category.GetById", query = "select c from Category c where c.categoryId=:categoryId"),
})
@Table(name = "Category")
public class Category {
    @Id
    private String categoryId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    public Category() {
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (categoryId != null ? !categoryId.equals(category.categoryId) : category.categoryId != null) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        if (description != null ? !description.equals(category.description) : category.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId != null ? categoryId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
