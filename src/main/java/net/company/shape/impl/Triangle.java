package net.company.shape.impl;

import net.company.shape.Shape;
import net.company.shape.Util;
import net.company.shape.exception.InvalidShapeException;
import net.company.visitor.Visitor;

/**
 * Triangle shape.
 */
public class Triangle implements Shape {
    /** Length of three edges */
    private final float leftEdge;
    private final float rightEdge;
    private final float bottomEdge;

    /**
     * Create a {@link Triangle} with the specified edges.
     *
     * @param leftEdge Triangle edge.
     * @param rightEdge Triangle edge.
     * @param bottomEdge Triangle edge.
     * @throws InvalidShapeException Throw if length of any edge is less than or equal to 0.
     */
    public Triangle(float leftEdge, float rightEdge, float bottomEdge) throws InvalidShapeException {
        if (leftEdge <= 0 || rightEdge <= 0 || bottomEdge <= 0) {
            throw new InvalidShapeException("Triangle edge should be larger than 0. Actual edge length: " + leftEdge + ", " + rightEdge + ", " + bottomEdge);
        }

        if (leftEdge + rightEdge <= bottomEdge || leftEdge + bottomEdge <= rightEdge || rightEdge + bottomEdge <= leftEdge) {
            throw new InvalidShapeException("Can not form a triangle. Edge length: " + leftEdge + ", " + rightEdge + ", " + bottomEdge);
        }

        this.leftEdge = leftEdge;
        this.rightEdge = rightEdge;
        this.bottomEdge = bottomEdge;
    }

    public double calculateArea() {
        return Util.triangleArea(leftEdge, rightEdge, bottomEdge);
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
        sb.append("Triangle[").append(leftEdge).append(", ").append(rightEdge).append(", ").append(bottomEdge)
                .append("] with area: ").append(calculateArea());

        return sb.toString();
    }
}
