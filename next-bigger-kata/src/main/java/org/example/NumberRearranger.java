package org.example;

import java.util.Arrays;

public class NumberRearranger {
    public long nextBiggerNumber(long givenNumber) {
        if (isBiggestCombination(givenNumber)){
            return -1;
        }
        long smallestDigit = findSmallestDigit(givenNumber);
        long digitToSwap = findNextBiggerDigit(smallestDigit);
        long swappedNumber = swapTwoDigits(smallestDigit, digitToSwap);
        long nextBiggerNumber = sortBetween(swappedNumber);
        return nextBiggerNumber;
    }

    private long findSmallestDigit(long givenNumber) {
        String stringNumber = Long.toString(givenNumber);
        int numberLength = stringNumber.length();
        long[] numberArray = new long[numberLength];
        for (int i = 0; i < stringNumber.length(); i++) {
            numberArray[i] = stringNumber.charAt(i);
        }
        Arrays.sort(numberArray);
        return numberArray[numberLength - 1];
    }

    private boolean isBiggestCombination(long givenNumber) {
        String stringNumber = Long.toString(givenNumber);
        for (int i = 0; i < stringNumber.length(); i++) {
            if (i < stringNumber.length() - 1) {
                if (stringNumber.charAt(i) < stringNumber.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
