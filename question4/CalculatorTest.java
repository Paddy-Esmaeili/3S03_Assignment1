import java.util.*;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    
    //Part a: Write the initial test case that will fail (no implemented divide() function created yet)
    @Test
    void divideTwoIntegers() {
    Calculator calc = new Calculator();
    assertEquals(2.0, calc.divide(6, 3));
    }

    @Test
    void divideByZero() {
    Calculator calc = new Calculator();
    assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }

    //Part d: Write new tests that would not be passed by the code in part b
    @Test
    void divisionTwoDoubles() {
        Calculator calc = new Calculator();
        assertEquals(4.5, calc.divide(9.0, 2.0));
    }

    @Test
    void divisionOneDouble() {
        Calculator calc = new Calculator();
        assertEquals(4.5, calc.divide(9.0, 2));
    }

    @Test
    void doubleDivisionByZero() {
        Calculator calc = new Calculator();
        assertThrows(ArithmeticException.class, () -> calc.divide(5.0, 0.0));
    }


}


