package pojos;

import interfaces_and_abstract_classes.Entity;

public class Category extends Entity {

    public String name;

    public Category(long id, String name) {
        super(id);
        this.name = name;
    }

    public Category() {}
}
