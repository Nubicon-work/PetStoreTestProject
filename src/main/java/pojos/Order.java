package pojos;

import enums.OrderStatus;
import interfaces_and_abstract_classes.Entity;

import java.time.LocalDate;
import java.util.Date;

public class Order extends Entity {

    public long petId;
    public int quantity;
    public Date shipDate;
    public String status;
    public boolean complete;

    public Order() {}

    public static Order.Builder getBuilder() {
        return new Order().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Order.Builder setId(long id) {
            Order.this.id = id;
            return this;
        }

        public Order.Builder setPetId(long petId) {
            Order.this.petId = petId;
            return this;
        }

        public Order.Builder setQuantity(int quantity) {
            Order.this.quantity = quantity;
            return this;
        }

        public Order.Builder setShipDate(Date date) {
            Order.this.shipDate = date;
            return this;
        }

        public Order.Builder setStatus(OrderStatus status) {
            Order.this.status = status.getStatus();
            return this;
        }

        public Order.Builder setComplete(boolean complete) {
            Order.this.complete = complete;
            return this;
        }

        public Order build() {
            return Order.this;
        }
    }
}
