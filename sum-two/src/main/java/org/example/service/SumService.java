package org.example.service;

import java.util.HashMap;

public class SumService {
    public int[] sumTwo(int[] numbers, int target) {
        HashMap<Integer, Integer> lordAndSaviour = new HashMap<>();

        for (int index = 0; index < numbers.length; index++) {
            if (lordAndSaviour.containsKey(target - numbers[index])) {
                return new int[]{lordAndSaviour.get(target - numbers[index]), index};
            }
            else {
                lordAndSaviour.put(numbers[index], index);
            }
        }
        return null;
    }
}
