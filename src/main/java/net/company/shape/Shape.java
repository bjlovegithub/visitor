package net.company.shape;

import net.company.visitor.Visitor;

/**
 * Common interface for shapes.
 */
public interface Shape {

    /**
     * Get the shape area.
     *
     * @return The area of shape.
     */
    double calculateArea();

    /**
     * Accept a {@link Visitor} to process current shape.
     *
     * @param visitor A visitor.
     */
    void accept(Visitor visitor);
}
