package com.example.map;

import java.util.HashMap;
import java.util.Map;

public class MarkerStyleFactory {
    private static final Map<String, MarkerStyle> cache = new HashMap<>();

    public static MarkerStyle getStyle(String shape, String color, int size, boolean filled) {
        String key = shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");
        return cache.computeIfAbsent(key, k -> new MarkerStyle(shape, color, size, filled));
    }

    public static int getUniqueStyleCount() {
        return cache.size();
    }
}
