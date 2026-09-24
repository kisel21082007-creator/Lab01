package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseToolkitTest {

    // ---------- isEven ----------

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }

    // ---------- isPrime ----------

    @Test
    void returnsFalseForNumbersLessThanTwo() {
        assertFalse(CourseToolkit.isPrime(-5));
        assertFalse(CourseToolkit.isPrime(0));
        assertFalse(CourseToolkit.isPrime(1));
    }

    @Test
    void returnsTrueForTwo() {
        boolean result = CourseToolkit.isPrime(2);

        assertTrue(result);
    }

    @Test
    void returnsTrueForPrimeNumber() {
        boolean result = CourseToolkit.isPrime(13);

        assertTrue(result);
    }

    @Test
    void returnsFalseForCompositeNumber() {
        boolean result = CourseToolkit.isPrime(15);

        assertFalse(result);
    }

    @Test
    void returnsFalseForSquareOfPrime() {
        // 7 * 7 == 49 — ключевая граница для условия divisor * divisor <= number
        boolean result = CourseToolkit.isPrime(49);

        assertFalse(result);
    }

    // ---------- isPalindrome ----------

    @Test
    void returnsTrueForSimplePalindrome() {
        boolean result = CourseToolkit.isPalindrome("level");

        assertTrue(result);
    }

    @Test
    void returnsFalseForNonPalindrome() {
        boolean result = CourseToolkit.isPalindrome("java");

        assertFalse(result);
    }

    @Test
    void treatsCaseAndSpacesAsSignificant() {
        assertFalse(CourseToolkit.isPalindrome("Level"));
        assertFalse(CourseToolkit.isPalindrome("never odd or even"));
    }

    @Test
    void throwsForNullInIsPalindrome() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.isPalindrome(null));
    }

    // ---------- average ----------

    @Test
    void returnsAverageForTypicalArray() {
        double result = CourseToolkit.average(new int[]{1, 2, 3, 4, 5});

        assertEquals(3.0, result, 1e-9);
    }

    @Test
    void returnsFractionalAverageForNegativeValues() {
        double result = CourseToolkit.average(new int[]{-1, -2, -3});

        assertEquals(-2.0, result, 1e-9);
    }

    @Test
    void doesNotModifyInputArrayInAverage() {
        int[] values = {4, 8, 15, 16, 23, 42};
        int[] copy = values.clone();

        CourseToolkit.average(values);

        assertArrayEquals(copy, values);
    }

    @Test
    void throwsForNullOrEmptyArrayInAverage() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.average(null));
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.average(new int[]{}));
    }

    // ---------- min ----------

    @Test
    void returnsMinForTypicalArray() {
        int result = CourseToolkit.min(new int[]{4, 1, 7, -3, 9});

        assertEquals(-3, result);
    }

    @Test
    void returnsMinForSingleElementArray() {
        int result = CourseToolkit.min(new int[]{42});

        assertEquals(42, result);
    }

    @Test
    void returnsMinForNegativeArray() {
        int result = CourseToolkit.min(new int[]{-5, -100, -20});

        assertEquals(-100, result);
    }

    @Test
    void throwsForNullOrEmptyArrayInMin() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.min(null));
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.min(new int[]{}));
    }

    // ---------- max ----------

    @Test
    void returnsMaxForTypicalArray() {
        int result = CourseToolkit.max(new int[]{4, 1, 7, -3, 9});

        assertEquals(9, result);
    }

    @Test
    void returnsMaxForSingleElementArray() {
        int result = CourseToolkit.max(new int[]{-7});

        assertEquals(-7, result);
    }

    @Test
    void returnsMaxForNegativeArray() {
        int result = CourseToolkit.max(new int[]{-5, -100, -20});

        assertEquals(-5, result);
    }

    @Test
    void throwsForNullOrEmptyArrayInMax() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.max(null));
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.max(new int[]{}));
    }

    @Test
    void minAndMaxDoNotModifyInputArray() {
        int[] values = {3, -1, 5, 2};
        int[] copy = values.clone();

        CourseToolkit.min(values);
        CourseToolkit.max(values);

        assertArrayEquals(copy, values);
    }
}
