package com.example.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory responsible for reusing MarkerStyle objects.
 *
 * Self note:
 * yaha flyweight caching ho rahi hai.
 * agar style already exist kare toh wahi return karo.
 * warna new banao aur cache me daal do.
 */
public class MarkerStyleFactory {

    private static final Map<String, MarkerStyle> cache = new HashMap<>();

    public static MarkerStyle get(String shape, String color, int size, boolean filled) {

        String key = shape + "|" + color + "|" + size + "|" + filled;

        // agar cache me already style hai toh reuse karo
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // warna naya create karo
        MarkerStyle style = new MarkerStyle(shape, color, size, filled);
        cache.put(key, style);

        return style;
    }
}