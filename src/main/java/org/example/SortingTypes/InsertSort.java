package org.example.SortingTypes;

import org.example.Infrastructure;

public class InsertSort {
    public static void insertSort(int[] inputArray) {
        for (int i = 0; i < inputArray.length - 1; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] > inputArray[j]) {
                    Infrastructure.swapInArray(inputArray, i, j);
                }
            }
        }
    }
}
