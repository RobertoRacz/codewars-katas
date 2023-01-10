package org.example;

public class NumberExpander {

    String expandNumber(int givenNumber) {
        String stringNumber = String.valueOf(givenNumber);
        return expandCharacters(stringNumber);
    }

    private String expandCharacters(String givenStringNumber) {
        StringBuilder expandedNumber = new StringBuilder();
        int length = givenStringNumber.length();
        for (int i = 0; i < length; i++) {
            String currentNumber = givenStringNumber.substring(i, i + 1);
            int parseInt = Integer.parseInt(currentNumber);
            if (parseInt > 0) {
                expandedNumber.append(givenStringNumber.charAt(i));
                for (int j = 0; j < length - 1 - i; j++) {
                    expandedNumber.append("0");
                if (!(i == length - 1) && j == length - 2 - i) {
                    expandedNumber.append(" + ");
                    }
                }
            }
        }
        return expandedNumber.toString();
    }
}
