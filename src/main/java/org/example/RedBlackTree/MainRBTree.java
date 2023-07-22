package org.example.RedBlackTree;

import java.util.Random;

public class MainRBTree {
    public static void main(String[] args) {
        Random random = new Random();
        MyRBTree<Integer> myRBTree = new MyRBTree<>();

        for (int i = 0; i < 10; i++) {
            int element = random.nextInt(99);
            System.out.print(element + " ");
            myRBTree.add(element);
        }
        System.out.println();

//        myRBTree.add(11);
//        myRBTree.add(47);
//        myRBTree.add(0);
//        myRBTree.add(82);
//        myRBTree.add(53);
//        myRBTree.add(28);
//        myRBTree.add(14);
//        myRBTree.add(69);
//        myRBTree.add(29);
//        myRBTree.add(75);

        myRBTree.printTree();
    }
}
