package pojos;

import interfaces_and_abstract_classes.Entity;

public class Tag extends Entity {

    public String name;

    public Tag(long id, String name) {
        super(id);
        this.name = name;
    }

    public Tag() {}
}
