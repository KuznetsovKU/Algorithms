package org.example;

import java.util.Random;

public class Infrastructure {
    public static int[] fillRandomArray (int size, int min, int max) {
        Random random = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(min, max);
        }
        return result;
    }

    private static void printArray(int[] inputArray) {
        for (int j : inputArray) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void printMainArr(int[] inputArray) {
        System.out.println("The main array is:");
        smartPrint(inputArray);
        System.out.println();
    }

    public static void smartPrint(int[] inputArray) {
        if (inputArray.length <= 50) printArray(inputArray);
        else System.out.println("To many values to print");
    }

    public static void swapInArray(int[] inputArray, int value1, int value2) {
        int tmp = inputArray[value1];
        inputArray[value1] = inputArray[value2];
        inputArray[value2] = tmp;
    }

    public static void printOperationCounter(int counter) {
        System.out.println("OperationCounter = " + counter);
    }

    public static StringBuilder parseTime(long inputValue) {
        StringBuilder result = new StringBuilder();
        while (inputValue > 999) {
            long currentPart = inputValue % 1000;
            inputValue /= 1000;
            StringBuilder part = new StringBuilder(Long.toString(currentPart));
            if (part.length() < 3) {
                for (int i = 0; i <= 3 - part.length(); i++) {
                    part.insert(0, "0");
                }
            }
            result.insert(0, part + " ");
        }
        result.insert(0, Long.toString(inputValue) + " ");
        return result;
    }

}
