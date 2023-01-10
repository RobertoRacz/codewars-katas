package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class NumberExpanderTest {
    NumberExpander numberExpander = new NumberExpander();

    private static Stream<Arguments> arguments() {
        return Stream.of(
                of("10 + 2", 12),
                of("70 + 9", 79),
                of("70000 + 300 + 4", 70304),
                of("100 + 10 + 1", 111)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void checkExpandedNumber(String expected, int givenNumber) {
        String result = numberExpander.expandNumber(givenNumber);

        Assertions.assertEquals(expected, result);
    }

}