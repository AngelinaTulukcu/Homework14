package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ArrayAccessTestHomework20 {

    @Test
    public void testPositiveScenario() {
        int[] array = {1, 2, 3, 4, 5};
        int index = 2;
        int expectedValue = 3;

        int result = accessArrayElement(array, index);
        assertEquals(expectedValue, result);
    }

    @Test
    public void testNegativeScenario() {
        int[] array = {1, 2, 3, 4, 5};
        int index = 7;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            accessArrayElement(array, index);
        });
    }

    private int accessArrayElement(int[] array, int index) {
        return array[index];
    }
}

