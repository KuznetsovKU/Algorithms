package org.example.LinkedLists;

import java.util.Random;

public class MainLinkList {
    public static void main(String[] args) {
        Random random = new Random();
        LinkList linkList1 = new LinkList();
        LinkList linkList2 = new LinkList();

//        for (int i = 0; i < 1000; i++) {
//            int el = random.nextInt(1000);
//            linkList1.add(el);
//            linkList2.add(el);
//        }
//
//        long start;
//        long finish;
//
//        start = System.nanoTime();
//        linkList1.quickSort();
//        finish = System.nanoTime();
//        System.out.println(finish - start);
//
//        start = System.nanoTime();
//        linkList2.quickSortNoPrev();
//        finish = System.nanoTime();
//        System.out.println(finish - start);

        LinkListGeneric<String> linkList3 = new LinkListGeneric<>();
        linkList3.add("John");
        linkList3.add("Mike");
        linkList3.add("Adam");
        linkList3.add("Nick");
        linkList3.add("Sam");

//        linkList3.printList();
//
//        linkList3.quickSort();
//        linkList3.printList();
//        linkList3.printListReverse();

//        linkList3.printList();
//        linkList3.turnLinkList();
//        linkList3.printList();

        linkList3.printList();
        linkList3.turnDoublyLinkList();
        linkList3.printList();
    }
}
