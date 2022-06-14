package com.endava.tmd.soj.junit5.p05.s3;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p05.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

// Scopul acestei sectiuni este sa urmarim rescrierile de cod din partea de productie
// Deci pastram testele din sectiunea precedenta
class ComputationUtilsTest {
    @Test
    @Order(1)
    @DisplayName("0+0 =0")
    void zeroShouldNotChangeZero() {
        //JUnit Assertion
        assertEquals(5, sum(3, 2));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
        // assertEquals(0, sum(1,0));
    }


    @Test
    @Order(2)
    @DisplayName("2+3 = 5")
    void zeroShouldNotChangePositive() {
        assertEquals(5, sum(2, 3));
    }

    @Test
    @Order(3)
    @DisplayName("-5+0 = -5")
    void zeroShouldNotChangeNegative() {
        assertEquals(-5, sum(-5, 0));
    }

    @Test
    @Order(4)
    @DisplayName("5 + 5 = 10")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertEquals(10, sum(5, 5));
    }

    @Test
    @Order(5)
    @DisplayName("-4 + -5 = -9")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {

        assertTrue(sum(-4, -5) == -9);
    }

    @Test
    @Order(6)
    @DisplayName("-4 + 5 > 0")
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-4, 5)).isPositive();

    }

    @Test
    @Order(7)
    @DisplayName("-8 + 4  < 0")
    void oneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-8, 4)).isNegative();
    }

    @Test
    void zeroShouldNotChangeMaxInt() {

        Integer max = Integer.MAX_VALUE;
        assertEquals(max, sum(0, max));
    }

    @Test
    void maxIntAndANegativeNumber() {
        Integer max = Integer.MAX_VALUE;
        assertEquals(max - 5, sum(-5, max));
    }

    @Test
    void zeroShouldNotChangeMinInt() {
        Integer min = Integer.MIN_VALUE;
        assertEquals(min, sum(0, min));
    }

    @Test
    void minIntAndAPositiveNumber() {
        Integer min = Integer.MIN_VALUE;
        assertEquals(min + 5, sum(5, min));
    }

    @Test
    void minIntAndMaxInt() {
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;

        assertEquals(-1,sum(min, max));
    }

    @Test
    @Disabled("TODO: Still need to work on it")
    void whatToDoWhenSumExceedsMaxIntegerValue() {

        assertEquals(Integer.MAX_VALUE, sum(Integer.MAX_VALUE, Integer.MAX_VALUE));

    }

    @Test
    @DisplayName("2147483647 + 1 \u21D2 Overflow")
    void exceptionWhenSumIsGreaterThanIntegerMaxValue() {
        // JUnit way of checking the exception class
        assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));

        // JUnit way of checking the exception class and its characteristics
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
        assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> sum(2147483647, 1)).isInstanceOf(ArithmeticException.class).hasMessage("Overflow while computing the sum");
    }

    @Test
    @DisplayName("-2147483648 + (-1) \u21D2 Overflow")
    void exceptionWhenSumIsLowerThanIntegerMinValue() {

        assertThrows(ArithmeticException.class, () -> sum(Integer.MIN_VALUE, -1));

        // JUnit way of checking the exception class and its characteristics
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(Integer.MIN_VALUE, -1));
        assertEquals("Overflow while computing the sum", exception.getMessage());


        // AssertJ
        assertThatThrownBy(() -> sum(Integer.MIN_VALUE, -1)).isInstanceOf(ArithmeticException.class).hasMessage("Overflow while computing the sum");
    }


}
