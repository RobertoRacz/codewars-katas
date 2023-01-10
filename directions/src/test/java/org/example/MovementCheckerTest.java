package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class MovementCheckerTest {

    MovementChecker movementChecker = new MovementChecker();

    private static Stream<Arguments> arguments() {
        return Stream.of(
                of(new String[]{"WEST"}, new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST","NORTH", "WEST"}),
                of(new String[]{}, new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"})
        );
    }
    @ParameterizedTest
    @MethodSource("arguments")
    void checkEfficientMovement(String[] expected, String[]givenDirections){
        String[] result = movementChecker.moveIntelligently(givenDirections);

        assertArrayEquals(expected, result);
    }

}