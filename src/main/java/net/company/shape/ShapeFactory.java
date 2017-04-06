package net.company.shape;

import net.company.shape.exception.InvalidShapeException;
import net.company.shape.impl.Circle;
import net.company.shape.impl.Rectangle;
import net.company.shape.impl.Triangle;

/**
 * ShapeFactory is used to create all kinds of {@link Shape}s.
 */
public class ShapeFactory {
    private static final int NUMBER_OF_SHAPE_TYPES = 3;

    /**
     * Create a {@link Circle}. See also {@link Circle#Circle(float)}.
     */
    public static Circle createCircle(float radius) throws InvalidShapeException {
        return new Circle(radius);
    }

    /**
     * Create a {@link Rectangle}. See also {@link Rectangle#Rectangle(float, float)}.
     */
    public static Rectangle createRectangle(float length, float width) throws InvalidShapeException {
        return new Rectangle(length, width);
    }

    /**
     * Create a {@link Triangle}. See also {@link Triangle#Triangle(float, float, float)}.
     */
    public static Triangle createTriangle(float leftEdge, float rightEdge, float bottomEdge) throws InvalidShapeException {
        return new Triangle(leftEdge, rightEdge, bottomEdge);
    }

    public static int getNumberOfShapeTypes() {
        return NUMBER_OF_SHAPE_TYPES;
    }

    private ShapeFactory() {}
}
