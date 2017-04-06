package net.company.shape.exception;

/**
 * Throw if the size of shape is less than 0 while {@link net.billjeff.test1.shape.ShapeFactory} builds Shapes.
 */
public class InvalidShapeException extends Exception {
    public InvalidShapeException(String message) {
        super(message);
    }
}
