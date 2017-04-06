package net.company.visitor;

import net.company.shape.impl.Circle;
import net.company.shape.impl.Rectangle;
import net.company.shape.impl.Triangle;

/**
 * Interface for shape visitors.
 */
public interface Visitor {
    /**
     * Visit a circle.
     *
     * @param circle A circle.
     */
    void visit(Circle circle);

    /**
     * Visit a rectangle.
     *
     * @param rectangle A rectangle.
     */
    void visit(Rectangle rectangle);

    /**
     * Visit a triangle.
     *
     * @param triangle A triangle.
     */
    void visit(Triangle triangle);
}
