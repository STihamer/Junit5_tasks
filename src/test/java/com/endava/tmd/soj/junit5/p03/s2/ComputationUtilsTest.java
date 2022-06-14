package com.endava.tmd.soj.junit5.p03.s2;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Provocare: Copiati metodele de test din tema anterioara (p02), si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in functie de adnotarea de ordine specificata pe fiecare metoda de test. Adnotarea de ordine
// trebuie sa fie pusa pe fiecare metoda de test astfel incat metodele sa fie executate in ordinea in care sunt scrise
@DisplayName("Tests for my sum method")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-8, 4)).isNegative();
    }

}
