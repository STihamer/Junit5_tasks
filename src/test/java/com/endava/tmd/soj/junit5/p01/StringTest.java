package com.endava.tmd.soj.junit5.p01;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("00000")
public class StringTest {

    @Test
    void length_greater_than_zero() {        //parameterized test
        assertTrue("ABCD".length() > 0);
        assertTrue("A".length() > 0);
        assertTrue("DF".length() > 0);
        assertTrue("ABCD".length() > 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABCD", "ABC", "A", "DEF"})
    void length_greater_than_zero_using_parameterized_test(String str) {        //parameterized test
        assertTrue(str.length() > 0);

    }

    @ParameterizedTest(name = "{0} to upperCase is {2}")
    @CsvSource(value = {"abcd, ABCD", "abc, ABC", "abcdefg, ABCDEFG"})
    void uppercase(String word, String capitalizedWord) {        //parameterized test
        assertEquals(capitalizedWord, word.toUpperCase());

    }

    @ParameterizedTest(name = "{0} length is {1}")
    @CsvSource(value = {"abcd, 4", "abc, 3", "abcdefg, 7"})
    void length(String word, int expectedLength) {        //parameterized test
        assertEquals(expectedLength, word.length());
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Initialize connection to database");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Close connection database");
    }

    @BeforeEach
    void beforeEach(TestInfo info) {
        System.out.println("Initialize test data for " + info.getDisplayName());
    }

    @AfterEach
    void afterEach(TestInfo info) {
        System.out.println("Clean up test data for  " + info.getDisplayName());
    }

    @Test
    @Disabled("Do not run") //@Ignored
    @DisplayName("When length is null, throw an exception")
    void length_basic() {

        int actualLength = "ABCD".length();
        int expectedLength = 4;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    void length_exception() {
        String str = null;
        int actualLength = str.length();
        assertThrows(NullPointerException.class, () -> {
            str.length();
        });
    }

    @Test
    void toUpperCase() {
        String str = "abcd";
        String result = str.toUpperCase();
        assertEquals("ABCD", result);
        assertNotNull(result);
        //assertNull(result);
    }

    @Test
    @RepeatedTest(10)
    void contains_basic() {
        assertEquals(false, "abcdefgh".contains("ijk"));
        assertFalse("abcdefgh".contains("ijk"));
    }

    @Test
    void split_basic() {
        String str = "abcd efgr mmmm";
        String[] actualResult = str.split(" ");
        String[] expectedResult = new String[]{"abcd", "efgr", "mmmm"};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void performanceTest() {
        assertTimeout(Duration.ofSeconds(5), () ->
        {
            for (int i = 0; i <= 1000000; i++) {
                int j = i;
                System.out.println(j);
            }
        });
    }

    @Nested
    @DisplayName("For an empty string")
    class EmptyStringTest {
        String string;

        @BeforeEach
        void setToEmpty() {
            string = "";
        }

        @Test
        @DisplayName("length should be zero")
        void lengthIsZero() {
            assertEquals(0, string.length());
        }

        @Test
        @DisplayName("Upper case should be 0")
        void uppercaseIsEmpty() {
            assertEquals("", string.toUpperCase());
        }
    }

}