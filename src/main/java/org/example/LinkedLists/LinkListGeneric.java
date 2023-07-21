package org.example.LinkedLists;

public class LinkListGeneric<T extends Comparable> {

    private Node root;  // head
    private int size;

    public int getSize() {
        return size;
    }

    public void add(T value) {
        if (root == null) {
            root = new Node(value);
            size = 1;
            return;
        }
        Node currentNode = root;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        Node newNode = new Node(value);
        currentNode.next = newNode;
        newNode.prev = currentNode;
        size++;
    }

    public boolean remove(T value) {
        if (root == null) return false;
        if (root.value.compareTo(value) == 0) {
            root = root.next;
            root.prev = null;
            size--;
            return true;
        }
        Node currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.value == value) {
                currentNode.next = currentNode.next.next;
                if (currentNode.next != null) currentNode.next.prev = currentNode;
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void removeAt(int index) {
        if (index == 0) {
            root = root.next;
            root.prev = null;
            size--;
            return;
        }
        Node deletedNode = getNode(index - 1);
        deletedNode.next = deletedNode.next.next;
        if (deletedNode.next != null) deletedNode.next.prev = deletedNode;
    }

    public void removeAll(T value) {
        if (root == null) return;
        Node currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.value.compareTo(value) == 0) {
                currentNode.next = currentNode.next.next;
                if (currentNode.next != null) currentNode.next.prev = currentNode;
                size--;
            } else currentNode = currentNode.next;
        }
        if (root.value.compareTo(value) == 0) {
            root = root.next;
            root.prev = null;
            size--;
        }
    }

    public void quickSort() {
        quickSort(0, size - 1);
    }

    public void quickSortNoPrev() {
        quickSortNoPrev(0, size - 1);
    }

    public void quickSort(int leftBorder, int rightBorder) {
        int start = leftBorder;
        int end = rightBorder;
        T pivot = this.getValue((start + end) / 2);

        Node leftNode = getNode(start);
        Node rightNode = getNode(end);

        while (start <= end) {
            while (leftNode.value.compareTo(pivot) < 0) {
                leftNode = leftNode.next;
                start++;
            }
            while (rightNode.value.compareTo(pivot) > 0) {
                rightNode = rightNode.prev;
                end--;
            }
            if (start <= end) {
                if (start < end) swap(start, end);
                rightNode = rightNode.prev;
                leftNode = leftNode.next;
                start++;
                end--;
            }
        }
        if (leftBorder < end) quickSort(leftBorder, end);
        if (start < rightBorder) quickSort(start, rightBorder   );
    }

    public void quickSortNoPrev(int leftBorder, int rightBorder) {
        int start = leftBorder;
        int end = rightBorder;
        T pivot = this.getValue((start + end) / 2);

        while (start <= end) {
            while (this.getValue(start).compareTo(pivot) < 0)
                start++;
            while (this.getValue(end).compareTo(pivot) > 0)
                end--;
            if (start <= end) {
                if (start < end) swap(start, end);
                start++;
                end--;
            }
        }
        if (leftBorder < end) quickSort(leftBorder, end);
        if (start < rightBorder) quickSort(start, rightBorder   );
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node currentNode = root;
        while (index != 0) {
            currentNode = currentNode.next;
            index--;
        }
        return currentNode;
    }

    public T getValue(int index) {
        return getNode(index).value;
    }

    public void setValue(int index, T value) {
        Node node = getNode(index);
        node.value = value;
    }

    public void swap(int index1, int index2) {
        if (index1 < 0 || index2 < 0 || index1 >= size || index2 >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node1 = null;
        Node node2 = null;
        Node currentNode = root;

        if (index1 == index2) return;
        for (int i = 0; currentNode != null; i++) {
            if (index1 == i) node1 = currentNode;
            if (index2 == i) node2 = currentNode;
            if (node1 != null && node2 != null) break;
            currentNode = currentNode.next;
        }
        T temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }

    public void printList() {
        Node currentNode = root;
        System.out.print("[ ");
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println("] size: " + size);
    }

    public void printListReverse() {
        Node currentNode = getNode(size - 1);
        System.out.print("[ ");
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.prev;
        }
        System.out.println("] size: " + size);
    }

    private class Node {
        T value;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
