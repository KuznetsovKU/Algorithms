package org.example.HashMaps;

import java.util.Random;

public class MainHashMaps {
    public static void main(String[] args) {
        Random random = new Random();

        Pair<String, Integer>[] pairsArray = new Pair[10];

        Pair<String, Integer> pair1 = new Pair<>("B", 5);
        Pair<String, Integer> pair2 = new Pair<>("F", 0);
        Pair<String, Integer> pair3 = new Pair<>("D", 9);
        Pair<String, Integer> pair4 = new Pair<>("J", 4);

        pairsArray[pair1.getKeyHashCode(pairsArray.length)] = pair1;
        pairsArray[pair2.getKeyHashCode(pairsArray.length)] = pair2;
        pairsArray[pair3.getKeyHashCode(pairsArray.length)] = pair3;
        pairsArray[pair4.getKeyHashCode(pairsArray.length)] = pair4;

        for (int i = 0; i < pairsArray.length; i++) {
            if (pairsArray[i] != null) {
                System.out.print("[" + pairsArray[i].getKey() + ": " + pairsArray[i].getValue() + "] ");
            } else {
                System.out.print("- ");
            }
        }

        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 100; i++) {
            myHashMap.add(random.nextInt(200), random.nextInt(50));
        }

        myHashMap.print();

    }
}
