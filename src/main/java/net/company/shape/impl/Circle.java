package net.company.shape.impl;


import net.company.shape.Shape;
import net.company.shape.Util;
import net.company.shape.exception.InvalidShapeException;
import net.company.visitor.Visitor;

/**
 * Circle shape.
 */
public class Circle implements Shape {
    private final float radius;

    /**
     * Create a {@link Circle} with the specified radius.
     *
     * @param radius Radius of the circle.
     * @throws InvalidShapeException Throw if radius is less than or equal to 0.
     */
    public Circle(float radius) throws InvalidShapeException {
        if (radius <= 0) {
            throw new InvalidShapeException("Radius should be larger than 0. Actual radius: " + radius);
        }

        this.radius = radius;
    }

    public double calculateArea() {
        return Util.circleArea(radius);
    }

    public void accept(Visitor visitor) {
        if (null == visitor) {
            throw new NullPointerException("Visitor is null");
        }

        visitor.visit(this);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Circle[r=").append(radius).append("] with area: ").append(calculateArea());

        return sb.toString();
    }
}
