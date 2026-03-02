package com.example.metrics;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Proper Singleton implementation using Static Holder pattern.
 */
public final class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // ====== Hinglish Note ======
    // INSTANCE ko directly static initialize nahi kiya
    // Instead, static holder class use kar rahe hain
    // JVM guarantees thread-safe initialization
    // ============================

    private final Map<String, Long> counters = new HashMap<>();

    // Flag to block reflection attack
    private static boolean instanceCreated = false;

    // 🔒 Private constructor
    private MetricsRegistry() {

        // Hinglish:
        // Agar koi reflection se dobara constructor call kare
        // aur instance already create ho chuka ho
        // toh exception throw karenge

        if (instanceCreated) {
            throw new RuntimeException("Singleton already created. Use getInstance()");
        }

        instanceCreated = true;
    }

    // Static Holder pattern
    private static class Holder {
        private static final MetricsRegistry INSTANCE = new MetricsRegistry();
    }

    public static MetricsRegistry getInstance() {
        return Holder.INSTANCE;
    }

    // ===== Business methods =====

    public synchronized void setCount(String key, long value) {
        counters.put(key, value);
    }

    public synchronized void increment(String key) {
        counters.put(key, getCount(key) + 1);
    }

    public synchronized long getCount(String key) {
        return counters.getOrDefault(key, 0L);
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }

    // ===== Serialization protection =====

    // Hinglish:
    // Deserialization ke time JVM naya object banata hai
    // readResolve ensure karega ki wahi singleton return ho

    @Serial
    private Object readResolve() {
        return getInstance();
    }
}