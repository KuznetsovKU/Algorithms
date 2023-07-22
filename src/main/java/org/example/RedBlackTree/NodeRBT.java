package org.example.RedBlackTree;

public class NodeRBT<T extends Comparable<T>> {
    private T value;
    private Color color;
    private NodeRBT<T> left;
    private NodeRBT<T> right;

    public NodeRBT() {
        this.color = Color.red;
    }

    public NodeRBT(T value) {
        this.value = value;
        this.color = Color.red;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public NodeRBT<T> getLeft() {
        return left;
    }

    public void setLeft(NodeRBT<T> left) {
        this.left = left;
    }

    public NodeRBT<T> getRight() {
        return right;
    }

    public void setRight(NodeRBT<T> right) {
        this.right = right;
    }

}

enum Color {red, black}
