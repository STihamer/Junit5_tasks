package com.endava.tmd.soj.junit5.p01;

// Provocari:
// 1. Adaugati adnotarea neecesara pentru a rula prima metoda ca si un test unitar
// 2. Rulati prima metoda ca si un test unitar
// 3. Decomentati asertiile din primul test, si efectuati importurile necesare. Rulati testul din nou.
// 4. Adaugati o linie care sa determine testul sa fie "failed". La sfarsit commentati acea linie
// 5. Completati celelalte metode astfel incat sa reprezinte scenarii de testare

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputationUtilsTest {
    @Test
    void zeroShouldNotChangeZero() {
        //JUnit Assertion
        assertEquals(5, sum(3, 2));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
        // assertEquals(0, sum(1,0));
    }


    @Test
    void zeroShouldNotChangePositive() {
        assertEquals(5, sum(2, 3));
    }

    @Test
    void zeroShouldNotChangeNegative() {
        assertEquals(-5, sum(-5, 0));
    }

    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertEquals(10, sum(5, 5));
    }

    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {

        assertTrue(sum(-4, -5) == -9);
    }

    @Test
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-4, 5)).isPositive();

    }

    @Test
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-8, 4)).isNegative();
    }

}
