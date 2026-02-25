package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class OrderItemTest {

    @Test
    void validItemComputesTotalPrice() {
        OrderItem item = new OrderItem("Book", 3, 10.0);
        assertEquals(30.0, item.getTotalPrice(), 0.001);
    }

    @Test
    void zeroQuantityThrows() {
        assertThrows(IllegalArgumentException.class, () -> new OrderItem("Book", 0, 10.0));
    }

    @Test
    void negativeQuantityThrows() {
        assertThrows(IllegalArgumentException.class, () -> new OrderItem("Book", -1, 10.0));
    }

    @Test
    void negativeUnitPriceThrows() {
        assertThrows(IllegalArgumentException.class, () -> new OrderItem("Book", 1, -5.0));
    }

    @Test
    void zeroPriceIsAllowed() {
        OrderItem item = new OrderItem("Freebie", 2, 0.0);
        assertEquals(0.0, item.getTotalPrice());
    }

    @Test
    void getQuantityReturnsCorrectValue() {
        OrderItem item = new OrderItem("Pen", 5, 1.0);
        assertEquals(5, item.getQuantity());
    }
}