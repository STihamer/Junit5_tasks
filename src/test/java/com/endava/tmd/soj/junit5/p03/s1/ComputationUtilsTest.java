package com.endava.tmd.soj.junit5.p03.s1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in ordine alfabetica. Modificati numele metodelor de test astfel incat metodele
// sa fie executate in ordinea in care sunt scrise
@DisplayName("Tests for my sum method")
@TestMethodOrder(MethodOrderer.DisplayName.class)
class ComputationUtilsTest {

    @Test
    @DisplayName("A0 +0 = 0")
    void zeroShouldNotChangeZero() {
        //JUnit Assertion
        assertEquals(5, sum(3, 2));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
        // assertEquals(0, sum(1,0));
    }


    @Test
    @DisplayName("B2+3 = 5")
    void zeroShouldNotChangePositive() {
        assertEquals(5, sum(2, 3));
    }

    @Test
    @DisplayName("C-5+0 = -5")
    void zeroShouldNotChangeNegative() {
        assertEquals(-5, sum(-5, 0));
    }

    @Test
    @DisplayName("D5 + 5 = 10")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertEquals(10, sum(5, 5));
    }

    @Test
    @DisplayName("E-4 + -5 = -9")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {

        assertTrue(sum(-4, -5) == -9);
    }

    @Test
    @DisplayName("F-4 + 5 > 0")
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-4, 5)).isPositive();

    }

    @Test
    @DisplayName("G-8 + 4  < 0")
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-8, 4)).isNegative();
    }

}
