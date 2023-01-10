package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class MovementChecker {
    Map<String, String> incompatibleMoves = Map.of("NORTH", "SOUTH", "SOUTH", "NORTH",
            "EAST", "WEST", "WEST", "EAST");
    boolean areMovesIncompatible = true;

    public String[] moveIntelligently(String[] givenCommands){
        String[] efficientPath = new String[givenCommands.length];
        if (areMovesIncompatible) {
            efficientPath = checkForIncompatibleMoves(givenCommands);
        }
        return efficientPath;
    }

    private String[] removeIncompatibleMoves(String[] givenCommands, int incompatibleMoveIndex) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(givenCommands));
        arrayList.remove(incompatibleMoveIndex + 1);
        arrayList.remove(incompatibleMoveIndex);
        return arrayList.toArray(new String[0]);
    }

    private String[] checkForIncompatibleMoves(String[] givenCommands) {
        for (int i = 0; i < givenCommands.length; i++) {
            if (i != givenCommands.length - 1) {
                if (Objects.equals(givenCommands[i + 1], incompatibleMoves.get(givenCommands[i]))) {
                    String[] manipulatedArray = removeIncompatibleMoves(givenCommands, i);
                    return checkForIncompatibleMoves(manipulatedArray);
                }
            }
        }
        areMovesIncompatible = false;
        return givenCommands;
    }
}
