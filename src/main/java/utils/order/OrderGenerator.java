package utils.order;

import com.github.javafaker.Faker;
import enums.OrderStatus;
import pojos.Order;
import pojos.Pet;

import java.util.Date;
import java.util.Locale;

public class OrderGenerator {

    public static Order getRandomOrder(Pet pet) {
        Faker faker = new Faker(Locale.ENGLISH);
        return Order.getBuilder()
                .setId(faker.random().nextLong(9) + 1)
                .setPetId(pet.id)
                .setQuantity(faker.random().nextInt(Integer.MAX_VALUE))
                .setShipDate(new Date())
                .setStatus(OrderStatus.PLACED)
                .setComplete(false)
                .build();
    }
}
