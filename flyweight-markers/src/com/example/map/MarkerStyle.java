package com.example.map;

/**
 * Flyweight class
 *
 * Self note:
 * ye intrinsic state hai jo multiple markers share karenge.
 * immutable rakhna hai taaki accidental modification na ho.
 */
public class MarkerStyle {

    private final String shape;
    private final String color;
    private final int size;
    private final boolean filled;

    public MarkerStyle(String shape, String color, int size, boolean filled) {
        this.shape = shape;
        this.color = color;
        this.size = size;
        this.filled = filled;
    }

    public String getShape() {
        return shape;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public boolean isFilled() {
        return filled;
    }

    @Override
    public String toString() {
        return shape + "|" + color + "|" + size + "|" + (filled ? "F" : "NF");
    }
}