package org.example.HashMaps;

public class MyHashMap<K, V> {
    private static final int DEFAULT_SIZE = 16;
    private static final double MAX_LOADING = 0.75;
    private int currentSize = 0;
    private final int extensionIndex = 2;

    private Bucket<K, V>[] buckets;

    public MyHashMap() {
        this(DEFAULT_SIZE);
    }

    public MyHashMap(int size) {
        buckets = new Bucket[size];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public V get(K key) {
        int index = getIndex(key);
        Bucket<K, V> bucket = buckets[index];
        return bucket.get(key);
    }

    public boolean add(K key, V value) {
        if (buckets.length * MAX_LOADING < currentSize)
            recalculate();
        int index = getIndex(key);
        Bucket<K, V> bucket = buckets[index];
        if (bucket == null) {
            bucket = new Bucket<>();
            buckets[index] = bucket;
        }
        boolean added = bucket.add(key, value);
        if (added) currentSize++;
        return added;
    }

    public boolean remove(K key) {
        int index = getIndex(key);
        Bucket<K, V> bucket = buckets[index];
        if (bucket == null) return false;
        boolean removed = bucket.delete(key);
        if (removed) currentSize--;
        return removed;
    }

    private void recalculate() {
        Bucket<K, V>[] oldBucket = buckets;
        buckets = new Bucket[oldBucket.length * extensionIndex];
        for (int i = 0; i < oldBucket.length; i++) {
            Bucket<K, V> bucket = oldBucket[i];
            if (bucket != null) {
                Bucket.HashMapNode currentNode = bucket.root;
                while (currentNode != null) {
                    this.add((K) currentNode.pair.getKey(), (V) currentNode.pair.getValue());
                    currentNode = currentNode.next;
                }
            }
            oldBucket[i] = null;
        }
        oldBucket = null;
    }

    public void print() {
        for (Bucket<K, V> bucket: buckets) {
            if (bucket != null) {
                bucket.print();
                System.out.println();
            }
            System.out.println("- ");
        }
    }
}
