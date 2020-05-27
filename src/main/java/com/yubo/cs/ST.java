package com.yubo.cs;

import java.util.Iterator;
import java.util.Objects;
import java.util.TreeMap;

public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private TreeMap<Key, Value> st;

    public ST() {
        st = new TreeMap<>();
    }

    public void put(Key key, Value value) {
        if (Objects.isNull(key))
            throw new IllegalArgumentException("calls put() with null key");
        if (Objects.isNull(value))
            st.remove(key);
        st.put(key, value);
    }

    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("calls get() with null key");
        return st.get(key);
    }

    public void delete(Key key) {

    }

    public boolean contains(Key key) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public Key min() {
        return null;
    }

    public Key max() {
        return null;
    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }

    public static void main(String[] args) {

    }
}
