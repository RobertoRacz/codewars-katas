package org.example.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SumServiceTest {

    SumService sumService = new SumService();

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{0, 2}, new int[]{1, 2, 3}, 4),
                Arguments.of(new int[]{0, 1}, new int[]{2, 2, 3}, 4),
                Arguments.of(new int[]{1, 2}, new int[]{2, 3, 3}, 6),
                Arguments.of(new int[]{1, 2}, new int[]{1234,5678,9012}, 14690)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void checkSumTwo(int[] expected, int[] numbers, int target) {
        int [] result = sumService.sumTwo(numbers, target);

        assertArrayEquals(expected, result);
    }
}