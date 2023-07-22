package org.example.RedBlackTree;

import java.util.ArrayList;

public class MyRBTree<T extends Comparable<T>> {
    private NodeRBT<T> root;
    private int largestValueSize = 2;
    private int size = 0;

    public boolean add(T value) {
        int valueSize = value.toString().length();
        if (root == null) {
            root = new NodeRBT<>(value);
            root.setColor(Color.black);
            if (largestValueSize > valueSize) largestValueSize = valueSize;
            size++;
            return true;
        }
        boolean added = addNode(root, value);
        if (added) {
            if (largestValueSize > valueSize) largestValueSize = valueSize;
            size++;
        }
        return added;
    }

    private boolean addNode(NodeRBT<T> node, T value) {
        if (node.getValue().equals(value)) return false;
        if (node.getValue().compareTo(value) > 0) {
            if (node.getLeft() != null) {
                boolean result = addNode(node.getLeft(), value);
                node.setLeft(rebalanced(node.getLeft()));
                return result;
            } else {
                node.setLeft(new NodeRBT<>(value));
                return true;
            }
        } else {
            if (node.getRight() != null) {
                boolean result = addNode(node.getRight(), value);
                node.setRight(rebalanced(node.getRight()));
                return result;
            } else {
                node.setRight(new NodeRBT<>(value));
                return true;
            }
        }
    }

    public boolean contain(T value) {
        NodeRBT<T>  currentNode = root;
        while (currentNode != null) {
            if (currentNode.getValue().equals(value)) return true;
            else if (currentNode.getValue().compareTo(value) > 0) currentNode = currentNode.getRight();
            else currentNode = currentNode.getLeft();
        }
        return false;
    }

    private NodeRBT<T> rebalanced(NodeRBT<T> node) {
        NodeRBT<T> result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.getRight() != null && result.getRight().getColor() == Color.red &&
                    (result.getLeft() == null || result.getLeft().getColor() == Color.black)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.getLeft() != null && result.getLeft().getColor() == Color.red &&
                    (result.getLeft().getLeft() != null && result.getLeft().getLeft().getColor() == Color.red)) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.getLeft() != null && result.getLeft().getColor() == Color.red &&
                    result.getRight() != null && result.getRight().getColor() == Color.red) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }

    private NodeRBT<T> rightSwap(NodeRBT<T> node) {
        NodeRBT<T> right = node.getRight();
        NodeRBT<T> between = right.getLeft();
        right.setLeft(node);
        node.setRight(between);
        right.setColor(node.getColor());
        node.setColor(Color.red);
        return right;
    }

    private NodeRBT<T> leftSwap(NodeRBT<T> node) {
        NodeRBT<T> left = node.getLeft();
        NodeRBT<T> between = left.getRight();
        left.setRight(node);
        node.setLeft(between);
        left.setColor(node.getColor());
        node.setColor(Color.red);
        return left;
    }

    private void colorSwap(NodeRBT<T> node) {
        node.getRight().setColor(Color.black);
        node.getLeft().setColor(Color.black);
        node.setColor(Color.red);
    }

    private int getApproximateDepth() {
        int result = 0;
        if (root != null) {
            NodeRBT<T> currentNode = root;
            while (currentNode != null) {
                result++;
                currentNode = currentNode.getRight();
            }
        }
        return result + 1;
    }

    public void printTree() {
        int depth = size;
        int symbolCounter = largestValueSize * depth + 1;
        String spaces = block(symbolCounter + 2, "   ");
        String underLines = block(symbolCounter, "__");
        String start = block(depth, "  ");
        ArrayList<NodeRBT<T>> line = new ArrayList<>();
        line.add(root);
        for (int i = 1; i <= depth / 2; i++) {
            System.out.println(start);
            ArrayList<NodeRBT<T>> nextLine = new ArrayList<>();
            for (NodeRBT<T> node: line) {
                if (node == null) {
                    System.out.print(spaces + " " + underLines + "--" + underLines + "" + spaces);

                    nextLine.add(null);
                    nextLine.add(null);

                } else {
                    System.out.print(spaces + " " + underLines + "" + node.getValue() + "" + underLines + "" + spaces);
                    nextLine.add(node.getLeft());
                    nextLine.add(node.getRight());
                }
            }
            System.out.println();
            line = nextLine;
            spaces = spaces.substring(spaces.length() / 2 + 1);
            underLines = underLines.substring(underLines.length() / 2);
            start = start.substring(2);
        }
    }

    private String block(int amount, String symbol) {
        String result = "";
        for (int i = 0; i < amount; i++) {
            result = result + symbol;
        }
        return result;
    }
}
