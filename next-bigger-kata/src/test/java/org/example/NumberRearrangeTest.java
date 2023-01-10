package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;

class NumberRearrangerTest {

    NumberRearranger numberRearranger = new NumberRearranger();

    private static Stream<Arguments> arguments() {
        return Stream.of(
                of(21, 12),
                of(531, 513),
                of(441, 414),
                of(41467925, 144),
                of(-1, 111),
                of(-1, 9),
                of(19009, 10990)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void checkNextBiggerNumber(long expected, long givenNumber) {
        long result = numberRearranger.nextBiggerNumber(givenNumber);

        Assertions.assertEquals(expected, result);
    }
}