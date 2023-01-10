package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;


class MeanSquareServiceTest {
    MeanSquareService meanSquareService = new MeanSquareService();

    private static Stream<Arguments> arguments() {
        return Stream.of(
                of(9.0, new int[]{1, 2, 3}, new int[] {4, 5, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void CalculateAbsoluteAverage(double expected, int[] givenArray1, int[] givenArray2) {
        double result = meanSquareService.absoluteAverage(givenArray1, givenArray2);

        assertEquals(expected, result);
    }
}