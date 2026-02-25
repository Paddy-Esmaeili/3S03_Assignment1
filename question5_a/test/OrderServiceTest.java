package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class OrderServiceTest {
    private final OrderService os = new OrderService();

    private Order orderWithItem() {
        Order order = new Order();
        order.addItem(new OrderItem("Widget", 2, 50.0));
        return order;
    }

    @Test
    void validPaymentWithNoDiscountReturnsCorrectTotal() {
        Order order = orderWithItem();
        // subtotal=100, no discount, tax=20 → 120
        double total = os.processOrder(order, "", "card");
        assertEquals(120.0, total, 0.001);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    void validPaymentWithStudentDiscountApplied() {
        Order order = orderWithItem();
        // subtotal=100, 10% off → 90, tax=18 → 108
        double total = os.processOrder(order, "STUDENT10", "paypal");
        assertEquals(108.0, total, 0.001);
    }

    @Test
    void validPaymentWithBlackFridayDiscount() {
        Order order = orderWithItem();
        // subtotal=100, 30% off → 70, tax=14 → 84
        double total = os.processOrder(order, "BLACKFRIDAY", "card");
        assertEquals(84.0, total, 0.001);
    }

    @Test
    void invalidPaymentMethodCancelsOrderAndReturnsZero() {
        Order order = orderWithItem();
        double total = os.processOrder(order, "", "crypto");
        assertEquals(0.0, total);
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }

    @Test
    void nullPaymentMethodCancelsOrder() {
        Order order = orderWithItem();
        double total = os.processOrder(order, "", null);
        assertEquals(0.0, total);
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }

    @Test
    void invalidDiscountCodeThrowsDuringProcessing() {
        Order order = orderWithItem();
        assertThrows(IllegalArgumentException.class,
            () -> os.processOrder(order, "INVALID", "card"));
    }
}