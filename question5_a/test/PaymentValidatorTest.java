package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class PaymentValidatorTest {
    private final PaymentValidator pv = new PaymentValidator();

    @Test
    void nullPaymentReturnsFalse() {
        assertFalse(pv.isPaymentMethodValid(null));
    }

    @Test
    void cardIsValid() {
        assertTrue(pv.isPaymentMethodValid("card"));
    }

    @Test
    void cardIsCaseInsensitive() {
        assertTrue(pv.isPaymentMethodValid("CARD"));
    }

    @Test
    void paypalIsValid() {
        assertTrue(pv.isPaymentMethodValid("paypal"));
    }

    @Test
    void cryptoIsInvalid() {
        assertFalse(pv.isPaymentMethodValid("crypto"));
    }

    @Test
    void unknownMethodThrows() {
        assertThrows(UnsupportedOperationException.class,
            () -> pv.isPaymentMethodValid("bitcoin"));
    }
}