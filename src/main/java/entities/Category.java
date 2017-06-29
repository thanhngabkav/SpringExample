package entities;

import javax.persistence.*;

/**
 * Created by THANH NGA on 6/28/2017.
 */
@NamedQueries({
        //Get All Categories
        @NamedQuery(name = "Category.FindAll",query = "Select c from Category c"),
        //Get category by categoryId
        @NamedQuery(name = "Category.FindById",query = "Select c from Category c where c.categoryId=:categoryId")
})
@Entity
public class Category {
    private String categoryId;
    private String name;
    private String description;

    @Id
    @Column(name = "CategoryId")
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
