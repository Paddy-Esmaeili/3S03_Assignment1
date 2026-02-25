package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiscountServiceTest {
    private final DiscountService ds = new DiscountService();

    @Test
    void nullCodeReturnsSubtotal() {
        assertEquals(100.0, ds.applyDiscount(100.0, null));
    }

    @Test
    void blankCodeReturnsSubtotal() {
        assertEquals(100.0, ds.applyDiscount(100.0, "   "));
    }

    @Test
    void student10AppliesTenPercent() {
        assertEquals(90.0, ds.applyDiscount(100.0, "STUDENT10"), 0.001);
    }

    @Test
    void student10IsCaseInsensitive() {
        assertEquals(90.0, ds.applyDiscount(100.0, "student10"), 0.001);
    }

    @Test
    void blackFridayAppliesThirtyPercent() {
        assertEquals(70.0, ds.applyDiscount(100.0, "BLACKFRIDAY"), 0.001);
    }

    @Test
    void invalidCodeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> ds.applyDiscount(100.0, "INVALID"));
    }

    @Test
    void unknownCodeReturnsSubtotal() {
        assertEquals(100.0, ds.applyDiscount(100.0, "MYSTERY"));
    }
}