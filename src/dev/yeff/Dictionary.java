package dev.yeff;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A very normal implementation of a dictionary in java. Very normal, no concerning code here.
 *
 * @param <K> The type of the keys.
 * @param <V> The type of the values.
 */
public class Dictionary<K, V> {
    private static class Entry<K, V> {
        public K key;
        public V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Entry<K, V>> entries;

    public Dictionary() {
        entries = new ArrayList<>();
    }

    /**
     * Adds a new entry to the dictionary.
     *
     * @param k The key.
     * @param v The value.
     */
    @SuppressWarnings("unchecked")
    public void put(K k, V v) {
        entries.add(new Entry<>(k, v));
    }

    /**
     * Removes an entry from the dictionary using an index.
     *
     * @param index The index of the entry.
     */
    public void removeAt(int index) {
        entries.remove(index);
    }

    /**
     * Removes an entry from the dictionary using the key of the entry.
     *
     * @param key The key of the entry.
     */
    public void remove(K key) {
        IntStream.range(0, entries.size())
                .filter(i -> entries.get(i).key == key)
                .forEach(i -> entries.remove(i));
    }

    /**
     * Gets a value from an entry using the key.
     *
     * @param key The key of the entry.
     * @return The value.
     */
    public V get(K key) {
        return entries.stream()
                .filter(entry -> entry.key == key)
                .findFirst()
                .map(entry -> entry.value)
                .orElse(null);

    }

    /**
     * Returns the current size of the dictionary.
     *
     * @return The current size of the dictionary.
     */
    public int size() {
        return entries.size();
    }

    /**
     * Checks if an entry exists in the dictionary using the key of the entry.
     *
     * @param key The key of the entry.
     * @return If the entry exists or not.
     */
    public boolean exists(K key) {
        return entries.stream()
                .anyMatch(entry -> entry.key == key);
    }

    /**
     * Gets all the keys in the dictionary.
     *
     * @return All the keys in the dictionary.
     */
    public List<K> getKeys() {
        return entries.stream()
                .map(entry -> entry.key)
                .collect(Collectors.toList());
    }

    /**
     * Gets all the values in the dictionary.
     *
     * @return All the values in the dictionary.
     */
    public List<V> getValues() {
        return entries.stream()
                .map(entry -> entry.value)
                .collect(Collectors.toList());
    }

    /**
     * the main attraction of this code, really.
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Dictionary<?,?>){
            Dictionary<K, V> otherDict = (Dictionary<K, V>) obj;

            return this.toString().equals(otherDict.toString());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Entry<K, V> e : entries) {
            builder.append(String.format("%s, %s\n", e.key.toString(), e.value.toString()));
        }

        return builder.toString();
    }
}
