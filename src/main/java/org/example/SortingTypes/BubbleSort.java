package org.example.SortingTypes;

import org.example.Infrastructure;

public class BubbleSort {
    public static void bubbleSort(int[] inputArray) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < inputArray.length - 1; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    finish = false;
                    Infrastructure.swapInArray(inputArray, i, i + 1);
                }
            }
        } while (!finish);
    }

}
