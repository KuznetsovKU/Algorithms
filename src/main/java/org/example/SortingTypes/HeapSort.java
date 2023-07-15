package org.example.SortingTypes;

import org.example.Infrastructure;

public class HeapSort {
    public static void heapSort(int[] inputArray) {
        // Построение кучи (перегруппируем массив)
        for (int i = inputArray.length / 2 - 1; i >= 0; i--) {
            heapify(inputArray, inputArray.length, i);
        }

        // Один за другим извлекаем элементы из кучи
        for (int i = inputArray.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            Infrastructure.swapInArray(inputArray, 0, i);
            // Вызываем метод heapify на уменьшенной куче
            heapify(inputArray, i, 0);
        }
    }


    private static void heapify(int[] inputArray, int heapSize, int rootIndex) {
        int largestElementIndex = rootIndex;
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;

        if (leftChildIndex < heapSize && inputArray[leftChildIndex] > inputArray[largestElementIndex])
            largestElementIndex = leftChildIndex;
        if (rightChildIndex < heapSize && inputArray[rightChildIndex] > inputArray[largestElementIndex])
            largestElementIndex = rightChildIndex;

        if (largestElementIndex != rootIndex) {
            Infrastructure.swapInArray(inputArray, rootIndex, largestElementIndex);
            heapify(inputArray, heapSize, largestElementIndex);
        }
    }
}
