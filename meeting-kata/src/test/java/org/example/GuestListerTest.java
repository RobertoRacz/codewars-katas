package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GuestListerTest {
    GuestLister guestLister = new GuestLister();

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("(ARNO, ANN)(BELL, JOHN)(CORNWELL, ALEX)(DORNY, ABBA)(KERN, LEWIS)" +
                        "(KORN, ALEX)(META, GRACE)(SCHWARZ, VICTORIA)(STAN, MADISON)(STAN, MEGAN)(WAHL, ALEXIS)",
                        "Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;" +
                                "Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void checkInvitees(String expected, String names) {
        String result = guestLister.listGuests(names);

        assertEquals(expected, result);
    }
}