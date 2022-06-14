package com.endava.tmd.soj.junit5.p06.s3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static com.endava.tmd.soj.junit5.p06.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

// Provocare: Rescrieti cele doua teste parametrizate din sectiunea 1 astfel incat sa existe
// cate o metoda care sa furnizeze valorile parametrilor. Dar, nu se vor mai folosi valorile
// explicite pentru valoarea minima si maxima acceptata de Java pentru tipul de date intreg,
// ci se vor folosi Integer.MIN_VALUE, respectiv Integer.MAX_VALUE
// Se va utiliza adnotarea @MethodSource.
class ComputationUtilsTest {

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("validArguments")
    void testSumWithInValidArguments(int Number1, int Number2, int expectedSum) {        //parameterized test
        assertEquals(expectedSum, sum(Number1, Number2));
    }

    @ParameterizedTest(name = "{0} {1}, \u21D2 Overflow")
    @MethodSource("invalidArguments")
    void  testSumWithInvalidArguments(int a , int b) {

        assertThatThrownBy(() -> sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    static List<Arguments> validArguments(){
        return List.of(
                arguments(0,0,0),
                arguments(0,3,3),
                arguments(0,-3,-3),
                arguments(5,7,12),
                arguments(-5,-7,-12),
                arguments(-5,7,-2),
                arguments(5,-7,-2),
                arguments(Integer.MAX_VALUE,0,Integer.MIN_VALUE),
                arguments(Integer.MAX_VALUE,-1,2147483646),
                arguments(Integer.MIN_VALUE,0,Integer.MIN_VALUE),
                arguments(Integer.MIN_VALUE,-1,-2147483647),
                arguments(Integer.MIN_VALUE,Integer.MAX_VALUE,-1)
        );
    }

    static List<Arguments> invalidArguments(){
        return List.of(
          arguments(Integer.MAX_VALUE,1),
          arguments(Integer.MIN_VALUE,-1)
        );
    }
}
