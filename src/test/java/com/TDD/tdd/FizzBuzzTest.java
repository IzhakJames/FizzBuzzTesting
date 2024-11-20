package com.TDD.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    // If number is divisible by 3, print Fizz
    @DisplayName("Divisible by Three")
    @Test
    @Order(1)
    @Tag("Fizz")               // Tagging with Fizz
    @Tag("DivisibleByThree")   // Tagging with DivisibleByThree
    void testForDivisibleByThree() {
        String expected = "Fizz";
        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    // If number is divisible by 5, print Buzz
    @DisplayName("Divisible by Five")
    @Test
    @Order(2)
    @Tag("Buzz")               // Tagging with Buzz
    @Tag("DivisibleByFive")    // Tagging with DivisibleByFive
    void testForDivisibleByFive() {
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }

    // If number is divisible by 3 and 5, print FizzBuzz
    @DisplayName("Divisible by Three and Five")
    @Test
    @Order(3)
    @Tag("FizzBuzz")           // Tagging with FizzBuzz
    @Tag("DivisibleByThreeAndFive") // Tagging with DivisibleByThreeAndFive
    void testForDivisibleByThreeAndFive() {
        String expected = "FizzBuzz";
        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }

    // If number is NOT divisible by 3 or 5, then print the number
    @DisplayName("Not Divisible by Three or Five")
    @Test
    @Order(4)
    @Tag("NotDivisibleByThreeOrFive") // Tagging with NotDivisibleByThreeOrFive
    void testForNotDivisibleByThreeOrFive() {
        String expected = "1";
        assertEquals(expected, FizzBuzz.compute(1), "Should return 1");
    }

    @DisplayName("Testing with Small data file")
    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources="/small-test-data.csv")
    @Order(5)
    @Tag("SmallDataFile") // Tagging with SmallDataFile
    void testSmallDataFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }

    @DisplayName("Testing with Medium data file")
    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources="/medium-test-data.csv")
    @Order(6)
    @Tag("MediumDataFile") // Tagging with MediumDataFile
    void testMediumDataFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }

//    @DisplayName("Testing with Large data file")
//    @ParameterizedTest(name="value={0}, expected={1}")
//    @CsvFileSource(resources="/large-test-data.csv")
//    @Order(7)
//    @Tag("LargeDataFile") // Tagging with LargeDataFile
//    void testLargeDataFile(int value, String expected) {
//        assertEquals(expected, FizzBuzz.compute(value));
//    }
}
