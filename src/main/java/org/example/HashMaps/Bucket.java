package org.example.HashMaps;

public class Bucket<K, V> {
    HashMapNode root;

    public V get(K key) {
        HashMapNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.pair.getKey().equals(key)) {
                return currentNode.pair.getValue();
            } else {
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    public boolean add(Pair pair) {
        HashMapNode node = new HashMapNode();
        node.pair = pair;
        if (root != null) {
            HashMapNode currentNode = root;
            while (true) {
                if (currentNode.pair.equals(pair))
                    return false;
                if (currentNode.next == null) {
                    currentNode.next = node;
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        root = node;
        return true;
    }

    public boolean add(K key, V value) {
        Pair pair = new Pair(key, value);
        return this.add(pair);
    }

    public boolean delete(K key) {
        if (root == null) return false;
        if (root.pair.getKey().equals(key)) {
            root = root.next;
            return true;
        }
        HashMapNode currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.pair.getKey().equals(key)) {
                currentNode.next = currentNode.next.next;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void print() {
        HashMapNode currentNode = root;
        while (currentNode != null) {
            System.out.print("[" + currentNode.pair.getKey() + ": " + currentNode.pair.getValue() + "] ");
            currentNode = currentNode.next;
        }
    }

    class HashMapNode {
        HashMapNode next;
        Pair<K, V> pair;
    }

}
