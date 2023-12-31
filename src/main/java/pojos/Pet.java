package pojos;

import enums.PetStatus;
import interfaces_and_abstract_classes.Entity;

import java.util.ArrayList;

public class Pet extends Entity {

    public Category category;
    public String name;
    public ArrayList<String> photoUrls;
    public ArrayList<Tag> tags;
    public String status;

    public Pet() {
        this.photoUrls = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    public static Pet.Builder getBuilder() {
        return new Pet().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Pet.Builder setId(long id) {
            Pet.this.id = id;
            return this;
        }

        public Pet.Builder setCategory(Category category) {
            Pet.this.category = category;
            return this;
        }

        public Pet.Builder setName(String name) {
            Pet.this.name = name;
            return this;
        }

        public Pet.Builder addPhoto(String url) {
            Pet.this.photoUrls.add(url);
            return this;
        }

        public Pet.Builder addTag(Tag tag) {
            Pet.this.tags.add(tag);
            return this;
        }

        public Pet.Builder setStatus(PetStatus status) {
            Pet.this.status = status.getStatus();
            return this;
        }

        public Pet build() {
            return Pet.this;
        }
    }
}
