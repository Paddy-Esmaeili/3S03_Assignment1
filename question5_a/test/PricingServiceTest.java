package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class PricingServiceTest {
    private final PricingService ps = new PricingService();

    @Test
    void subtotalSumsAllItems() {
        Order order = new Order();
        order.addItem(new OrderItem("A", 2, 10.0));
        order.addItem(new OrderItem("B", 1, 5.0));
        assertEquals(25.0, ps.calculateSubtotal(order), 0.001);
    }

    @Test
    void subtotalEmptyOrderIsZero() {
        assertEquals(0.0, ps.calculateSubtotal(new Order()));
    }

    @Test
    void taxOnZeroIsZero() {
        assertEquals(0.0, ps.calculateTax(0.0));
    }

    @Test
    void taxIsTwentyPercent() {
        assertEquals(20.0, ps.calculateTax(100.0), 0.001);
    }

    @Test
    void negativeTaxSubtotalThrows() {
        assertThrows(IllegalArgumentException.class, () -> ps.calculateTax(-1.0));
    }
}