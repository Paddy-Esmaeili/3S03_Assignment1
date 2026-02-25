package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void newOrderHasCreatedStatus() {
        Order order = new Order();
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }

    @Test
    void canAddItemWhenCreated() {
        Order order = new Order();
        order.addItem(new OrderItem("Hat", 1, 20.0));
        assertEquals(1, order.getItems().size());
    }

    @Test
    void addItemAfterProcessedThrows() {
        Order order = new Order();
        order.setStatus(OrderStatus.PAID);
        assertThrows(IllegalStateException.class,
            () -> order.addItem(new OrderItem("Hat", 1, 20.0)));
    }

    @Test
    void setStatusUpdatesStatus() {
        Order order = new Order();
        order.setStatus(OrderStatus.CANCELLED);
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }
}