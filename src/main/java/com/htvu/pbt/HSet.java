package com.htvu.pbt;

import java.util.HashSet;
import java.util.Set;

public class HSet<T> {
    private Set<T> elements;

    public HSet() {
        elements = new HashSet<>();
    }

    public boolean add(T e) {
//        if (elements.size() > 10) return true;
        return elements.add(e);
    }

    public boolean remove(T e) {
        return elements.remove(e);
    }

    public boolean contains(T e) {
        return elements.contains(e);
    }

    public void clear() {
        elements.clear();
    }
}
