package dev.yeff;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @SuppressWarnings("unchecked")
    public void put(K k, V v) {
        entries.add(new Entry<>(k, v));
    }

    public void removeAt(int index) {
        entries.remove(index);
    }

    public void remove(K key) {
        IntStream.range(0, entries.size())
                .filter(i -> entries.get(i).key == key)
                .forEach(i -> entries.remove(i));
    }

    public V get(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.key == key)
                return entry.value;
        }

        return null;
    }

    public int size() {
        return entries.size();
    }

    public boolean exists(K key) {
        for (Entry<K, V> entry : entries)
            if (entry.key == key)
                return true;

        return false;
    }

    public List<K> getKeys() {
        return entries.stream()
                .map(entry -> entry.key)
                .collect(Collectors.toList());
    }

    public List<V> getValues() {
        return entries.stream()
                .map(entry -> entry.value)
                .collect(Collectors.toList());
    }

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
