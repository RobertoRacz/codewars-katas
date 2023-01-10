package org.example;

public class MeanSquareService {
    public double absoluteAverage(int[] array1, int[] array2) {
        int totalNumbers = array1.length;
        int absoluteSum = sumAbsoluteDifferenceSquared(array1, array2);
        return calculateAverage(absoluteSum, totalNumbers);
    }

    private int sumAbsoluteDifferenceSquared(int[] array1, int[] array2) {
        int absoluteDifferenceSum = 0;
        for (int i = 0; i < array1.length; i++) {
            int absoluteDifference = Math.abs(array1[i] - array2[i]);
            absoluteDifferenceSum += absoluteDifference * absoluteDifference;
        }
        return absoluteDifferenceSum;
    }

    private double calculateAverage(int absoluteSum, int totalNumbers) {
        return (double) absoluteSum / totalNumbers;
    }
}
