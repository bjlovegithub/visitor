package net.company.shape.impl;


import net.company.shape.Shape;
import net.company.shape.exception.InvalidShapeException;
import net.company.visitor.Visitor;

/**
 * Rectangle shape.
 */
public class Rectangle implements Shape {
    private final float length;
    private final float width;

    /**
     * Create a {@link Rectangle} with the specified length and width.
     *
     * @param length Rectangle length.
     * @param width Rectangle width.
     * @throws InvalidShapeException Throw if length or width is less than or equal to 0.
     */
    public Rectangle(float length, float width) throws InvalidShapeException {
        if (length <= 0 || width <= 0) {
            throw new InvalidShapeException("Length or width should be larger than 0. Actual length: " + length + ", width: " + width);
        }

        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
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
        sb.append("Rectangle[").append(length).append(", ").append(width).append("] with area: ").append(calculateArea());

        return sb.toString();
    }
}
