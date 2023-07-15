package org.example.SortingTypes;

import org.example.Infrastructure;

public class QuickSort {
    public static void quickSort(int[] inputArray, int startPos, int endPos) {
        int left = startPos;
        int right = endPos;
        int pivot = inputArray[(startPos + endPos) / 2];
        do {
            while (inputArray[left] < pivot) left++;
            while (inputArray[right] > pivot) right--;
            if (left <= right) {
                if (left < right) {
                    Infrastructure.swapInArray(inputArray, left, right);
                }
                left++;
                right--;
            }
        } while (left <= right);
        if (left < endPos) quickSort(inputArray, left, endPos);
        if (startPos < right) quickSort(inputArray, startPos, right);
    }
}
