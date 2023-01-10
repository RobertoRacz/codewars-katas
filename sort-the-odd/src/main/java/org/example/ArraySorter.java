package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraySorter {
    public int[] sortOdd(int[] arrayToSort) {
        List<Integer> arrayList = new ArrayList<>();
        getOddNumbers(arrayToSort, arrayList);
        addEvenNumbersBack(arrayToSort, arrayList);
        return arrayList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void getOddNumbers(int[] arrayToSort, List<Integer> arrayList) {
        Arrays.stream(arrayToSort)
                .filter(number -> number % 2 == 1)
                .sorted()
                .forEach(arrayList::add);
    }

    private void addEvenNumbersBack(int[] arrayToSort, List<Integer> arrayList) {
        for (int index = 0; index < arrayToSort.length; index++) {
            if (arrayToSort[index] % 2 == 0) {
                arrayList.add(index, arrayToSort[index]);
            }
        }
    }
}