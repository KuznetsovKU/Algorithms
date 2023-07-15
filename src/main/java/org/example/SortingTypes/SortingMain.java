package org.example.SortingTypes;

import org.example.Infrastructure;

public class SortingMain {
    public static void main(String[] args) {
        int[] arr1 = Infrastructure.fillRandomArray(200_000, -100, 10_000_000);
//        int[] arr1 = new int[] {2, 6, 3, 7, 9, 1, 4, 0, 8, 5};
        Infrastructure.printMainArr(arr1);
        long startTime;
        long finishTime;

        int[] bubbleArr = arr1.clone();
        int[] directArr = arr1.clone();
        int[] insertArr = arr1.clone();
        int[] quickArr = arr1.clone();
        int[] heapArr = arr1.clone();

        System.out.println("Bubble Sort:");
        startTime = System.nanoTime();
        BubbleSort.bubbleSort(bubbleArr);
        finishTime = System.nanoTime();
        Infrastructure.smartPrint(bubbleArr);
        System.out.println("BubbleSorting was completed in " + Infrastructure.parseTime(finishTime - startTime) + "nanoSec" + "\n");

        System.out.println("Direct Sort:");
        startTime = System.nanoTime();
        DirectSort.directSort(directArr);
        finishTime = System.nanoTime();
        Infrastructure.smartPrint(directArr);
        System.out.println("DirectSorting was completed in " + Infrastructure.parseTime(finishTime - startTime) + "nanoSec" + "\n");

        System.out.println("Insert Sort:");
        startTime = System.nanoTime();
        InsertSort.insertSort(insertArr);
        finishTime = System.nanoTime();
        Infrastructure.smartPrint(insertArr);
        System.out.println("InsertSorting was completed in " + Infrastructure.parseTime(finishTime - startTime) + "nanoSec" + "\n");

        System.out.println("Quick Sort:");
        startTime = System.nanoTime();
        QuickSort.quickSort(quickArr, 0, quickArr.length - 1);
        finishTime = System.nanoTime();
        Infrastructure.smartPrint(quickArr);
        System.out.println("QuickSorting was completed in " + Infrastructure.parseTime(finishTime - startTime) + "nanoSec" + "\n");

        System.out.println("Heap Sort:");
        startTime = System.nanoTime();
        HeapSort.heapSort(heapArr);
        finishTime = System.nanoTime();
        Infrastructure.smartPrint(heapArr);
        System.out.println("HeapSorting was completed in " + Infrastructure.parseTime(finishTime - startTime) + "nanoSec" + "\n");
    }
}
