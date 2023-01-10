package org.example;

import java.util.LinkedList;

public class WaveService {
    public String [] createWave(String word) {
        LinkedList<String> wordArray = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            String wave = uppercase(i, word);
            if (i == word.length() - 1) {
                wave = uppercase(i, word);
            }
            wordArray.add(wave);
        }
        return wordArray.toArray(new String[0]);
    }

    private String uppercase(int index, String word) {
        String upperCaseString = word.substring(index, index + 1).toUpperCase();
        if (index > 0) {
            return word.substring(0, index).toLowerCase() +
                    upperCaseString + word.substring(index + 1);
        }
        word = upperCaseString + word.substring(index + 1);
        return word;
    }
}
