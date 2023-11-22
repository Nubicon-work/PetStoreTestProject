package utils.pet;

import com.github.javafaker.Faker;
import enums.PetStatus;
import pojos.Category;
import pojos.Pet;
import pojos.Tag;

import java.util.Locale;

public class PetGenerator {

    public static Pet getRandomPet() {
        Faker faker = new Faker(Locale.ENGLISH);
        return Pet.getBuilder()
                .setId(faker.random().nextLong(Long.MAX_VALUE))
                .setCategory(new Category(faker.random().nextLong(Long.MAX_VALUE), faker.cat().breed()))
                .setName(faker.cat().name())
                .addTag(new Tag(faker.random().nextLong(Long.MAX_VALUE), faker.hacker().adjective()))
                .setStatus(PetStatus.AVAILABLE)
                .build();
    }

    public static Pet getRandomPetWithIdNameAndStatus() {
        Faker faker = new Faker(Locale.ENGLISH);
        return Pet.getBuilder()
                .setId(faker.random().nextLong(Long.MAX_VALUE))
                .setName(faker.cat().name())
                .setStatus(PetStatus.AVAILABLE)
                .build();
    }

    public static String getRandomPetName() {
        Faker faker = new Faker(Locale.ENGLISH);
        return faker.cat().name();
    }

    public static String getOtherPetStatus(String status) {
        switch (status) {
            case "available":
                return "sold";
            case "sold":
                return "pending";
            case "pending":
                return "available";
            default:
                return "available";
        }
    }

    public static Tag getPetTag() {
        Faker faker = new Faker(Locale.ENGLISH);
        return new Tag(faker.random().nextLong(Long.MAX_VALUE), faker.hacker().noun());
    }
}
