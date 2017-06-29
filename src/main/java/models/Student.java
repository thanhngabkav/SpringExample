package models;

/**
 * Created by THANH NGA on 6/27/2017.
 */
public class Student {
    private String name;
    private String add;
    public Student(String name, String add){
        this.name = name;
        this.add = add;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}
