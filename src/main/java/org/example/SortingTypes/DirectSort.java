package org.example.SortingTypes;

import org.example.Infrastructure;

public class DirectSort {
    public static void directSort(int[] inputArray) {
        for (int i = 0; i < inputArray.length - 1; i++) {
            int minElementPos = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[j] < inputArray[minElementPos]) {
                    minElementPos = j;
                }
            }
            if (i != minElementPos) {
                Infrastructure.swapInArray(inputArray, i, minElementPos);
            }
        }
    }
}
