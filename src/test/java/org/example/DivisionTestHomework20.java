package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class DivisionTestHomework20 {

    @Test
    public void testPositiveScenario() {
        int result = Divider.divide(10, 2);
        assertEquals(5, result);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            Divider.divide(10, 0);
        });
    }

    @Test
    public void testNegativeValues() {
        int result = Divider.divide(-15, 3);
        assertEquals(-5, result);
    }

    @Test
    public void testExpectedArithmeticException() {
        assertThrows(ArithmeticException.class, () -> {
            Divider.divide(20, 0);
        });
    }

    private static class Divider {
        public static int divide(int dividend, int divisor) {
            if (divisor == 0) {
                throw new ArithmeticException("Division by zero is not allowed");
            }
            return dividend / divisor;
        }
    }
}


