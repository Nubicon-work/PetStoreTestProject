package utils;

import com.github.javafaker.Faker;
import pojos.User;

import java.util.Locale;

public class Generator {

    public static User getRandomUser() {
        Faker faker = new Faker(Locale.ENGLISH);
        return User.getBuilder()
                .setId(faker.random().nextLong(Long.MAX_VALUE))
                .setUserName(faker.funnyName().name())
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(faker.name().username() + "@gmail.com")
                .setPassword(faker.bothify("?#?#?#?#?#?#"))
                .setPhone(faker.phoneNumber().phoneNumber())
                .setUserStatus(0)
                .build();
    }

    public static User getTemplateUser() {
        return User.getBuilder()
                .setId(0)
                .setUserName("string")
                .setFirstName("string")
                .setLastName("string")
                .setEmail("string")
                .setPassword("string")
                .setPhone("string")
                .setUserStatus(0)
                .build();
    }
}
