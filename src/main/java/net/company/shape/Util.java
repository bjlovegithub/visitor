package net.company.shape;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

/**
 * Utilities
 */
public class Util {
    /**
     * Calculate the area for a triangle based on the length of three edges.
     */
    public static double triangleArea(float a, float b, float c) {
        double mid = (a + b + c) / 2;

        return sqrt(mid * (mid - a) * (mid - b) * (mid - c));
    }

    /**
     * Calculate the area of a circle.
     */
    public static double circleArea(float radius) {
        return radius * radius * PI;
    }
}
