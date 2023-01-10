package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;


class ArraySorterTest {
    ArraySorter arraySorter = new ArraySorter();

    private static Stream<Arguments> arguments() {
        return Stream.of(
                of(new int[]{ 1, 3, 2, 8, 5, 4 }, new int[]{ 5, 3, 2, 8, 1, 4}),
                of(new int[]{1, 3, 5, 8, 0 }, new int[]{5, 3, 1, 8, 0}),
                of(new int[]{}, new int[]{}),
                of(new  int[]{1, 8, 3, 6, 5, 4, 7, 2, 9, 0}, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void checkOddSort(int[] expected, int[] givenArray) {
        int[] result = arraySorter.sortOdd(givenArray);

        Assertions.assertArrayEquals(expected, result);
    }
}