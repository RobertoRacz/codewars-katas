package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class WaveServiceTest {
    WaveService waveService = new WaveService();
    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new String[]{"Hello", "hEllo", "heLlo", "helLo", "hellO"}, "hello")
        );
}

    @ParameterizedTest
    @MethodSource("arguments")
    void checkWave(String[] expected, String text) {
        String [] result = waveService.createWave(text);

        assertArrayEquals(expected, result);
    }
}